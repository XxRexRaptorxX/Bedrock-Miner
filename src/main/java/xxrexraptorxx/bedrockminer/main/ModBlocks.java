package xxrexraptorxx.bedrockminer.main;

import net.minecraftforge.registries.ObjectHolder;
import xxrexraptorxx.bedrockminer.blocks.BlockBedrockBreaker;
import xxrexraptorxx.bedrockminer.blocks.BlockBedrockInfusedObsidian;
import xxrexraptorxx.bedrockminer.blocks.BlockBedrockInfusedStone;
import xxrexraptorxx.bedrockminer.items.ItemBasic;

public class ModBlocks {

    @ObjectHolder(References.MODID + ":bedrock_infused_obsidian")
    public static BlockBedrockInfusedObsidian BEDROCK_INFUSED_OBSIDIAN;

    @ObjectHolder(References.MODID + ":bedrock_infused_stone")
    public static BlockBedrockInfusedStone BEDROCK_INFUSED_STONE;

    @ObjectHolder(References.MODID + ":bedrock_breaker")
    public static BlockBedrockBreaker BEDROCK_BREAKER;
}
