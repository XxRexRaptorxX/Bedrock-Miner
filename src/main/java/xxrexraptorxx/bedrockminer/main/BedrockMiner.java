package xxrexraptorxx.bedrockminer.main;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import xxrexraptorxx.bedrockminer.registry.*;
import xxrexraptorxx.bedrockminer.utils.Config;

/**
 * @author XxRexRaptorxX (RexRaptor)
 * @projectPage <a href="https://www.curseforge.com/minecraft/mc-mods/bedrock-miner">...</a>
 **/
@Mod(References.MODID)
public class BedrockMiner {

    public static final Logger LOGGER = LogManager.getLogger();


    public BedrockMiner(IEventBus bus, ModContainer container) {

        Config.init(container);
        ModBlocks.init(bus);
        ModItems.init(bus);
        ModLootModifiers.init(bus);
        CreativeModeTabs.init(bus);
    }

}
