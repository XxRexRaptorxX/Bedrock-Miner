package xxrexraptorxx.bedrockminer.blocks;

import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;

public class BlockFakeBedrock extends Block {

    public BlockFakeBedrock() {
        super(Properties.of()
                .strength(150.0F, 3600000.0F)
                .sound(SoundType.STONE)
                .mapColor(MapColor.STONE)
                .instrument(NoteBlockInstrument.BASEDRUM)
                .pushReaction(PushReaction.BLOCK)
                .isValidSpawn((state, level, pos, value) -> false)
        );
    }


    @Override
    public MutableComponent getName() {
        return Blocks.BEDROCK.getName();
    }



}
