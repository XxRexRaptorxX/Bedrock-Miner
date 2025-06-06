package xxrexraptorxx.bedrockminer.datagen;

import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelOutput;
import net.minecraft.client.data.models.blockstates.BlockModelDefinitionGenerator;
import net.minecraft.client.data.models.model.ModelInstance;
import net.minecraft.resources.ResourceLocation;
import xxrexraptorxx.bedrockminer.registry.ModBlocks;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class BlockModelGen extends BlockModelGenerators {

    public BlockModelGen(Consumer<BlockModelDefinitionGenerator> blockstateOutput, ItemModelOutput itemModelOutput, BiConsumer<ResourceLocation, ModelInstance> modelOutput) {
        super(blockstateOutput, itemModelOutput, modelOutput);
    }

    @Override
    public void run() {
        createTrivialCube(ModBlocks.BEDROCK_INFUSED_OBSIDIAN.get());
        createTrivialCube(ModBlocks.BEDROCK_BRICKS.get());
    }
}