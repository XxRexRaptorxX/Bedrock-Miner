package xxrexraptorxx.bedrockminer.main;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.*;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import xxrexraptorxx.bedrockminer.items.ItemBasic;
import xxrexraptorxx.bedrockminer.items.ItemBedrockArmor;
import xxrexraptorxx.bedrockminer.utils.ArmorMaterials;
import xxrexraptorxx.bedrockminer.utils.CreativeTab;
import xxrexraptorxx.bedrockminer.utils.ToolMaterials;

public class ModItems {

    private static float attackSpeedMultiplier = -0.2F;

    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, References.MODID);

    public static void init() {
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }


    public static final RegistryObject<ItemBasic> BEDROCK_CHUNK = ITEMS.register("bedrock_chunk", ItemBasic::new);

    public static final RegistryObject<SwordItem> BEDROCK_SWORD = ITEMS.register("bedrock_sword", () ->
            new SwordItem(ToolMaterials.BEDROCK, 3, -2.4f + attackSpeedMultiplier, new Item.Properties().tab(CreativeTab.MOD_TAB)));
    public static final RegistryObject<PickaxeItem> BEDROCK_PICKAXE = ITEMS.register("bedrock_pickaxe",
            () -> new PickaxeItem(ToolMaterials.BEDROCK, 1, -2.8F + attackSpeedMultiplier, new Item.Properties().tab(CreativeTab.MOD_TAB)));
    public static final RegistryObject<AxeItem> BEDROCK_AXE = ITEMS.register("bedrock_axe",
            () -> new AxeItem(ToolMaterials.BEDROCK, 5.0F, -3.0F + attackSpeedMultiplier, new Item.Properties().tab(CreativeTab.MOD_TAB)));
    public static final RegistryObject<ShovelItem> BEDROCK_SHOVEL = ITEMS.register("bedrock_shovel",
            () -> new ShovelItem(ToolMaterials.BEDROCK, 1.5F, -3.0F + attackSpeedMultiplier, new Item.Properties().tab(CreativeTab.MOD_TAB)));
    public static final RegistryObject<HoeItem> BEDROCK_HOE = ITEMS.register("bedrock_hoe",
            () -> new HoeItem(ToolMaterials.BEDROCK,-3, 0.0F + attackSpeedMultiplier, new Item.Properties().tab(CreativeTab.MOD_TAB)));

    public static final RegistryObject<ArmorItem> BEDROCK_HELMET = ITEMS.register("bedrock_helmet", () -> new ItemBedrockArmor(ArmorMaterials.BEDROCK, EquipmentSlot.HEAD, new Item.Properties().tab(CreativeTab.MOD_TAB)));
    public static final RegistryObject<ArmorItem> BEDROCK_CHESTPLATE = ITEMS.register("bedrock_chestplate", () -> new ItemBedrockArmor(ArmorMaterials.BEDROCK, EquipmentSlot.CHEST, new Item.Properties().tab(CreativeTab.MOD_TAB)));
    public static final RegistryObject<ArmorItem> BEDROCK_LEGGINGS = ITEMS.register("bedrock_leggings", () -> new ItemBedrockArmor(ArmorMaterials.BEDROCK, EquipmentSlot.LEGS, new Item.Properties().tab(CreativeTab.MOD_TAB)));
    public static final RegistryObject<ArmorItem> BEDROCK_BOOTS = ITEMS.register("bedrock_boots", () -> new ItemBedrockArmor(ArmorMaterials.BEDROCK, EquipmentSlot.FEET, new Item.Properties().tab(CreativeTab.MOD_TAB)));

}
