package xxrexraptorxx.bedrockminer.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.block.material.PushReaction;
import net.minecraftforge.common.ToolType;

public class BlockBedrockInfusedStone extends Block {
    public BlockBedrockInfusedStone() {
        super(Properties.create(Material.ROCK, MaterialColor.BLACK)
                .harvestTool(ToolType.PICKAXE)
                .harvestLevel(3)
                .hardnessAndResistance(80, 1800)
                .sound(SoundType.STONE)
        );

        setRegistryName("bedrock_infused_stone");
    }


    @Override
    public PushReaction getPushReaction(BlockState state) {
        return PushReaction.BLOCK;
    }

}
