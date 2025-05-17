package xxrexraptorxx.bedrockminer.registry;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.level.block.Block;
import xxrexraptorxx.bedrockminer.main.References;
import xxrexraptorxx.bedrockminer.utils.Config;

public class ModTags {

    public static final TagKey<Block> NEEDS_BEDROCK_TOOL = BlockTags.create(ResourceLocation.fromNamespaceAndPath("c", "needs_bedrock_tool"));
    public static final TagKey<Block> INCORRECT_FOR_BEDROCK_TOOL = BlockTags.create(ResourceLocation.fromNamespaceAndPath("c", "incorrect_for_bedrock_tool"));
    public static final TagKey<Block> BEDROCK_BREAKER_IMMUNE = BlockTags.create(ResourceLocation.fromNamespaceAndPath(References.MODID, "bedrock_breaker_immune"));

    public static final TagKey<Item> REPAIR_MATERIALS_BEDROCK = ItemTags.create(ResourceLocation.fromNamespaceAndPath(References.MODID, "repair_materials_bedrock"));


    public static final ToolMaterial BEDROCK_TIER = new ToolMaterial(INCORRECT_FOR_BEDROCK_TOOL, Config.getToolDurabilityMultiplier(), Config.getToolEfficiency(), Config.getToolDamage(), Config.getToolEnchantability(), REPAIR_MATERIALS_BEDROCK);
}
