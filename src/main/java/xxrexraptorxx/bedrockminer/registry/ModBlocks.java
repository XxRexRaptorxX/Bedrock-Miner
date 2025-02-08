package xxrexraptorxx.bedrockminer.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import xxrexraptorxx.bedrockminer.blocks.BlockBedrockBreaker;
import xxrexraptorxx.bedrockminer.blocks.BlockBedrockInfusedObsidian;
import xxrexraptorxx.bedrockminer.blocks.BlockFakeBedrock;
import xxrexraptorxx.bedrockminer.main.References;

public class ModBlocks {

    private static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(References.MODID);
    private static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(References.MODID);

    public static void init(IEventBus bus) {
        BLOCKS.register(bus);
        ITEMS.register(bus);
    }

    public static final DeferredBlock<BlockBedrockInfusedObsidian> BEDROCK_INFUSED_OBSIDIAN = BLOCKS.register("bedrock_infused_obsidian", BlockBedrockInfusedObsidian::new);
    public static final DeferredItem<Item> BEDROCK_INFUSED_OBSIDIAN_BLOCKITEM = ITEMS.register("bedrock_infused_obsidian", () -> new BlockItem(BEDROCK_INFUSED_OBSIDIAN.get(), new Item.Properties().setId(ModItems.itemId("bedrock_infused_obsidian"))));

    public static final DeferredBlock<BlockBedrockBreaker> BEDROCK_BREAKER = BLOCKS.registerBlock("bedrock_breaker", BlockBedrockBreaker::new);
    public static final DeferredItem<Item> BEDROCK_BREAKER_BLOCKITEM = ITEMS.register("bedrock_breaker", () -> new BlockItem(BEDROCK_BREAKER.get(), new Item.Properties().setId(ModItems.itemId("bedrock_breaker"))));

    public static final DeferredBlock<BlockFakeBedrock> FAKE_BEDROCK = BLOCKS.register("fake_bedrock", BlockFakeBedrock::new);
    public static final DeferredItem<Item> FAKE_BEDROCK_BLOCKITEM = ITEMS.register("fake_bedrock", () -> new BlockItem(FAKE_BEDROCK.get(), new Item.Properties().setId(ModItems.itemId("fake_bedrock"))));


    public static ResourceKey<Block> blockId(String name) {
        return ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(References.MODID, name));
    }
}
