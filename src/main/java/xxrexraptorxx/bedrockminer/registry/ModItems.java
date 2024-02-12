package xxrexraptorxx.bedrockminer.registry;

import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import xxrexraptorxx.bedrockminer.items.ItemBasic;
import xxrexraptorxx.bedrockminer.items.ItemBedrockArmor;
import xxrexraptorxx.bedrockminer.main.References;
import xxrexraptorxx.bedrockminer.utils.ArmorMaterials;

public class ModItems {

    private static float attackSpeedMultiplier = -0.2F;

    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, References.MODID);

    public static void init() {
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    public static final ForgeTier BEDROCK_TIER = new ForgeTier(Tiers.DIAMOND.getLevel(), 2500, 6.0F, 3.5F, 3, ModBlocks.NEEDS_BEDROCK_TOOL, () -> Ingredient.of(ModItems.BEDROCK_CHUNK.get()));


    public static final RegistryObject<ItemBasic> BEDROCK_CHUNK = ITEMS.register("bedrock_chunk", ItemBasic::new);

    public static final RegistryObject<SwordItem> BEDROCK_SWORD = ITEMS.register("bedrock_sword", () ->
            new SwordItem(BEDROCK_TIER, 3, -2.4f + attackSpeedMultiplier, new Item.Properties()));
    public static final RegistryObject<PickaxeItem> BEDROCK_PICKAXE = ITEMS.register("bedrock_pickaxe",
            () -> new PickaxeItem(BEDROCK_TIER, 1, -2.8F + attackSpeedMultiplier, new Item.Properties()));
    public static final RegistryObject<AxeItem> BEDROCK_AXE = ITEMS.register("bedrock_axe",
            () -> new AxeItem(BEDROCK_TIER, 5.0F, -3.0F + attackSpeedMultiplier, new Item.Properties()));
    public static final RegistryObject<ShovelItem> BEDROCK_SHOVEL = ITEMS.register("bedrock_shovel",
            () -> new ShovelItem(BEDROCK_TIER, 1.5F, -3.0F + attackSpeedMultiplier, new Item.Properties()));
    public static final RegistryObject<HoeItem> BEDROCK_HOE = ITEMS.register("bedrock_hoe",
            () -> new HoeItem(BEDROCK_TIER,-3, 0.0F + attackSpeedMultiplier, new Item.Properties()));

    public static final RegistryObject<ArmorItem> BEDROCK_HELMET = ITEMS.register("bedrock_helmet", () -> new ItemBedrockArmor(ArmorMaterials.BEDROCK, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<ArmorItem> BEDROCK_CHESTPLATE = ITEMS.register("bedrock_chestplate", () -> new ItemBedrockArmor(ArmorMaterials.BEDROCK, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<ArmorItem> BEDROCK_LEGGINGS = ITEMS.register("bedrock_leggings", () -> new ItemBedrockArmor(ArmorMaterials.BEDROCK, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<ArmorItem> BEDROCK_BOOTS = ITEMS.register("bedrock_boots", () -> new ItemBedrockArmor(ArmorMaterials.BEDROCK, ArmorItem.Type.BOOTS, new Item.Properties()));

}
