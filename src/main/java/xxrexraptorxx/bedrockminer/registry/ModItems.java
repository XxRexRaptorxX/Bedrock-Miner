package xxrexraptorxx.bedrockminer.registry;

import net.minecraft.world.item.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import xxrexraptorxx.bedrockminer.items.ItemBasic;
import xxrexraptorxx.bedrockminer.items.ItemBedrockArmor;
import xxrexraptorxx.bedrockminer.main.References;
import xxrexraptorxx.bedrockminer.utils.ArmorMaterials;

public class ModItems {

    private static float attackSpeedMultiplier = -0.2F;

    private static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(References.MODID);

    public static void init(IEventBus bus) {
        ITEMS.register(bus);
    }


    public static final DeferredItem<ItemBasic> BEDROCK_CHUNK = ITEMS.register("bedrock_chunk", ItemBasic::new);

    public static final DeferredItem<SwordItem> BEDROCK_SWORD = ITEMS.register("bedrock_sword", () ->
            new SwordItem(ModTiers.BEDROCK_TIER, 3, -2.4f + attackSpeedMultiplier, new Item.Properties()));
    public static final DeferredItem<PickaxeItem> BEDROCK_PICKAXE = ITEMS.register("bedrock_pickaxe",
            () -> new PickaxeItem(ModTiers.BEDROCK_TIER, 1, -2.8F + attackSpeedMultiplier, new Item.Properties()));
    public static final DeferredItem<AxeItem> BEDROCK_AXE = ITEMS.register("bedrock_axe",
            () -> new AxeItem(ModTiers.BEDROCK_TIER, 5.0F, -3.0F + attackSpeedMultiplier, new Item.Properties()));
    public static final DeferredItem<ShovelItem> BEDROCK_SHOVEL = ITEMS.register("bedrock_shovel",
            () -> new ShovelItem(ModTiers.BEDROCK_TIER, 1.5F, -3.0F + attackSpeedMultiplier, new Item.Properties()));
    public static final DeferredItem<HoeItem> BEDROCK_HOE = ITEMS.register("bedrock_hoe",
            () -> new HoeItem(ModTiers.BEDROCK_TIER,-3, 0.0F + attackSpeedMultiplier, new Item.Properties()));

    public static final DeferredItem<ArmorItem> BEDROCK_HELMET = ITEMS.register("bedrock_helmet", () -> new ItemBedrockArmor(ArmorMaterials.BEDROCK, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final DeferredItem<ArmorItem> BEDROCK_CHESTPLATE = ITEMS.register("bedrock_chestplate", () -> new ItemBedrockArmor(ArmorMaterials.BEDROCK, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final DeferredItem<ArmorItem> BEDROCK_LEGGINGS = ITEMS.register("bedrock_leggings", () -> new ItemBedrockArmor(ArmorMaterials.BEDROCK, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final DeferredItem<ArmorItem> BEDROCK_BOOTS = ITEMS.register("bedrock_boots", () -> new ItemBedrockArmor(ArmorMaterials.BEDROCK, ArmorItem.Type.BOOTS, new Item.Properties()));

}
