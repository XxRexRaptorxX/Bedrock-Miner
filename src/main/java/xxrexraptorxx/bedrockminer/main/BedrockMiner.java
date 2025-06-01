package xxrexraptorxx.bedrockminer.main;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import xxrexraptorxx.bedrockminer.registry.CreativeModeTabs;
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
        CreativeModeTabs.init(bus);

        ConfigHelper.registerConfigs(container, References.MODID, true, Config.SERVER_CONFIG, null, null, Config.STARTUP_CONFIG);
        ModRegistry.register(References.MODID, References.NAME, References.URL);
    }


    @Mod(value = References.MODID, dist = Dist.CLIENT)
    public static class BedrockMinerClient {

        public BedrockMinerClient(ModContainer container) {
            ConfigHelper.registerIngameConfig(container);
        }
    }

}


