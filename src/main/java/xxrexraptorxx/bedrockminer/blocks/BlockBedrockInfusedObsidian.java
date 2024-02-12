package xxrexraptorxx.bedrockminer.blocks;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;

public class BlockBedrockInfusedObsidian extends Block {
    public BlockBedrockInfusedObsidian() {
        super(Properties.of()
                .strength(100, 4000)
                .sound(SoundType.STONE)
                .mapColor(MapColor.COLOR_BLACK)
                .pushReaction(PushReaction.BLOCK)
        );
    }

}
