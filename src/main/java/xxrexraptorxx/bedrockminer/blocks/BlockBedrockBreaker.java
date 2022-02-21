package xxrexraptorxx.bedrockminer.blocks;

import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import xxrexraptorxx.bedrockminer.utils.Config;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Random;

public class BlockBedrockBreaker extends Block {

    public static final BooleanProperty POWERED = BlockStateProperties.POWERED;


    public BlockBedrockBreaker() {
        super(Properties.of(Material.STONE)
                .strength(5, 10)
                .sound(SoundType.STONE)
                .color(MaterialColor.COLOR_GRAY)
        );
        this.registerDefaultState(this.defaultBlockState().setValue(POWERED, Boolean.valueOf(false)));
    }


    @Override
    public void appendHoverText(ItemStack pStack, @Nullable BlockGetter pLevel, List<Component> list, TooltipFlag pFlag) {
        list.add(new TranslatableComponent("message.bedrockminer.bedrock_breaker.desc").withStyle(ChatFormatting.GRAY));
    }


    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(POWERED);
    }


    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        return this.defaultBlockState().setValue(POWERED, Boolean.valueOf(pContext.getLevel().hasNeighborSignal(pContext.getClickedPos())));
    }


    @Override
    public void tick(BlockState pState, ServerLevel pLevel, BlockPos pPos, Random pRand) {
        if (pState.getValue(POWERED) && !pLevel.hasNeighborSignal(pPos)) {
            pLevel.setBlock(pPos, pState.cycle(POWERED), 2);
        }
    }


    @Override
    public void neighborChanged(BlockState state, Level level, BlockPos pos, Block block, BlockPos fromPos, boolean isMoving) {
        if (!level.isClientSide) {
            boolean flag = state.getValue(POWERED);

            if (flag != level.hasNeighborSignal(pos)) {
                if (flag) {
                    level.scheduleTick(pos, this, 4);

                } else {
                    level.playSound((Player)null, pos, SoundEvents.PISTON_EXTEND, SoundSource.BLOCKS, 0.5F, level.random.nextFloat() * 0.15F + 0.F);

                    Block harvestblock = level.getBlockState(pos.below()).getBlock();

                    if (isValidBlock(harvestblock)) {
                        ItemEntity item = new ItemEntity(level, (double)pos.getX() + 0.5D, (double)pos.getY() + 1.5D, (double)pos.getZ() + 0.5D, new ItemStack(harvestblock, 1));
                        level.addFreshEntity(item);
                        level.destroyBlock(pos.below(), false);
                        level.addDestroyBlockEffect(pos, harvestblock.defaultBlockState());

                    } else {
                        level.playSound((Player)null, pos, SoundEvents.METAL_PRESSURE_PLATE_CLICK_ON, SoundSource.BLOCKS, 0.5F, level.random.nextFloat() * 0.15F + 0.F);
                    }
                }
            }

        }
    }


    private static boolean isValidBlock(Block block) {
        if (Config.HARVEST_ONLY_BEDROCK.get() && block.equals(Blocks.BEDROCK)) {
            return true;

        } else if (Config.HARVEST_OPERATOR_STUFF.get()) {
            if (block.equals(Blocks.COMMAND_BLOCK) || block.equals(Blocks.CHAIN_COMMAND_BLOCK) || block.equals(Blocks.REPEATING_COMMAND_BLOCK) || block.equals(Blocks.STRUCTURE_BLOCK) ||
                    block.equals(Blocks.STRUCTURE_VOID) || block.equals(Blocks.BARRIER)) {
                return true;
            }
        }
        return false;
    }

}
