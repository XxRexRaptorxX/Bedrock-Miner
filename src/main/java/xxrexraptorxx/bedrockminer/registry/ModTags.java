package xxrexraptorxx.bedrockminer.registry;

import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.level.block.Block;
import xxrexraptorxx.bedrockminer.main.References;
import xxrexraptorxx.bedrockminer.utils.Config;
import xxrexraptorxx.magmacore.content.TagHelper;

public class ModTags {

    public static final TagKey<Block> NEEDS_BEDROCK_TOOL = TagHelper.createCBlockTag("needs_bedrock_tool");
    public static final TagKey<Block> INCORRECT_FOR_BEDROCK_TOOL = TagHelper.createCBlockTag("incorrect_for_bedrock_tool");
    public static final TagKey<Block> BEDROCK_BREAKER_IMMUNE = TagHelper.createBlockTag(References.MODID, "bedrock_breaker_immune");

    public static final TagKey<Item> REPAIR_MATERIALS_BEDROCK = TagHelper.createItemTag(References.MODID, "repair_materials_bedrock");


    public static final ToolMaterial BEDROCK_TIER = new ToolMaterial(INCORRECT_FOR_BEDROCK_TOOL, Config.getToolDurabilityMultiplier(), Config.getToolEfficiency(), Config.getToolDamage(), Config.getToolEnchantability(), REPAIR_MATERIALS_BEDROCK);
}
