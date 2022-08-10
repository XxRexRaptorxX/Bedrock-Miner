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

    //private static int bedrockDurability = Config.TOOL_DURABILITY.get();      TODO!
    //private static double bedrockMiningSpeed = Config.TOOL_SPEED.get();
    //private static double bedrockAttackDamage = Config.TOOL_DAMAGE.get();
    //private static int bedrockEnchantability = Config.TOOL_ENCHANTABILITY.get();

    public static final TagKey<Block> NEEDS_BEDROCK_TAG = BlockTags.create(new ResourceLocation(References.MODID, "needs_bedrock_tool"));

    public static final ForgeTier BEDROCK = new ForgeTier(Tiers.DIAMOND.getLevel(), 2500, 6.0F, 3.5F, 3, NEEDS_BEDROCK_TAG, () -> Ingredient.of(ModItems.BEDROCK_CHUNK.get()));

}