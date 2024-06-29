package xxrexraptorxx.bedrockminer.registry;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.SimpleTier;

public class ModTags {

    public static final TagKey<Block> NEEDS_BEDROCK_TOOL = BlockTags.create(ResourceLocation.fromNamespaceAndPath("c", "needs_bedrock_tool"));
    public static final TagKey<Block> INCORRECT_FOR_BEDROCK_TAG = BlockTags.create(ResourceLocation.fromNamespaceAndPath("c", "incorrect_for_bedrock_tool"));

    public static final SimpleTier BEDROCK_TIER = new SimpleTier(INCORRECT_FOR_BEDROCK_TAG, 2500, 6.0f, 3.5f, 3, () -> Ingredient.of(ModItems.BEDROCK_CHUNK));
}
