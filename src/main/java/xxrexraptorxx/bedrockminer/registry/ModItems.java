package xxrexraptorxx.bedrockminer.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.*;
import net.minecraft.world.item.equipment.ArmorType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import xxrexraptorxx.bedrockminer.items.ItemBedrockArmor;
import xxrexraptorxx.bedrockminer.main.References;

public class ModItems {

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(References.MODID);

    public static void init(IEventBus bus) {
        ITEMS.register(bus);
    }


    public static final DeferredItem<Item> BEDROCK_CHUNK = ITEMS.register("bedrock_chunk", () -> new Item(new Item.Properties().setId(itemId("bedrock_chunk"))));

    public static final DeferredItem<SwordItem> BEDROCK_SWORD = ITEMS.registerItem("bedrock_sword", props -> new SwordItem(ModTags.BEDROCK_TIER,  3, -2.4f, props));
    public static final DeferredItem<PickaxeItem> BEDROCK_PICKAXE = ITEMS.registerItem("bedrock_pickaxe", props -> new PickaxeItem(ModTags.BEDROCK_TIER,  1, -2.8f, props));
    public static final DeferredItem<AxeItem> BEDROCK_AXE = ITEMS.registerItem("bedrock_axe", props -> new AxeItem(ModTags.BEDROCK_TIER,  5, -3.0f, props));
    public static final DeferredItem<ShovelItem> BEDROCK_SHOVEL = ITEMS.registerItem("bedrock_shovel", props -> new ShovelItem(ModTags.BEDROCK_TIER, 1.5f, -3.0f, props));
    public static final DeferredItem<HoeItem> BEDROCK_HOE = ITEMS.registerItem("bedrock_hoe", props -> new HoeItem(ModTags.BEDROCK_TIER, -3.5f, -0.0f, props));

    public static final DeferredItem<ItemBedrockArmor> BEDROCK_HELMET = ITEMS.registerItem("bedrock_helmet", props -> new ItemBedrockArmor(ModArmorMaterials.BEDROCK_ARMOR_MATERIAL, ArmorType.HELMET, props));
    public static final DeferredItem<ItemBedrockArmor> BEDROCK_CHESTPLATE = ITEMS.registerItem("bedrock_chestplate", props -> new ItemBedrockArmor(ModArmorMaterials.BEDROCK_ARMOR_MATERIAL, ArmorType.CHESTPLATE, props));
    public static final DeferredItem<ItemBedrockArmor> BEDROCK_LEGGINGS = ITEMS.registerItem("bedrock_leggings", props -> new ItemBedrockArmor(ModArmorMaterials.BEDROCK_ARMOR_MATERIAL, ArmorType.LEGGINGS, props));
    public static final DeferredItem<ItemBedrockArmor> BEDROCK_BOOTS = ITEMS.registerItem("bedrock_boots", props -> new ItemBedrockArmor(ModArmorMaterials.BEDROCK_ARMOR_MATERIAL, ArmorType.BOOTS, props));


    public static ResourceKey<Item> itemId(String name) {
        return ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(References.MODID, name));
    }
}
