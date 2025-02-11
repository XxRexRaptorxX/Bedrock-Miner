package xxrexraptorxx.bedrockminer.blocks;

import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import xxrexraptorxx.bedrockminer.registry.ModBlocks;

public class BlockFakeBedrock extends Block {

    public BlockFakeBedrock(Properties properties) {
        super(properties);
    }

    @Override
    public MutableComponent getName() {
        return Blocks.BEDROCK.getName();
    }

}
