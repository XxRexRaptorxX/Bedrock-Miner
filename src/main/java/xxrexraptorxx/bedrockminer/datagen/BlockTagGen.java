package xxrexraptorxx.bedrockminer.datagen;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.data.ExistingFileHelper;
import xxrexraptorxx.bedrockminer.main.ModBlocks;
import xxrexraptorxx.bedrockminer.main.References;

public class BlockTagGen extends BlockTagsProvider {

    public BlockTagGen(DataGenerator generator, ExistingFileHelper helper) {
        super(generator, References.MODID, helper);
    }


    @Override
    protected void addTags() {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(   //ModBlocks.BEDROCK_INFUSED_STONE.get(),
                        ModBlocks.BEDROCK_INFUSED_OBSIDIAN.get(),
                        ModBlocks.BEDROCK_BREAKER.get(),
                        ModBlocks.FAKE_BEDROCK.get(),
                        Blocks.BEDROCK
                );


        tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(   ModBlocks.BEDROCK_INFUSED_OBSIDIAN.get()
                        //ModBlocks.BEDROCK_INFUSED_STONE.get()
                );


        tag(BlockTags.NEEDS_STONE_TOOL)
                .add(  ModBlocks.BEDROCK_BREAKER.get()
                );

    }
}