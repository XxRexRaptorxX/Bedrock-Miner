package xxrexraptorxx.bedrockminer.blocks;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;

public class BlockBedrockInfusedStone extends Block {
    public BlockBedrockInfusedStone() {
        super(Properties.of()
                .strength(80, 1800)
                .sound(SoundType.STONE)
                .mapColor(MapColor.COLOR_BLACK)
                .pushReaction(PushReaction.BLOCK)
        );
    }

}
