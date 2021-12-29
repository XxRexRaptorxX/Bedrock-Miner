package xxrexraptorxx.bedrockminer.blocks;

import com.mojang.realmsclient.gui.ChatFormatting;
import javafx.geometry.Pos;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.IProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;
import xxrexraptorxx.bedrockminer.utils.Config;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Random;

public class BlockBedrockBreaker extends Block {

    public static final IProperty<Boolean> ON = BooleanProperty.create("on");


    public BlockBedrockBreaker() {
        super(Properties.create(Material.ROCK, MaterialColor.GRAY)
            .harvestTool(ToolType.PICKAXE)
            .harvestLevel(1)
            .hardnessAndResistance(5.0F, 10.0F)
            .sound(SoundType.STONE)
        );

        setRegistryName("bedrock_breaker");
        setDefaultState(getStateContainer().getBaseState().with(ON, false));
    }


    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(ON);
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return getDefaultState();
    }


    @Override
    public BlockRenderLayer getRenderLayer() {
        return BlockRenderLayer.CUTOUT;
    }


    @Override
    public void addInformation(ItemStack stack, @Nullable IBlockReader worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add(new StringTextComponent(ChatFormatting.GRAY + "Needs redstone power."));
    }


    @Override
    public void neighborChanged(BlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos, boolean isMoving) {
        if (!worldIn.isRemote) {
            boolean flag = state.get(ON);
            if (flag != worldIn.isBlockPowered(pos)) {
                if (flag) {
                    worldIn.getPendingBlockTicks().scheduleTick(pos, this, 4);
                } else {
                    worldIn.playSound((PlayerEntity)null, pos, SoundEvents.BLOCK_PISTON_EXTEND, SoundCategory.BLOCKS, 0.3F, 1.4F);
                    worldIn.setBlockState(pos, state.cycle(ON), 2);


                    Block harvestblock = worldIn.getBlockState(pos.down()).getBlock();

                    if (harvestblock == Blocks.BEDROCK) {
                        if (!worldIn.isRemote) {
                            worldIn.destroyBlock(pos.down(), false);
                            ItemEntity item = new ItemEntity(worldIn, (double)pos.getX() + 0.5D, (double)pos.getY() + 1.5D, (double)pos.getZ() + 0.5D, new ItemStack(Blocks.BEDROCK, 1));
                            worldIn.addEntity(item);
                        }
                    }

                    if (harvestblock == Blocks.END_PORTAL_FRAME) {
                        if (!worldIn.isRemote) {
                            worldIn.destroyBlock(pos.down(), false);
                            ItemEntity item = new ItemEntity(worldIn, (double)pos.getX() + 0.5D, (double)pos.getY() + 1.5D, (double)pos.getZ() + 0.5D, new ItemStack(Blocks.END_PORTAL_FRAME, 1));
                            worldIn.addEntity(item);
                        }
                    }

                    if (!Config.HARVEST_OPERATOR_STUFF.get() && harvestblock == Blocks.COMMAND_BLOCK || harvestblock == Blocks.CHAIN_COMMAND_BLOCK || harvestblock == Blocks.REPEATING_COMMAND_BLOCK || harvestblock == Blocks.STRUCTURE_BLOCK || harvestblock == Blocks.STRUCTURE_VOID) {
                        if (!worldIn.isRemote) {
                            worldIn.destroyBlock(pos.down(), false);
                            ItemEntity item = new ItemEntity(worldIn, (double)pos.getX() + 0.5D, (double)pos.getY() + 1.5D, (double)pos.getZ() + 0.5D, new ItemStack(Items.REDSTONE, 5));
                            worldIn.addEntity(item);
                        }

                    } else {
                        if (!worldIn.isRemote) {
                            BlockPos posX = new BlockPos((double)pos.getX() + 0.5D, (double)pos.getY() + 1.5D, (double)pos.getZ() + 0.5D);
                            worldIn.setBlockState(pos.down(), Blocks.AIR.getDefaultState(), 11);
                            spawnAsEntity(worldIn, posX, new ItemStack(harvestblock, 1));
                        }
                    }
                }
            }
        }
    }


    @Override
    public void tick(BlockState state, World worldIn, BlockPos pos, Random random) {
        if (!worldIn.isRemote) {
            if (state.get(ON) && !worldIn.isBlockPowered(pos)) {
                worldIn.playSound((PlayerEntity)null, pos, SoundEvents.BLOCK_PISTON_CONTRACT, SoundCategory.BLOCKS, 0.3F, 1.4F);
                worldIn.setBlockState(pos, state.cycle(ON), 2);
            }

        }
    }


    @Override
    public void onBlockAdded(BlockState state, World worldIn, BlockPos pos, BlockState oldState, boolean isMoving) {
        super.onBlockAdded(state, worldIn, pos, oldState, isMoving);
    }
}
