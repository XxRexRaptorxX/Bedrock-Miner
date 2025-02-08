package xxrexraptorxx.bedrockminer.blocks;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import xxrexraptorxx.bedrockminer.registry.ModBlocks;

public class BlockBedrockInfusedStone extends Block {

    public BlockBedrockInfusedStone() {
        super(Properties.of()
                .setId(ModBlocks.blockId("bedrock_infused_stone"))
                .strength(80, 1800)
                .sound(SoundType.STONE)
                .mapColor(MapColor.COLOR_BLACK)
                .pushReaction(PushReaction.BLOCK)
        );
    }

}
