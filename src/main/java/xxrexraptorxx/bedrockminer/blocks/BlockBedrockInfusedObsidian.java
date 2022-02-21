package xxrexraptorxx.bedrockminer.blocks;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraft.world.level.material.PushReaction;

public class BlockBedrockInfusedObsidian extends Block {

    public BlockBedrockInfusedObsidian() {
        super(Properties.of(Material.STONE)
                .strength(100, 4000)
                .sound(SoundType.STONE)
                .color(MaterialColor.COLOR_BLACK)
        );
    }


    @Override
    public PushReaction getPistonPushReaction(BlockState pState) {
        return PushReaction.BLOCK;
    }

}
