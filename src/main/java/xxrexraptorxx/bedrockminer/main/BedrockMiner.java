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

/**
 * @author XxRexRaptorxX (RexRaptor)
 * @projectPage <a href="https://www.curseforge.com/minecraft/mc-mods/bedrock-miner">...</a>
 **/
@Mod(References.MODID)
public class BedrockMiner {

    public static final Logger LOGGER = LogManager.getLogger();


    public BedrockMiner(IEventBus bus, ModContainer container) {
        container.registerConfig(ModConfig.Type.SERVER, Config.SERVER_CONFIG, References.MODID + "/" + References.MODID + "-server.toml");
        container.registerConfig(ModConfig.Type.STARTUP, Config.STARTUP_CONFIG, References.MODID + "/" + References.MODID + "-startup.toml");
        container.registerConfig(ModConfig.Type.CLIENT, Config.CLIENT_CONFIG, References.MODID + "/" + References.MODID + "-client.toml");

        ModBlocks.init(bus);
        ModItems.init(bus);
        ModLootModifiers.init(bus);
        CreativeModeTabs.init(bus);
    }


    @Mod(value = References.MODID, dist = Dist.CLIENT)
    public static class BedrockMinerClient {

        public BedrockMinerClient(IEventBus bus, ModContainer container) {
            container.registerExtensionPoint(IConfigScreenFactory.class, ConfigurationScreen::new);
        }
    }

}


