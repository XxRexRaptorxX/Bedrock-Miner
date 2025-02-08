package xxrexraptorxx.bedrockminer.datagen;

import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ItemModelOutput;
import net.minecraft.client.data.models.model.ModelInstance;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.resources.ResourceLocation;
import xxrexraptorxx.bedrockminer.registry.ModItems;

import java.util.function.BiConsumer;

public class ItemModelGen extends ItemModelGenerators {

    public ItemModelGen(ItemModelOutput itemModelOutput, BiConsumer<ResourceLocation, ModelInstance> modelOutput) {
        super(itemModelOutput, modelOutput);
    }


    @Override
    public void run() {

        this.generateFlatItem(ModItems.BEDROCK_CHUNK.get(), ModelTemplates.FLAT_ITEM);

        this.generateFlatItem(ModItems.BEDROCK_SWORD.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        this.generateFlatItem(ModItems.BEDROCK_PICKAXE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        this.generateFlatItem(ModItems.BEDROCK_AXE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        this.generateFlatItem(ModItems.BEDROCK_SHOVEL.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        this.generateFlatItem(ModItems.BEDROCK_HOE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        this.generateFlatItem(ModItems.BEDROCK_HELMET.get(), ModelTemplates.FLAT_ITEM);
        this.generateFlatItem(ModItems.BEDROCK_CHESTPLATE.get(), ModelTemplates.FLAT_ITEM);
        this.generateFlatItem(ModItems.BEDROCK_LEGGINGS.get(), ModelTemplates.FLAT_ITEM);
        this.generateFlatItem(ModItems.BEDROCK_BOOTS.get(), ModelTemplates.FLAT_ITEM);
    }

}
