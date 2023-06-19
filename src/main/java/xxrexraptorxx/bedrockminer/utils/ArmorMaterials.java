package xxrexraptorxx.bedrockminer.utils;

import net.minecraft.Util;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.util.Lazy;
import xxrexraptorxx.bedrockminer.registry.ModItems;
import xxrexraptorxx.bedrockminer.main.References;

import java.util.EnumMap;
import java.util.function.Supplier;

public enum ArmorMaterials implements ArmorMaterial {

    BEDROCK(References.MODID + ":bedrock", 50, Util.make(new EnumMap<>(ArmorItem.Type.class), (p_266650_) -> {
        p_266650_.put(ArmorItem.Type.BOOTS, 2);
        p_266650_.put(ArmorItem.Type.LEGGINGS, 6);
        p_266650_.put(ArmorItem.Type.CHESTPLATE, 8);
        p_266650_.put(ArmorItem.Type.HELMET, 3);
    }), 18, SoundEvents.ARMOR_EQUIP_GENERIC, 0.8F, 3, () -> {
        return Ingredient.of(ModItems.BEDROCK_CHUNK.get());
    });


    private static final int[] MAX_DAMAGE_ARRAY = new int[]{13, 15, 16, 11};
    private final String name;
    private final int enchantability;
    private final SoundEvent soundEvent;
    private final float toughness;
    private final Lazy<Ingredient> repairMaterial;
    private final float knockbackResistance;
    private final int durabilityMultiplier;
    private final EnumMap<ArmorItem.Type, Integer> protectionFunctionForType;
    private static final EnumMap<ArmorItem.Type, Integer> HEALTH_FUNCTION_FOR_TYPE = Util.make(new EnumMap<>(ArmorItem.Type.class), (p_266653_) -> {
        p_266653_.put(ArmorItem.Type.BOOTS, 13);
        p_266653_.put(ArmorItem.Type.LEGGINGS, 15);
        p_266653_.put(ArmorItem.Type.CHESTPLATE, 16);
        p_266653_.put(ArmorItem.Type.HELMET, 11);
    });

    ArmorMaterials(String nameIn, int durabilityMultiplierIn, EnumMap<ArmorItem.Type, Integer> protectionFunctionForTypeIn, int enchantabilityIn,
                   SoundEvent soundIn, float toughnessIn, int knockbackResistanceIn, Supplier<Ingredient> repairMatIn) {
        name = nameIn;
        durabilityMultiplier = durabilityMultiplierIn;
        protectionFunctionForType = protectionFunctionForTypeIn;
        enchantability = enchantabilityIn;
        soundEvent = soundIn;
        toughness = toughnessIn;
        knockbackResistance = knockbackResistanceIn;
        repairMaterial = Lazy.of(repairMatIn);
    }


    @Override
    public int getDurabilityForType(ArmorItem.Type type) {
        return HEALTH_FUNCTION_FOR_TYPE.get(type) * this.durabilityMultiplier;
    }


    @Override
    public int getDefenseForType(ArmorItem.Type type) {
        return this.protectionFunctionForType.get(type);
    }


    @Override
    public int getEnchantmentValue() {
        return this.enchantability;
    }


    @Override
    public SoundEvent getEquipSound() {
        return this.soundEvent;
    }


    @Override
    public Ingredient getRepairIngredient() {
        return this.repairMaterial.get();
    }


    @Override
    @OnlyIn(Dist.CLIENT)
    public String getName() {
        return this.name;
    }


    @Override
    public float getToughness() {
        return this.toughness;
    }


    @Override
    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }
}