package xxrexraptorxx.bedrockminer.items;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.TierSortingRegistry;
import xxrexraptorxx.bedrockminer.registry.ModTiers;

//TODO
public class ItemBedrockPickaxe extends PickaxeItem {

    public ItemBedrockPickaxe(Tier tier, int attackDamageModifier, float attackSpeedModifier, Item.Properties properties) {
        super(tier, attackDamageModifier, attackSpeedModifier, properties);
    }


    @Override
    public boolean isCorrectToolForDrops(ItemStack stack, BlockState state) {
        if (state.is(ModTiers.NEEDS_BEDROCK_TOOL)) {
            return true;

        } else {
            return state.is(BlockTags.MINEABLE_WITH_PICKAXE) && TierSortingRegistry.isCorrectTierForDrops(getTier(), state);
        }
    }
}
