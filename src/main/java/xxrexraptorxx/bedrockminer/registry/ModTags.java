package xxrexraptorxx.bedrockminer.registry;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.SimpleTier;
import xxrexraptorxx.bedrockminer.main.References;

public class ModTags {

    public static final TagKey<Block> NEEDS_BEDROCK_TOOL = BlockTags.create(ResourceLocation.fromNamespaceAndPath("c", "needs_bedrock_tool"));
    public static final TagKey<Block> INCORRECT_FOR_BEDROCK_TOOL = BlockTags.create(ResourceLocation.fromNamespaceAndPath("c", "incorrect_for_bedrock_tool"));

    public static final TagKey<Item> REPAIR_MATERIALS_BEDROCK = ItemTags.create(ResourceLocation.fromNamespaceAndPath(References.MODID, "repair_materials_bedrock"));


    public static final ToolMaterial BEDROCK_TIER = new ToolMaterial(INCORRECT_FOR_BEDROCK_TOOL, 2500, 6.0f, 3.5f, 3, REPAIR_MATERIALS_BEDROCK);
}
