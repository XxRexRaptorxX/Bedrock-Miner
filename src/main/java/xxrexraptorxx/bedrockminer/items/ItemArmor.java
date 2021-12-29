package xxrexraptorxx.bedrockminer.items;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.potion.Potion;
import net.minecraft.world.World;
import xxrexraptorxx.bedrockminer.main.BedrockMiner;
import xxrexraptorxx.bedrockminer.main.ModItems;
import xxrexraptorxx.bedrockminer.utils.Config;

public class ItemArmor extends ArmorItem {


    public ItemArmor(IArmorMaterial materialIn, EquipmentSlotType slot, Properties builder) {
        super(materialIn, slot, builder);

    }


    @Override
    public boolean getIsRepairable(ItemStack armor, ItemStack stack) {
        return stack.getItem() == ModItems.BEDROCK_CHUNK;
    }


    @Override
    public void onArmorTick(ItemStack stack, World world, PlayerEntity player) {
        if (Config.BEDROCK_ARMOR_EFFECTS.get()) {
            if (!player.isPotionActive(Effects.SLOWNESS)) {
                player.addPotionEffect(new EffectInstance(Effects.SLOWNESS, 0));
                player.addPotionEffect(new EffectInstance(Effects.RESISTANCE, 0));
            }
        }
    }


    private void effectPlayer(PlayerEntity player, Effect effect, int amplifier) {
        if (Config.BEDROCK_ARMOR_EFFECTS.get()) {
            if (player.getActivePotionEffect(effect) == null || player.getActivePotionEffect(effect).getDuration() <= 1)
                player.addPotionEffect(new EffectInstance(Effects.SLOWNESS, 10, amplifier, true, false));
            player.addPotionEffect(new EffectInstance(Effects.RESISTANCE, 10, amplifier, true, false));
        }
    }
}
