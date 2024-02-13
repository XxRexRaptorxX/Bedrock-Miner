package xxrexraptorxx.bedrockminer.main;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import xxrexraptorxx.bedrockminer.blocks.BlockBedrockBreaker;
import xxrexraptorxx.bedrockminer.blocks.BlockBedrockInfusedObsidian;
import xxrexraptorxx.bedrockminer.blocks.BlockFakeBedrock;
import xxrexraptorxx.bedrockminer.utils.CreativeTab;

public class ModBlocks {

    private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, References.MODID);
    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, References.MODID);

    public static void init() {
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }


    //public static final RegistryObject<BlockBedrockInfusedStone> BEDROCK_INFUSED_STONE = BLOCKS.register("bedrock_infused_stone", BlockBedrockInfusedStone::new);
    //public static final RegistryObject<Item> BEDROCK_INFUSED_STONE_BLOCKITEM = ITEMS.register("bedrock_infused_stone", () -> new BlockItem(BEDROCK_INFUSED_STONE.get(), new Item.Properties().tab(CreativeTab.MOD_TAB)));

    public static final RegistryObject<BlockBedrockInfusedObsidian> BEDROCK_INFUSED_OBSIDIAN = BLOCKS.register("bedrock_infused_obsidian", BlockBedrockInfusedObsidian::new);
    public static final RegistryObject<Item> BEDROCK_INFUSED_OBSIDIAN_BLOCKITEM = ITEMS.register("bedrock_infused_obsidian", () -> new BlockItem(BEDROCK_INFUSED_OBSIDIAN.get(), new Item.Properties().tab(CreativeTab.MOD_TAB)));

    public static final RegistryObject<BlockBedrockBreaker> BEDROCK_BREAKER = BLOCKS.register("bedrock_breaker", BlockBedrockBreaker::new);
    public static final RegistryObject<Item> BEDROCK_BREAKER_BLOCKITEM = ITEMS.register("bedrock_breaker", () -> new BlockItem(BEDROCK_BREAKER.get(), new Item.Properties().tab(CreativeTab.MOD_TAB)));

    public static final RegistryObject<BlockFakeBedrock> FAKE_BEDROCK = BLOCKS.register("fake_bedrock", BlockFakeBedrock::new);
    public static final RegistryObject<Item> FAKE_BEDROCK_BLOCKITEM = ITEMS.register("fake_bedrock", () -> new BlockItem(FAKE_BEDROCK.get(), new Item.Properties()));

}
