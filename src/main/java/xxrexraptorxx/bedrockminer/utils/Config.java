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

    public static ForgeConfigSpec.BooleanValue WANDERING_TRADES;


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
        builder.pop();

        builder.comment("Items").push(CATEGORY_ITEMS);
        ARMOR_EFFECTS = builder.comment("Activate special effects if you wear Bedrock Armor (Slowness + Resistance)").define("armor_effects", false);
        WANDERING_TRADES = builder.comment("Enable trades of bedrock chunks from Wandering Traders").define("wandering_trades", true);
        builder.pop();

        builder.comment("Blocks").push(CATEGORY_BLOCKS);
        HARVEST_ONLY_BEDROCK = builder.comment("This makes that the Bedrock Breaker harvests only Bedrock or any block").define("harvest_only_bedrock", false);
        builder.pop();

        SERVER_CONFIG = builder.build();
    }


}
