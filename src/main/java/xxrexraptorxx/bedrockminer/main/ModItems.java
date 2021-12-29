package xxrexraptorxx.bedrockminer.main;

import net.minecraft.item.PickaxeItem;
import net.minecraftforge.registries.ObjectHolder;
import xxrexraptorxx.bedrockminer.items.ItemBasic;

public class ModItems {

    @ObjectHolder(References.MODID + ":bedrock_chunk")
    public static ItemBasic BEDROCK_CHUNK;

    @ObjectHolder(References.MODID + ":bedrock_pickaxe")
    public static PickaxeItem BEDROCK_PICKAXE;
}
