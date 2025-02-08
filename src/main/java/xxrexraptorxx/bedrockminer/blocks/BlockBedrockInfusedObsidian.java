package xxrexraptorxx.bedrockminer.blocks;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import xxrexraptorxx.bedrockminer.registry.ModBlocks;

public class BlockBedrockInfusedObsidian extends Block {

    public BlockBedrockInfusedObsidian() {
        super(Properties.of()
                .setId(ModBlocks.blockId("bedrock_infused_obsidian"))
                .strength(100, 4000)
                .sound(SoundType.STONE)
                .mapColor(MapColor.COLOR_BLACK)
                .pushReaction(PushReaction.BLOCK)
        );
    }

}
