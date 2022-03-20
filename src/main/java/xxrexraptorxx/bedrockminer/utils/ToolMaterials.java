package xxrexraptorxx.bedrockminer.utils;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.ForgeTier;
import xxrexraptorxx.bedrockminer.main.ModItems;
import xxrexraptorxx.bedrockminer.main.References;

public class ToolMaterials {

    public static final TagKey<Block> NEEDS_BEDROCK_TAG = BlockTags.create(new ResourceLocation(References.MODID, "needs_bedrock_tool"));

    public static final ForgeTier BEDROCK = new ForgeTier(Tiers.DIAMOND.getLevel(), Config.TOOL_DURABILITY.get(), Config.TOOL_SPEED.get().floatValue(), Config.TOOL_DAMAGE.get().floatValue(), Config.TOOL_ENCHANTABILITY.get(), NEEDS_BEDROCK_TAG, () -> Ingredient.of(ModItems.BEDROCK_CHUNK.get()));

}