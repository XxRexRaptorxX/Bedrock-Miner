package xxrexraptorxx.bedrockminer.utils;

import net.neoforged.neoforge.common.ModConfigSpec;

public class Config {

    private static final ModConfigSpec.Builder SERVER_BUILDER = new ModConfigSpec.Builder();
    private static final ModConfigSpec.Builder STARTUP_BUILDER = new ModConfigSpec.Builder();
    private static final ModConfigSpec.Builder CLIENT_BUILDER = new ModConfigSpec.Builder();

    public static ModConfigSpec SERVER_CONFIG;
    public static ModConfigSpec STARTUP_CONFIG;
    public static ModConfigSpec CLIENT_CONFIG;

    private static final ModConfigSpec.BooleanValue UPDATE_CHECKER;
    private static final ModConfigSpec.BooleanValue PATREON_REWARDS;

    private static final ModConfigSpec.IntValue TOOL_DURABILITY_MULTIPLIER;
    private static final ModConfigSpec.DoubleValue TOOL_EFFICIENCY;
    private static final ModConfigSpec.DoubleValue TOOL_DAMAGE;
    private static final ModConfigSpec.IntValue TOOL_ENCHANTABILITY;
    private static final ModConfigSpec.BooleanValue HARVEST_ONLY_BEDROCK;
    private static final ModConfigSpec.IntValue MOB_DAMAGE;
    private static final ModConfigSpec.IntValue ARMOR_DURABILITY_MULTIPLIER;
    private static final ModConfigSpec.DoubleValue ARMOR_KNOCKBACK_RESISTANCE;
    private static final ModConfigSpec.IntValue ARMOR_ENCHANTABILITY;
    private static final ModConfigSpec.DoubleValue ARMOR_TOUGHNESS;
    private static final ModConfigSpec.BooleanValue ARMOR_EFFECTS;
    private static final ModConfigSpec.BooleanValue WANDERING_TRADES;


    //CLIENT
    static {
        setCategory(CLIENT_BUILDER, "general");
        UPDATE_CHECKER =        CLIENT_BUILDER.comment("Activate the Update-Checker").define("update-checker", true);
        CLIENT_BUILDER.pop();

        CLIENT_CONFIG = CLIENT_BUILDER.build();
    }


    //SERVER
    static {
        setCategory(SERVER_BUILDER, "general");
        PATREON_REWARDS =       SERVER_BUILDER.comment("Enables ingame rewards on first spawn for Patreons").define("patreon_rewards", true);
        SERVER_BUILDER.pop();

        setCategory(SERVER_BUILDER, "blocks");
        HARVEST_ONLY_BEDROCK =      SERVER_BUILDER.comment("This makes that the bedrock breaker harvests only bedrock or any block").define("harvest_only_bedrock", false);
        MOB_DAMAGE = SERVER_BUILDER.comment("How much damage should the bedrock breaker do to creatures").defineInRange("mob_damage", 4, 0, 1000);
        SERVER_BUILDER.pop();

        setCategory(SERVER_BUILDER, "armor");
        ARMOR_EFFECTS =     SERVER_BUILDER.comment("Activate special effects if you wear bedrock armor (Slowness + Resistance)").define("armor_effects", false);
        SERVER_BUILDER.pop();

        SERVER_CONFIG = SERVER_BUILDER.build();
    }


    //STARTUP
    static {
        setCategory(STARTUP_BUILDER, "general");
        WANDERING_TRADES =       STARTUP_BUILDER.comment("Enable trades of bedrock chunks from Wandering Traders").define("wandering_trades", true);
        STARTUP_BUILDER.pop();

        setCategory(STARTUP_BUILDER, "armor");
        ARMOR_DURABILITY_MULTIPLIER =   STARTUP_BUILDER.comment("Set the durability for bedrock armor").defineInRange("armor_durability_multiplier", 500, 10, 10000);
        ARMOR_ENCHANTABILITY =          STARTUP_BUILDER.comment("Set the enchantability for bedrock armor").defineInRange("armor_enchantability", 18, 1, 30);
        ARMOR_KNOCKBACK_RESISTANCE =    STARTUP_BUILDER.comment("Set the knockback resistance for bedrock armor").defineInRange("armor_knockback_resistance", 0.5f, 0, 1);
        ARMOR_TOUGHNESS =               STARTUP_BUILDER.comment("Set the toughness for bedrock armor").defineInRange("armor_toughness", 0.8F, 0, 10);
        STARTUP_BUILDER.pop();

        setCategory(STARTUP_BUILDER, "tools");
        TOOL_DURABILITY_MULTIPLIER =       STARTUP_BUILDER.comment("Set the durability for bedrock tools").defineInRange("tool_durability", 50, 10, 10000);
        TOOL_EFFICIENCY =       STARTUP_BUILDER.comment("Set the efficiency for bedrock tools").defineInRange("tool_efficiency", 6.0F, 1.0F, 20.0F);
        TOOL_DAMAGE =           STARTUP_BUILDER.comment("Set the damage for bedrock tools").defineInRange("tool_damage", 3.5F, 1.0F, 20.0F);
        TOOL_ENCHANTABILITY =   STARTUP_BUILDER.comment("Set the enchantability for bedrock tools").defineInRange("tool_enchantability", 3, 1, 20);
        STARTUP_BUILDER.pop();

        STARTUP_CONFIG = STARTUP_BUILDER.build();
    }


    public static boolean getUpdateChecker()            { return UPDATE_CHECKER.get();                          }
    public static boolean getPatreonRewards()           { return PATREON_REWARDS.get();                         }
    public static int getToolDurabilityMultiplier()     { return TOOL_DURABILITY_MULTIPLIER.get();              }
    public static float getToolEfficiency()             { return TOOL_EFFICIENCY.get().floatValue();            }
    public static float getToolDamage()                 { return TOOL_DAMAGE.get().floatValue();                }
    public static int getToolEnchantability()           { return TOOL_ENCHANTABILITY.get();                     }
    public static float getArmorKnockbackResistance()   { return ARMOR_KNOCKBACK_RESISTANCE.get().floatValue(); }
    public static boolean getHarvestOnlyBedrock()       { return HARVEST_ONLY_BEDROCK.get();                    }
    public static int getMobDamage()                    { return MOB_DAMAGE.get();                              }
    public static int getArmorDurability()              { return ARMOR_DURABILITY_MULTIPLIER.get();             }
    public static int getArmorEnchantability()          { return ARMOR_ENCHANTABILITY.get();                    }
    public static float getArmorToughness()             { return ARMOR_TOUGHNESS.get().floatValue();            }
    public static boolean getArmorEffects()             { return ARMOR_EFFECTS.get();                           }
    public static boolean getWanderingTrades()          { return WANDERING_TRADES.get();                        }


    private static void setCategory(ModConfigSpec.Builder builder, String name) {
        builder.push(name).comment(Character.toUpperCase(name.charAt(0)) + name.substring(1));
    }
}