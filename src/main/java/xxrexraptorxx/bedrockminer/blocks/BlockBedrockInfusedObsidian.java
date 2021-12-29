package xxrexraptorxx.bedrockminer.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.block.material.PushReaction;
import net.minecraft.entity.Entity;
import net.minecraft.entity.boss.WitherEntity;
import net.minecraft.entity.boss.dragon.EnderDragonEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.ToolType;
import xxrexraptorxx.bedrockminer.main.ModBlocks;
import xxrexraptorxx.bedrockminer.main.ModItems;

public class BlockBedrockInfusedObsidian extends Block {
    public BlockBedrockInfusedObsidian() {
        super(Properties.create(Material.ROCK, MaterialColor.BLACK)
            .harvestTool(ToolType.PICKAXE)
            .harvestLevel(3)
            .hardnessAndResistance(100, 4000)
            .sound(SoundType.STONE)
        );

        setRegistryName("bedrock_infused_obsidian");
    }


    @Override
    public PushReaction getPushReaction(BlockState state) {
        return PushReaction.BLOCK;
    }


    @Override
    public boolean canEntityDestroy(BlockState state, IBlockReader world, BlockPos pos, Entity entity) {
        if (entity instanceof WitherEntity) {
            return this != ModBlocks.BEDROCK_INFUSED_OBSIDIAN;
        }
        else if (entity instanceof EnderDragonEntity) {
            return this != ModBlocks.BEDROCK_INFUSED_OBSIDIAN;
        }
        return true;
    }
}
