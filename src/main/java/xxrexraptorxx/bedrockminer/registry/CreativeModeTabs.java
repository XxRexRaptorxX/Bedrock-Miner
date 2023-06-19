package xxrexraptorxx.bedrockminer.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import xxrexraptorxx.bedrockminer.main.References;

public class CreativeModeTabs {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, References.MODID);

    public static void init() { CREATIVE_MODE_TABS.register(FMLJavaModLoadingContext.get().getModEventBus()); }


    public static final RegistryObject<CreativeModeTab> MAIN_TAB = CREATIVE_MODE_TABS.register(References.MODID, () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup." + References.MODID + "_tab"))
            .icon(() -> ModItems.BEDROCK_PICKAXE.get().getDefaultInstance())
            .displayItems((params, output) -> {
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
            }).build());
}
