package xxrexraptorxx.bedrockminer.utils;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;
import xxrexraptorxx.bedrockminer.main.ModItems;
import xxrexraptorxx.bedrockminer.main.References;

import java.util.List;

public class ModTiers {

    public static final TagKey<Block> NEEDS_BEDROCK_TOOL = BlockTags.create(new ResourceLocation("forge", "needs_bedrock_tool"));

    public static final Tier BEDROCK_TIER = TierSortingRegistry.registerTier(new ForgeTier(5, 2500, 6.0F, 3.5F, 3,
            ModTiers.NEEDS_BEDROCK_TOOL, () -> Ingredient.of(ModItems.BEDROCK_CHUNK.get())), new ResourceLocation(References.MODID, "bedrock"), List.of(Tiers.NETHERITE), List.of());

}