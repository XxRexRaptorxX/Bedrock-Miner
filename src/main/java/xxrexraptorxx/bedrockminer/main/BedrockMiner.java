package xxrexraptorxx.bedrockminer.main;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import xxrexraptorxx.bedrockminer.registry.CreativeTabs;
import xxrexraptorxx.bedrockminer.registry.ModBlocks;
import xxrexraptorxx.bedrockminer.registry.ModItems;
import xxrexraptorxx.bedrockminer.registry.ModLootModifiers;
import xxrexraptorxx.bedrockminer.utils.Config;
import xxrexraptorxx.magmacore.config.ConfigHelper;
import xxrexraptorxx.magmacore.main.ModRegistry;

/**
 * @author XxRexRaptorxX (RexRaptor)
 * @projectPage <a href="https://www.curseforge.com/minecraft/mc-mods/bedrock-miner">...</a>
 **/
@Mod(References.MODID)
public class BedrockMiner {

    public static final Logger LOGGER = LogManager.getLogger();


    public BedrockMiner(IEventBus bus, ModContainer container) {
        ModBlocks.init(bus);
        ModItems.init(bus);
        ModLootModifiers.init(bus);
        CreativeTabs.init(bus);

        bus.addListener(this::addCreative);

        ConfigHelper.registerConfigs(container, References.MODID, true, Config.SERVER_CONFIG, null, null, Config.STARTUP_CONFIG);
        ModRegistry.register(References.MODID, References.NAME, References.URL);
    }


    @Mod(value = References.MODID, dist = Dist.CLIENT)
    public static class BedrockMinerClient {

        public BedrockMinerClient(ModContainer container) {
            ConfigHelper.registerIngameConfig(container);
        }
    }


    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        ResourceKey<CreativeModeTab> key = event.getTabKey();

        if (key == CreativeModeTabs.INGREDIENTS) {
            event.accept(ModItems.BEDROCK_CHUNK.get());

        } else if (key == CreativeModeTabs.TOOLS_AND_UTILITIES) {
            event.accept(ModItems.BEDROCK_SHOVEL.get());
            event.accept(ModItems.BEDROCK_PICKAXE.get());
            event.accept(ModItems.BEDROCK_AXE.get());
            event.accept(ModItems.BEDROCK_HOE.get());

        } else if (key == CreativeModeTabs.COMBAT) {
            event.accept(ModItems.BEDROCK_SWORD.get());
            event.accept(ModItems.BEDROCK_AXE.get());
            event.accept(ModItems.BEDROCK_HELMET.get());
            event.accept(ModItems.BEDROCK_CHESTPLATE.get());
            event.accept(ModItems.BEDROCK_LEGGINGS.get());
            event.accept(ModItems.BEDROCK_BOOTS.get());

        } else if (key == CreativeModeTabs.REDSTONE_BLOCKS) {
            event.accept(ModBlocks.BEDROCK_BREAKER.get());

        } else if (key == CreativeModeTabs.BUILDING_BLOCKS) {
            event.accept(ModBlocks.BEDROCK_BRICKS.get());
            event.accept(ModBlocks.BEDROCK_INFUSED_OBSIDIAN.get());
        }
    }

}
