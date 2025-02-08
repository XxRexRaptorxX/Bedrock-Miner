package xxrexraptorxx.bedrockminer.registry;

import net.minecraft.Util;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.item.equipment.EquipmentAssets;
import xxrexraptorxx.bedrockminer.main.References;

import java.util.EnumMap;

public class ModArmorMaterials {


    public static final ArmorMaterial BEDROCK_ARMOR_MATERIAL = new ArmorMaterial(
            // The durability multiplier of the armor material.
            // ArmorType have different unit durabilities that the multiplier is applied to:
            // - HELMET: 11
            // - CHESTPLATE: 16
            // - LEGGINGS: 15
            // - BOOTS: 13
            // - BODY: 16
            15,
            Util.make(new EnumMap<>(ArmorType.class), map -> {
                map.put(ArmorType.BOOTS, 2);
                map.put(ArmorType.LEGGINGS, 6);
                map.put(ArmorType.CHESTPLATE, 8);
                map.put(ArmorType.HELMET, 3);
                map.put(ArmorType.BODY, 8);
            }),
            18,
            SoundEvents.ARMOR_EQUIP_GENERIC,
            0.8F,
            0.5F,
            ModTags.REPAIR_MATERIALS_BEDROCK,
            ResourceKey.create(EquipmentAssets.ROOT_ID, ResourceLocation.fromNamespaceAndPath(References.MODID, "bedrock"))
    );

}