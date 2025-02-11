package xxrexraptorxx.bedrockminer.items;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.level.Level;
import xxrexraptorxx.bedrockminer.registry.ModItems;
import xxrexraptorxx.bedrockminer.utils.Config;

public class ItemBedrockArmor extends ArmorItem {

    public ItemBedrockArmor(ArmorMaterial material, ArmorType armorType, Item.Properties properties) {
        super(material, armorType, properties);
    }


    @Override
    public boolean isBookEnchantable(ItemStack stack, ItemStack book) {
        return true;
    }


    @Override
    public void inventoryTick(ItemStack stack, Level level, Entity entity, int p_41407_, boolean p_41408_) {
        if (!level.isClientSide() && Config.ARMOR_EFFECTS.get() && entity instanceof Player) {
            Player player = (Player) entity;

            int armorCounter = 0;
            Item helmet = player.getInventory().getArmor(3).getItem();
            Item chestplate = player.getInventory().getArmor(2).getItem();
            Item leggings = player.getInventory().getArmor(1).getItem();
            Item boots = player.getInventory().getArmor(0).getItem();

            if (helmet == ModItems.BEDROCK_HELMET.get()) armorCounter++;
            if (chestplate == ModItems.BEDROCK_CHESTPLATE.get()) armorCounter++;
            if (leggings == ModItems.BEDROCK_LEGGINGS.get()) armorCounter++;
            if (boots == ModItems.BEDROCK_BOOTS.get()) armorCounter++;

            switch (armorCounter) {
                case 1:
                    break;
                case 2:
                    player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 10, 0, false, false, true));
                    break;
                case 3:
                    player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 10, 0, false, false, true));
                    player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 10, 0, false, false, true));
                    break;
                case 4:
                    player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 10, 0, false, false, true));
                    player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 10, 1, false, false, true));
                    break;
                default:
                    break;
            }
        }
    }

}
