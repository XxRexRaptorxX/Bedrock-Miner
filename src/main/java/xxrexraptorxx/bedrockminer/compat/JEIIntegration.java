package xxrexraptorxx.bedrockminer.compat;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import xxrexraptorxx.bedrockminer.main.References;
import xxrexraptorxx.bedrockminer.registry.ModItems;

@JeiPlugin
public class JEIIntegration implements IModPlugin {

    private static final ResourceLocation ID = ResourceLocation.fromNamespaceAndPath(References.MODID, "jei_plugin");

    @Override
    public ResourceLocation getPluginUid() {
        return ID;
    }

    @Override
    public void registerRecipes(IRecipeRegistration registry) {
        registry.addIngredientInfo(new ItemStack(ModItems.BEDROCK_CHUNK.get()), VanillaTypes.ITEM_STACK, Component.translatable("message.bedrockminer.bedrock_chunk_jei_desc"));

    }
}