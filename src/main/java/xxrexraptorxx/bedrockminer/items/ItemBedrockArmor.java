package xxrexraptorxx.bedrockminer.items;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import xxrexraptorxx.bedrockminer.main.ModItems;
import xxrexraptorxx.bedrockminer.utils.Config;

public class ItemBedrockArmor extends ArmorItem {
    public ItemBedrockArmor(ArmorMaterial pMaterial, EquipmentSlot pSlot, Properties pProperties) {
        super(pMaterial, pSlot, pProperties);
    }


    @Override
    public boolean isRepairable(ItemStack stack) {
        return stack.getItem() == Blocks.BEDROCK.asItem();

    }

    @Override
    public void onArmorTick(ItemStack stack, Level world, Player player) {
        if (!world.isClientSide && Config.ARMOR_EFFECTS.get() && player.getInventory().getArmor(3) != ItemStack.EMPTY && player.getInventory().getArmor(3).getItem() == ModItems.BEDROCK_HELMET.get()
                && player.getInventory().getArmor(2) != ItemStack.EMPTY && player.getInventory().getArmor(2).getItem() == ModItems.BEDROCK_CHESTPLATE.get()
                && player.getInventory().getArmor(1) != ItemStack.EMPTY && player.getInventory().getArmor(1).getItem() == ModItems.BEDROCK_LEGGINGS.get()
                && player.getInventory().getArmor(0) != ItemStack.EMPTY && player.getInventory().getArmor(0).getItem() == ModItems.BEDROCK_BOOTS.get()) {
            this.effectPlayer(player, MobEffects.DAMAGE_RESISTANCE, 1);
            this.effectPlayer(player, MobEffects.MOVEMENT_SLOWDOWN, 1);
        }
    }


    private void effectPlayer(Player player, MobEffect effect, int amplifier) {
        if (player.getEffect(effect) == null || player.getEffect(effect).getDuration() <= 70)
            player.addEffect(new MobEffectInstance(effect, 70, amplifier, true, true));
    }
}
