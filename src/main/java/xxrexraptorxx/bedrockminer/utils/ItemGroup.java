package xxrexraptorxx.bedrockminer.utils;

import net.minecraft.item.ItemStack;
import xxrexraptorxx.bedrockminer.main.ModBlocks;
import xxrexraptorxx.bedrockminer.main.ModItems;

public class ItemGroup {

    public net.minecraft.item.ItemGroup mainGroup = new net.minecraft.item.ItemGroup("bedrockminerTab") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModBlocks.BEDROCK_INFUSED_OBSIDIAN);
        }
    };

    public void init() {

    }



}
