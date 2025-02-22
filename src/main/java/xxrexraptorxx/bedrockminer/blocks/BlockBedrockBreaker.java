package xxrexraptorxx.bedrockminer.blocks;

import com.mojang.serialization.MapCodec;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.redstone.Orientation;
import xxrexraptorxx.bedrockminer.registry.ModBlocks;
import xxrexraptorxx.bedrockminer.registry.ModItems;
import xxrexraptorxx.bedrockminer.registry.ModTags;
import xxrexraptorxx.bedrockminer.utils.Config;

import javax.annotation.Nullable;
import java.util.List;

public class BlockBedrockBreaker extends DirectionalBlock {

    public static final EnumProperty<Direction> FACING;
    public static final BooleanProperty POWERED;
    public static final MapCodec<BlockBedrockBreaker> CODEC = simpleCodec(BlockBedrockBreaker::new);

    public BlockBedrockBreaker(Properties properties) {
        super(properties);

        this.registerDefaultState((BlockState)((BlockState)((BlockState)this.stateDefinition.any()).setValue(FACING, Direction.DOWN)).setValue(POWERED, false));
    }


    @Override
    public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> list, TooltipFlag flag) {
        list.add(Component.translatable("message.bedrockminer.bedrock_breaker.desc").withStyle(ChatFormatting.GRAY));
    }


    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(new Property[]{FACING, POWERED});
    }


    @Override
    public BlockState rotate(BlockState pState, Rotation pRot) {
        return (BlockState)pState.setValue(FACING, pRot.rotate((Direction)pState.getValue(FACING)));
    }


    @Override
    public BlockState mirror(BlockState pState, Mirror pMirror) {
        return pState.rotate(pMirror.getRotation((Direction)pState.getValue(FACING)));
    }


    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(FACING, context.getNearestLookingVerticalDirection().getOpposite().getOpposite())
                .setValue(POWERED, Boolean.valueOf(context.getLevel().hasNeighborSignal(context.getClickedPos())));
    }


    @Override
    public void tick(BlockState state, ServerLevel level, BlockPos pos, RandomSource rand) {
        if (state.getValue(POWERED) && !level.hasNeighborSignal(pos)) {
            level.setBlock(pos, state.cycle(POWERED), 2);
        }
    }


    @Override
    public void neighborChanged(BlockState state, Level level, BlockPos pos, Block neighborBlock, @Nullable Orientation orientation, boolean movedByPiston) {
        if (!level.isClientSide) {

            boolean flag = state.getValue(POWERED);

            //test if block is powered
            if (flag != level.hasNeighborSignal(pos)) {
                //contract
                if (flag) {
                    level.scheduleTick(pos, this, 4);
                    level.playSound((Player)null, pos, SoundEvents.PISTON_CONTRACT, SoundSource.BLOCKS, 0.5F, level.random.nextFloat() * 0.15F + 0.F);
                    level.gameEvent(GameEvent.BLOCK_DEACTIVATE, pos, GameEvent.Context.of(state));

                } else {
                    //extend
                    BlockPos harvestBlockPos = state.getValue(DirectionalBlock.FACING).equals(Direction.DOWN) ? pos.below() : pos.above();
                    BlockPos dropPos = state.getValue(DirectionalBlock.FACING).equals(Direction.DOWN) ? pos.above() : pos.below();
                    Block harvestblock = level.getBlockState(harvestBlockPos).getBlock();

                    level.playSound((Player)null, pos, SoundEvents.PISTON_EXTEND, SoundSource.BLOCKS, 0.5F, level.random.nextFloat() * 0.15F + 0.F);
                    level.setBlock(pos, state.cycle(POWERED), 2);
                    level.gameEvent(GameEvent.BLOCK_ACTIVATE, pos, GameEvent.Context.of(state));

                    //test is block is valid
                    if (isValidBlock(harvestblock)) {
                        level.playSound(null, pos, SoundEvents.STONE_BREAK, SoundSource.BLOCKS, 0.5F, level.random.nextFloat() * 0.15F);

                        //test if block is vanilla bedrock [required because bedrock has no drops]
                        if (harvestblock == Blocks.BEDROCK) {
                            //destroy and drop the block [workaround]
                            ItemEntity item = new ItemEntity(level, (double)dropPos.getX() + 0.5F, (double)dropPos.getY(), (double)dropPos.getZ() + 0.5F, new ItemStack(harvestblock, 1));
                            level.addFreshEntity(item);

                        //every other valid block
                        } else {
                            //get the block drops
                            List<ItemStack> drops = Block.getDrops(harvestblock.defaultBlockState(), (ServerLevel) level, harvestBlockPos, null, null, new ItemStack(ModItems.BEDROCK_PICKAXE.get()));
                            for (ItemStack drop : drops) {
                                //spawn drops
                                Block.popResource(level, dropPos, drop);
                            }
                        }
                        //destroy the harvested block
                        level.destroyBlock(harvestBlockPos, false);
                        level.addDestroyBlockEffect(pos, harvestblock.defaultBlockState());

                    } else {
                        level.playSound((Player)null, pos, SoundEvents.ITEM_BREAK, SoundSource.BLOCKS, 0.5F, level.random.nextFloat() * 0.15F + 0.F);
                    }
                }
            }
        }
    }


    private static boolean isValidBlock(Block block) {
        if (Config.HARVEST_ONLY_BEDROCK.get()) {
            return (block == Blocks.BEDROCK || block == ModBlocks.FAKE_BEDROCK.get());
        }

        return !(block.defaultBlockState().is(BlockTags.AIR) || block.defaultBlockState().is(ModTags.BEDROCK_BREAKER_IMMUNE));
    }


    @Override
    protected MapCodec<? extends DirectionalBlock> codec() {
        return CODEC;
    }


    static {
        FACING = BlockStateProperties.FACING;
        POWERED = BlockStateProperties.POWERED;
    }
}
