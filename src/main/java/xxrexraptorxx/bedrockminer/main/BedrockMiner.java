package xxrexraptorxx.bedrockminer.main;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import xxrexraptorxx.bedrockminer.utils.Config;

/**
 * @author XxRexRaptorxX (RexRaptor)
 * @projectPage https://www.curseforge.com/minecraft/mc-mods/bedrock-miner
 **/
@Mod(References.MODID)
public class BedrockMiner {

    public static final Logger LOGGER = LogManager.getLogger();

    public BedrockMiner() {
        Config.init();
        ModBlocks.init();
        ModItems.init();

        MinecraftForge.EVENT_BUS.register(this);
    }

}
