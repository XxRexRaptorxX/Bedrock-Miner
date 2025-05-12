package xxrexraptorxx.bedrockminer.registry;

import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.component.DamageResistant;
import net.minecraft.world.item.equipment.ArmorType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import xxrexraptorxx.bedrockminer.items.ItemBedrockArmor;
import xxrexraptorxx.bedrockminer.main.References;
import xxrexraptorxx.bedrockminer.utils.ModArmorMaterials;

public class ModItems {

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(References.MODID);

    public static void init(IEventBus bus) {
        ITEMS.register(bus);
    }


    public static final DeferredItem<Item> BEDROCK_CHUNK = ITEMS.register("bedrock_chunk", () -> new Item(new Item.Properties().setId(itemId("bedrock_chunk"))));

    public static final DeferredItem<Item> BEDROCK_SWORD = ITEMS.registerItem("bedrock_sword", props -> new Item(props.sword(ModTags.BEDROCK_TIER,  3, -2.4f).component(DataComponents.DAMAGE_RESISTANT, new DamageResistant(DamageTypeTags.IS_FIRE))));
    public static final DeferredItem<Item> BEDROCK_PICKAXE = ITEMS.registerItem("bedrock_pickaxe", props -> new Item(props.pickaxe(ModTags.BEDROCK_TIER,  1, -2.8f).component(DataComponents.DAMAGE_RESISTANT, new DamageResistant(DamageTypeTags.IS_FIRE))));
    public static final DeferredItem<AxeItem> BEDROCK_AXE = ITEMS.registerItem("bedrock_axe", props -> new AxeItem(ModTags.BEDROCK_TIER,  5, -3.0f, props.component(DataComponents.DAMAGE_RESISTANT, new DamageResistant(DamageTypeTags.IS_FIRE))));
    public static final DeferredItem<ShovelItem> BEDROCK_SHOVEL = ITEMS.registerItem("bedrock_shovel", props -> new ShovelItem(ModTags.BEDROCK_TIER, 1.5f, -3.0f, props.component(DataComponents.DAMAGE_RESISTANT, new DamageResistant(DamageTypeTags.IS_FIRE))));
    public static final DeferredItem<HoeItem> BEDROCK_HOE = ITEMS.registerItem("bedrock_hoe", props -> new HoeItem(ModTags.BEDROCK_TIER, -3.5f, -0.0f, props.component(DataComponents.DAMAGE_RESISTANT, new DamageResistant(DamageTypeTags.IS_FIRE))));

    public static final DeferredItem<ItemBedrockArmor> BEDROCK_HELMET = ITEMS.registerItem("bedrock_helmet", props -> new ItemBedrockArmor(props.humanoidArmor(ModArmorMaterials.BEDROCK_ARMOR_MATERIAL, ArmorType.HELMET).component(DataComponents.DAMAGE_RESISTANT, new DamageResistant(DamageTypeTags.IS_FIRE))));
    public static final DeferredItem<ItemBedrockArmor> BEDROCK_CHESTPLATE = ITEMS.registerItem("bedrock_chestplate", props -> new ItemBedrockArmor(props.humanoidArmor(ModArmorMaterials.BEDROCK_ARMOR_MATERIAL, ArmorType.CHESTPLATE).component(DataComponents.DAMAGE_RESISTANT, new DamageResistant(DamageTypeTags.IS_FIRE))));
    public static final DeferredItem<ItemBedrockArmor> BEDROCK_LEGGINGS = ITEMS.registerItem("bedrock_leggings", props -> new ItemBedrockArmor(props.humanoidArmor(ModArmorMaterials.BEDROCK_ARMOR_MATERIAL, ArmorType.LEGGINGS).component(DataComponents.DAMAGE_RESISTANT, new DamageResistant(DamageTypeTags.IS_FIRE))));
    public static final DeferredItem<ItemBedrockArmor> BEDROCK_BOOTS = ITEMS.registerItem("bedrock_boots", props -> new ItemBedrockArmor(props.humanoidArmor(ModArmorMaterials.BEDROCK_ARMOR_MATERIAL, ArmorType.BOOTS).component(DataComponents.DAMAGE_RESISTANT, new DamageResistant(DamageTypeTags.IS_FIRE))));


    public static ResourceKey<Item> itemId(String name) {
        return ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(References.MODID, name));
    }
}
