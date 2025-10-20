package xxrexraptorxx.bedrockminer.blocks;

import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

public class BlockFakeBedrock extends Block {

    public BlockFakeBedrock(Properties properties) {
        super(properties);
    }


    @Override
    public MutableComponent getName() {
        return Blocks.BEDROCK.getName();
    }

}
