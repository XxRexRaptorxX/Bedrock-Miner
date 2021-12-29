package xxrexraptorxx.bedrockminer.utils;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import xxrexraptorxx.bedrockminer.main.ModItems;
import xxrexraptorxx.bedrockminer.main.References;

public enum ArmorMaterials implements IArmorMaterial {

    bedrockAM("bedrock", 50, new int[] {2, 6, 8, 3}, 18, ModItems.BEDROCK_CHUNK, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC.getRegistryName().toString(), 3.0F);


    private static final int[] max_damage_array = new int[]{13, 15, 16, 11};
    private String name, equipSound;
    private int durability, enchantability;
    private Item repairItem;
    private int[] damageReductionAmounts;
    private float toughness;

    private ArmorMaterials(String name, int durability, int[] damageReductionAmounts, int enchantability, Item repairItem, String equipSound, float toughness) {
        this.name = name;
        this.equipSound = equipSound;
        this.durability = durability;
        this.enchantability = enchantability;
        this.repairItem = repairItem;
        this.damageReductionAmounts = damageReductionAmounts;
        this.toughness = toughness;
    }

    @Override
    public int getDamageReductionAmount(EquipmentSlotType slot) {
        return this.damageReductionAmounts[slot.getIndex()];
    }

    @Override
    public int getDurability(EquipmentSlotType slot) {
        return max_damage_array[slot.getIndex()] * this.durability;
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    @Override
    public String getName() {
        return References.MODID + ":" + this.name;
    }

    @Override
    public Ingredient getRepairMaterial() {
        return Ingredient.fromItems(this.repairItem);
    }

    @Override
    public SoundEvent getSoundEvent() {
        return new SoundEvent(new ResourceLocation(equipSound));
    }

    @Override
    public float getToughness() {
        return this.toughness;
    }
}