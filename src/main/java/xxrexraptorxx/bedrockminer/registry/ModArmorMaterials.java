package xxrexraptorxx.bedrockminer.registry;

import net.minecraft.Util;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import xxrexraptorxx.bedrockminer.main.References;

import java.util.EnumMap;
import java.util.List;

public class ModArmorMaterials {


    private static final DeferredRegister<ArmorMaterial> MATERIAL = DeferredRegister.create(BuiltInRegistries.ARMOR_MATERIAL, References.MODID);


    public static void init(IEventBus bus) {
        MATERIAL.register(bus);
    }

    public static final Holder<ArmorMaterial> BEDROCK = MATERIAL.register("bedrock", () -> new ArmorMaterial(
            Util.make(new EnumMap<>(ArmorItem.Type.class), (map) -> {
                map.put(ArmorItem.Type.BOOTS, 2);
                map.put(ArmorItem.Type.LEGGINGS, 6);
                map.put(ArmorItem.Type.CHESTPLATE, 8);
                map.put(ArmorItem.Type.HELMET, 3);
            }),
            18, SoundEvents.ARMOR_EQUIP_GENERIC, () -> Ingredient.of(ModItems.BEDROCK_CHUNK),
            List.of(new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(References.MODID, "bedrock"))), 0.8F, 0.5F)
    );

}