package xxrexraptorxx.bedrockminer.utils;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import xxrexraptorxx.bedrockminer.main.ModBlocks;
import xxrexraptorxx.bedrockminer.main.ModItems;
import xxrexraptorxx.bedrockminer.main.References;

public class CreativeTab {

    public static CreativeModeTab MOD_TAB = new CreativeModeTab(References.MODID + "_tab") {

        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.BEDROCK_PICKAXE.get());
        }
    };
}
