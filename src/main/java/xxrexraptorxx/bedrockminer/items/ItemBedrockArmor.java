package xxrexraptorxx.bedrockminer.items;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityEquipment;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;
import xxrexraptorxx.bedrockminer.registry.ModItems;
import xxrexraptorxx.bedrockminer.utils.Config;

public class ItemBedrockArmor extends Item {

    public ItemBedrockArmor(Item.Properties properties) {
        super(properties);
    }


    @Override
    public boolean isBookEnchantable(ItemStack stack, ItemStack book) {
        return true;
    }


    @Override
    public void inventoryTick(ItemStack stack, ServerLevel level, Entity entity, @Nullable EquipmentSlot sl) {
        if (!level.isClientSide() && Config.ARMOR_EFFECTS.get() && entity instanceof Player) {
            Player player = (Player) entity;

            int armorCounter = 0;
            Item helmet = player.getInventory().getItem(EquipmentSlot.HEAD.getIndex()).getItem();
            Item chestplate = player.getInventory().getItem(EquipmentSlot.CHEST.getIndex()).getItem();
            Item leggings = player.getInventory().getItem(EquipmentSlot.LEGS.getIndex()).getItem();
            Item boots = player.getInventory().getItem(EquipmentSlot.FEET.getIndex()).getItem();

            if (helmet == ModItems.BEDROCK_HELMET.get()) armorCounter++;
            if (chestplate == ModItems.BEDROCK_CHESTPLATE.get()) armorCounter++;
            if (leggings == ModItems.BEDROCK_LEGGINGS.get()) armorCounter++;
            if (boots == ModItems.BEDROCK_BOOTS.get()) armorCounter++;

            switch (armorCounter) {
                case 1:
                    break;
                case 2:
                    player.addEffect(new MobEffectInstance(MobEffects.SLOWNESS, 10, 0, false, false, true));
                    break;
                case 3:
                    player.addEffect(new MobEffectInstance(MobEffects.SLOWNESS, 10, 0, false, false, true));
                    player.addEffect(new MobEffectInstance(MobEffects.RESISTANCE, 10, 0, false, false, true));
                    break;
                case 4:
                    player.addEffect(new MobEffectInstance(MobEffects.SLOWNESS, 10, 0, false, false, true));
                    player.addEffect(new MobEffectInstance(MobEffects.RESISTANCE, 10, 1, false, false, true));
                    break;
                default:
                    break;
            }
        }
    }

}
