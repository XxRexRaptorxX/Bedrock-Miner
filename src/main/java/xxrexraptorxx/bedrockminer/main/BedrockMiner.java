package xxrexraptorxx.bedrockminer.main;

import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
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
    private static final ResourceLocation CREATIVE_TAB = new ResourceLocation(References.MODID, "tab");


    public BedrockMiner() {
        Mod.EventBusSubscriber.Bus.MOD.bus().get().register(BedrockMiner.class);

        Config.init();
        ModBlocks.init();
        ModItems.init();
    }


    //Creative Tab
    @SubscribeEvent
    public static void registerTabs(final CreativeModeTabEvent.Register event) {
        event.registerCreativeModeTab(CREATIVE_TAB, (cf) -> cf.icon(() -> new ItemStack(ModItems.BEDROCK_PICKAXE.get()))
                .title(Component.translatable("itemGroup." + References.MODID + "_tab")).displayItems((flagSet, output, ifSth) -> {
                    output.accept(ModBlocks.BEDROCK_BREAKER.get());
                    output.accept(ModBlocks.BEDROCK_INFUSED_OBSIDIAN.get());
                    output.accept(ModItems.BEDROCK_CHUNK.get());
                    output.accept(ModItems.BEDROCK_SWORD.get());
                    output.accept(ModItems.BEDROCK_PICKAXE.get());
                    output.accept(ModItems.BEDROCK_AXE.get());
                    output.accept(ModItems.BEDROCK_SHOVEL.get());
                    output.accept(ModItems.BEDROCK_HOE.get());
                    output.accept(ModItems.BEDROCK_HELMET.get());
                    output.accept(ModItems.BEDROCK_CHESTPLATE.get());
                    output.accept(ModItems.BEDROCK_LEGGINGS.get());
                    output.accept(ModItems.BEDROCK_BOOTS.get());
                })
        );
    }

}
