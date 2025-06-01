package xxrexraptorxx.bedrockminer.compat;

import me.shedaniel.rei.api.client.plugins.REIClientPlugin;
import me.shedaniel.rei.api.client.registry.display.DisplayRegistry;
import me.shedaniel.rei.api.common.util.EntryStacks;
import me.shedaniel.rei.forge.REIPluginClient;
import me.shedaniel.rei.plugin.client.BuiltinClientPlugin;
import net.minecraft.network.chat.Component;
import xxrexraptorxx.bedrockminer.main.References;
import xxrexraptorxx.bedrockminer.registry.ModItems;
import xxrexraptorxx.magmacore.utils.FormattingHelper;

@REIPluginClient
public class REIIntegration implements REIClientPlugin {

    @Override
    public void registerDisplays(DisplayRegistry registry) {
        BuiltinClientPlugin instance = BuiltinClientPlugin.getInstance();

        instance.registerInformation(EntryStacks.of(ModItems.BEDROCK_CHUNK), Component.empty(), list -> {
            list.add(FormattingHelper.setModLangComponent("message", References.MODID, "bedrock_chunk_jei_desc"));
            return list;
        });
    }

}

