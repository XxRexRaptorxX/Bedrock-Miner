package xxrexraptorxx.bedrockminer.utils;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.config.ModConfigEvent;
import net.neoforged.neoforge.common.ModConfigSpec;

public class Config {

    public static final String CATEGORY_GENERAL = "general";
    public static final String CATEGORY_ITEMS = "items";
    public static final String CATEGORY_BLOCKS = "blocks";

    public static ModConfigSpec SERVER_CONFIG;
    public static ModConfigSpec CLIENT_CONFIG;

    private static ModConfigSpec.BooleanValue UPDATE_CHECKER;
    private static ModConfigSpec.BooleanValue PATREON_REWARDS;

    private static ModConfigSpec.IntValue TOOL_DURABILITY;
    private static ModConfigSpec.DoubleValue TOOL_EFFICIENCY;
    private static ModConfigSpec.DoubleValue TOOL_DAMAGE;
    private static ModConfigSpec.IntValue TOOL_ENCHANTABILITY;
    private static ModConfigSpec.BooleanValue HARVEST_ONLY_BEDROCK;
    private static ModConfigSpec.IntValue MOB_DAMAGE;
    private static ModConfigSpec.IntValue ARMOR_DURABILITY_MULTIPLIER;
    private static ModConfigSpec.DoubleValue ARMOR_KNOCKBACK_RESISTANCE;
    private static ModConfigSpec.IntValue ARMOR_ENCHANTABILITY;
    private static ModConfigSpec.DoubleValue ARMOR_TOUGHNESS;
    private static ModConfigSpec.BooleanValue ARMOR_EFFECTS;
    private static ModConfigSpec.BooleanValue WANDERING_TRADES;

    private static boolean update_checker = true;
    private static boolean patreon_rewards = true;

    private static int tool_durability = 2500;
    private static double tool_efficiency = 6.0f;
    private static double tool_damage = 3.5f;
    private static int tool_enchantability = 3;
    private static boolean harvest_only_bedrock = false;
    private static int mob_damage = 4;
    private static int armor_durability = 50;
    private static int armor_enchantability = 18;
    public static double armor_knockback_resistance = 0.5f;
    private static double armor_toughness = 0.8F;
    private static boolean armor_effects = true;
    private static boolean wandering_trades = true;


    public static boolean getUpdateChecker() { return update_checker; }
    public static boolean getPatreonRewards() { return patreon_rewards; }
    public static int getToolDurability() { return tool_durability; }
    public static float getToolEfficiency() { return (float) tool_efficiency; }
    public static float getToolDamage() { return (float) tool_damage; }
    public static int getToolEnchantability() { return tool_enchantability; }
    public static float getArmorKnockbackResistance() { return (float) armor_knockback_resistance; }
    public static boolean getHarvestOnlyBedrock() { return harvest_only_bedrock; }
    public static int getMobDamage() { return mob_damage; }
    public static int getArmorDurability() { return armor_durability; }
    public static int getArmorEnchantability() { return armor_enchantability; }
    public static float getArmorToughness() { return (float) armor_toughness; }
    public static boolean getArmorEffets() { return armor_effects; }
    public static boolean getWanderingTrades() { return wandering_trades; }


    public static void init(ModContainer container) {
        initServer();
        initClient();

        container.registerConfig(ModConfig.Type.SERVER, SERVER_CONFIG);
        container.registerConfig(ModConfig.Type.CLIENT, CLIENT_CONFIG);
    }


    public static void initClient() {
        ModConfigSpec.Builder builder = new ModConfigSpec.Builder();

        builder.comment("General").push(CATEGORY_GENERAL);
        UPDATE_CHECKER = builder.comment("Activate the Update-Checker").define("update-checker", true);
        builder.pop();

        CLIENT_CONFIG = builder.build();
    }


    public static void initServer() {
        ModConfigSpec.Builder builder = new ModConfigSpec.Builder();

        builder.comment("General").push(CATEGORY_GENERAL);
        PATREON_REWARDS = builder.comment("Enables ingame rewards on first spawn for Patreons").define("patreon_rewards", true);
        WANDERING_TRADES = builder.comment("Enable trades of bedrock chunks from Wandering Traders").define("wandering_trades", true);
        builder.pop();

        builder.comment("Items").push(CATEGORY_ITEMS);
        ARMOR_DURABILITY_MULTIPLIER = builder.comment("Set the durability for bedrock armor").defineInRange("armor_durability_multiplier", 50, 1, 1000);
        ARMOR_ENCHANTABILITY = builder.comment("Set the enchantability for bedrock armor").defineInRange("armor_enchantability", 18, 0, 30);
        ARMOR_KNOCKBACK_RESISTANCE = builder.comment("Set the knockback resistance for bedrock armor").defineInRange("armor_knockback_resistance", 0.5f, 0, 10);
        ARMOR_TOUGHNESS = builder.comment("Set the toughness for bedrock armor").defineInRange("armor_toughness", 0.8F, 0, 10);
        ARMOR_EFFECTS = builder.comment("Activate special effects if you wear bedrock armor (Slowness + Resistance)").define("armor_effects", false);

        TOOL_DURABILITY = builder.comment("Set the durability for bedrock tools").defineInRange("tool_durability", 50, 50, 10000);
        TOOL_EFFICIENCY = builder.comment("Set the efficiency for bedrock tools").defineInRange("tool_efficiency", 6.0F, 1.0F, 20.0F);
        TOOL_DAMAGE = builder.comment("Set the damage for bedrock tools").defineInRange("tool_damage", 3.5F, 1.0F, 20.0F);
        TOOL_ENCHANTABILITY = builder.comment("Set the enchantability for bedrock tools").defineInRange("tool_enchantability", 3, 0, 20);
        builder.pop();

        builder.comment("Blocks").push(CATEGORY_BLOCKS);
        HARVEST_ONLY_BEDROCK = builder.comment("This makes that the bedrock breaker harvests only bedrock or any block").define("harvest_only_bedrock", false);
        MOB_DAMAGE = builder.comment("How much damage should the bedrock breaker do to creatures").defineInRange("mob_damage", 4, 0, 1000);
        builder.pop();

        SERVER_CONFIG = builder.build();
    }


    @SubscribeEvent
    public static void onConfigLoading(final ModConfigEvent.Loading event) {
        if (CLIENT_CONFIG.isLoaded()) {
            update_checker = UPDATE_CHECKER.get();

        } else if (SERVER_CONFIG.isLoaded()) {
            tool_durability = TOOL_DURABILITY.get();
            tool_efficiency = TOOL_EFFICIENCY.get();
            tool_damage = TOOL_DAMAGE.get();
            tool_enchantability = TOOL_ENCHANTABILITY.get();
            harvest_only_bedrock = HARVEST_ONLY_BEDROCK.get();
            mob_damage = MOB_DAMAGE.get();
            armor_durability = ARMOR_DURABILITY_MULTIPLIER.get();
            armor_enchantability = ARMOR_ENCHANTABILITY.get();
            armor_knockback_resistance = ARMOR_KNOCKBACK_RESISTANCE.get();
            armor_toughness = ARMOR_TOUGHNESS.get();
            armor_effects = ARMOR_EFFECTS.get();
            wandering_trades = WANDERING_TRADES.get();
            patreon_rewards = PATREON_REWARDS.get();
        }
    }

}
