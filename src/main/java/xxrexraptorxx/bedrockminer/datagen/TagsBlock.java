package xxrexraptorxx.bedrockminer.datagen;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.ExistingFileHelper;
import xxrexraptorxx.bedrockminer.main.ModBlocks;
import xxrexraptorxx.bedrockminer.main.References;

public class TagsBlock extends BlockTagsProvider {

    public TagsBlock(DataGenerator generator, ExistingFileHelper helper) {
        super(generator, References.MODID, helper);
    }


    @Override
    protected void addTags() {
        m_206424_(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(   //ModBlocks.BEDROCK_INFUSED_STONE.get(),
                        ModBlocks.BEDROCK_INFUSED_OBSIDIAN.get(),
                        ModBlocks.BEDROCK_BREAKER.get()
                        );


        m_206424_(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(   ModBlocks.BEDROCK_INFUSED_OBSIDIAN.get()
                        //ModBlocks.BEDROCK_INFUSED_STONE.get()
                );


        m_206424_(BlockTags.NEEDS_IRON_TOOL)
                .add(  ModBlocks.BEDROCK_BREAKER.get()
                );

    }
}
