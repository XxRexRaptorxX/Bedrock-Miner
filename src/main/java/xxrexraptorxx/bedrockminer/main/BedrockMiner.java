package xxrexraptorxx.bedrockminer.main;

import net.minecraft.block.Block;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLPaths;
import net.minecraftforge.registries.ObjectHolder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import xxrexraptorxx.bedrockminer.blocks.BlockBedrockBreaker;
import xxrexraptorxx.bedrockminer.blocks.BlockBedrockInfusedObsidian;
import xxrexraptorxx.bedrockminer.blocks.BlockBedrockInfusedStone;
import xxrexraptorxx.bedrockminer.items.ItemArmor;
import xxrexraptorxx.bedrockminer.items.ItemBasic;
import xxrexraptorxx.bedrockminer.setup.ClientProxy;
import xxrexraptorxx.bedrockminer.setup.IProxy;
import xxrexraptorxx.bedrockminer.setup.ServerProxy;
import xxrexraptorxx.bedrockminer.utils.ItemGroup;
import xxrexraptorxx.bedrockminer.utils.*;
import xxrexraptorxx.bedrockminer.world.Events;
import xxrexraptorxx.bedrockminer.world.OreGenerator;

/**
 * @author XxRexRaptorxX (RexRaptor)
 * @projectPage https://www.curseforge.com/minecraft/mc-mods/bedrock-miner
 **/

@Mod(References.MODID)
@ObjectHolder(References.MODID)
public class BedrockMiner {

    public static ItemGroup setup = new ItemGroup();
    private static final Logger LOGGER = LogManager.getLogger();
    public static IProxy proxy = DistExecutor.runForDist(() -> () -> new ClientProxy(), () -> () -> new ServerProxy());


    public BedrockMiner() {
        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, Config.CLIENT_CONFIG);
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.COMMON_CONFIG);

        // Register the setup method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);

        Config.loadConfig(Config.CLIENT_CONFIG, FMLPaths.CONFIGDIR.get().resolve(References.MODID + "-client.toml"));
        Config.loadConfig(Config.COMMON_CONFIG, FMLPaths.CONFIGDIR.get().resolve(References.MODID + "-common.toml"));
    }


    private void setup(final FMLCommonSetupEvent event) {
        setup.init();
        proxy.init();

        UpdateChecker.checkForUpdates();
        MinecraftForge.EVENT_BUS.register(new Events());
        OreGenerator.setupOreGeneration();

        LOGGER.info("Setup method registered.");
    }





    @Mod.EventBusSubscriber(bus =  Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {

        @SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Block> event) {

            final Block[] blocks = {
                    new BlockBedrockBreaker(),
                    new BlockBedrockInfusedStone(),
                    new BlockBedrockInfusedObsidian()

            };

            event.getRegistry().registerAll(blocks);
            LOGGER.info("Blocks registered.");
        }


        @SubscribeEvent
        public static void onItemsRegistry(final RegistryEvent.Register<Item> event) {
            Item.Properties properties = new Item.Properties()
                    .group(setup.mainGroup);

            event.getRegistry().register(new BlockItem(ModBlocks.BEDROCK_BREAKER, properties).setRegistryName("bedrock_breaker"));
            event.getRegistry().register(new BlockItem(ModBlocks.BEDROCK_INFUSED_STONE, properties).setRegistryName("bedrock_infused_stone"));
            event.getRegistry().register(new BlockItem(ModBlocks.BEDROCK_INFUSED_OBSIDIAN, properties).setRegistryName("bedrock_infused_obsidian"));

            LOGGER.info("BlocksItems registered.");


            final Item[] items = {

                    new ItemBasic().setRegistryName("bedrock_chunk"),

                    new SwordItem(ToolMaterials.bedrockTM, 3, -2.4f, new Item.Properties().group(setup.mainGroup)).setRegistryName("bedrock_sword"),
                    new PickaxeItem(ToolMaterials.bedrockTM, 1, -2.8f, new Item.Properties().group(setup.mainGroup)).setRegistryName("bedrock_pickaxe"),
                    new AxeItem(ToolMaterials.bedrockTM, 5, -3.0f, new Item.Properties().group(setup.mainGroup)).setRegistryName("bedrock_axe"),
                    new ShovelItem(ToolMaterials.bedrockTM, 1, -3.0f, new Item.Properties().group(setup.mainGroup)).setRegistryName("bedrock_shovel"),
                    new HoeItem(ToolMaterials.bedrockTM, 0, new Item.Properties().group(setup.mainGroup)).setRegistryName("bedrock_hoe"),

                    new ItemArmor(ArmorMaterials.bedrockAM, EquipmentSlotType.HEAD, new Item.Properties().group(setup.mainGroup)).setRegistryName("bedrock_helmet"),
                    new ItemArmor(ArmorMaterials.bedrockAM, EquipmentSlotType.CHEST, new Item.Properties().group(setup.mainGroup)).setRegistryName("bedrock_chestplate"),
                    new ItemArmor(ArmorMaterials.bedrockAM, EquipmentSlotType.LEGS, new Item.Properties().group(setup.mainGroup)).setRegistryName("bedrock_leggings"),
                    new ItemArmor(ArmorMaterials.bedrockAM, EquipmentSlotType.FEET, new Item.Properties().group(setup.mainGroup)).setRegistryName("bedrock_boots"),
            };

            event.getRegistry().registerAll(items);
            LOGGER.info("Items registered.");
        }

    }
}
