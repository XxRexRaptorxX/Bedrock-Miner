package xxrexraptorxx.bedrockminer.utils;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;

@Mod.EventBusSubscriber
public class Config {

    public static final String CATEGORY_GENERAL = "general";
    public static final String CATEGORY_ITEMS = "items";
    public static final String CATEGORY_BLOCKS = "blocks";

    public static ForgeConfigSpec SERVER_CONFIG;
    public static ForgeConfigSpec CLIENT_CONFIG;

    public static ForgeConfigSpec.BooleanValue UPDATE_CHECKER;
    public static ForgeConfigSpec.BooleanValue PATREON_REWARDS;
    public static ForgeConfigSpec.BooleanValue LOOT_GENERATION;

    public static ForgeConfigSpec.IntValue TOOL_DURABILITY;
    public static ForgeConfigSpec.DoubleValue TOOL_EFFICIENCY;
    public static ForgeConfigSpec.DoubleValue TOOL_DAMAGE;
    public static ForgeConfigSpec.DoubleValue TOOL_SPEED;
    public static ForgeConfigSpec.DoubleValue TOOL_ATTACK_SPEED_MODIFIER;
    public static ForgeConfigSpec.IntValue TOOL_ENCHANTABILITY;
    public static ForgeConfigSpec.BooleanValue HARVEST_ONLY_BEDROCK;

    public static ForgeConfigSpec.IntValue ARMOR_DURABILITY;
    public static ForgeConfigSpec.IntValue ARMOR_ENCHANTABILITY;
    public static ForgeConfigSpec.IntValue ARMOR_TOUGHNESS;
    public static ForgeConfigSpec.BooleanValue ARMOR_EFFECTS;


    public static void init() {
        initServer();
        initClient();

        ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, SERVER_CONFIG);
        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, CLIENT_CONFIG);
    }


    public static void initClient() {
        ForgeConfigSpec.Builder builder = new ForgeConfigSpec.Builder();

        builder.comment("General").push(CATEGORY_GENERAL);
        UPDATE_CHECKER = builder.comment("Activate the Update-Checker").define("update-checker", true);
        builder.pop();

        CLIENT_CONFIG = builder.build();
    }


    public static void initServer() {
        ForgeConfigSpec.Builder builder = new ForgeConfigSpec.Builder();

        builder.comment("General").push(CATEGORY_GENERAL);
        PATREON_REWARDS = builder.comment("Enables ingame rewards on first spawn for Patreons").define("patreon_rewards", true);
        LOOT_GENERATION = builder.comment("Activate the dungeon loot generation of the mod").define("loot_generation", true);
        builder.pop();

        builder.comment("Items").push(CATEGORY_ITEMS);
        ARMOR_EFFECTS = builder.comment("Activate special effects if you wear Bedrock Armor (Slowness + Resistance)").define("armor_effects", false);
        ARMOR_DURABILITY = builder.comment("Set the durability for bedrock armor").defineInRange("armor_durability", 50, 10, 1000);
        //ARMOR_ENCHANTABILITY = builder.comment("Set the enchantability for bedrock armor").defineInRange("armor_enchantability", 18, 0, 30);
        //ARMOR_TOUGHNESS = builder.comment("Set the toughness for bedrock armor").defineInRange("armor_toughness", 3, 0, 10);
        //TODO!!
        //TOOL_DURABILITY = builder.comment("Set the durability for bedrock tools").defineInRange("tool_durability", 2500, 50, 10000);
        //TOOL_EFFICIENCY = builder.comment("Set the efficiency for bedrock tools").defineInRange("tool_efficiency", 8.5F, 1.0F, 20.0F);
        //TOOL_DAMAGE = builder.comment("Set the damage for bedrock tools").defineInRange("tool_damage", 3.5F, 1.0F, 20.0F);
        //TOOL_SPEED = builder.comment("Set the speed for bedrock tools").defineInRange("tool_speed", 6.0F, 1.0F, 20.0F);
        //TOOL_ATTACK_SPEED_MODIFIER = builder.comment("Set the attack speed modifier for bedrock tools relative to the normal speed").defineInRange("tool_attack_speed_modifier", -0.2F, -5.0F, 20.0F);
        //TOOL_ENCHANTABILITY = builder.comment("Set the enchantability for bedrock tools").defineInRange("tool_enchantability", 3, 0, 20);
        builder.pop();

        builder.comment("Blocks").push(CATEGORY_BLOCKS);
        HARVEST_ONLY_BEDROCK = builder.comment("This makes that the Bedrock Breaker harvests only Bedrock or any block").define("harvest_only_bedrock", false);
        builder.pop();

        SERVER_CONFIG = builder.build();
    }


}
