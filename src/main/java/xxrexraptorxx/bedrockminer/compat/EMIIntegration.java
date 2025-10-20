package xxrexraptorxx.bedrockminer.compat;

import dev.emi.emi.api.EmiEntrypoint;
import dev.emi.emi.api.EmiPlugin;
import dev.emi.emi.api.EmiRegistry;
import dev.emi.emi.api.recipe.EmiInfoRecipe;
import dev.emi.emi.api.stack.EmiStack;
import net.minecraft.resources.ResourceLocation;
import xxrexraptorxx.bedrockminer.main.References;
import xxrexraptorxx.bedrockminer.registry.ModItems;
import xxrexraptorxx.magmacore.utils.FormattingHelper;

import java.util.List;

@EmiEntrypoint
public class EMIIntegration implements EmiPlugin {

    @Override
    public void register(EmiRegistry registry) {
        ResourceLocation recipeId = ResourceLocation.fromNamespaceAndPath(References.MODID, "info/bedrock_chunk");
        registry.addRecipe(new EmiInfoRecipe(List.of(EmiStack.of(ModItems.BEDROCK_CHUNK)),
                List.of(FormattingHelper.setMessageComponent(References.MODID, "bedrock_chunk_jei_desc")), recipeId));
    }

}
