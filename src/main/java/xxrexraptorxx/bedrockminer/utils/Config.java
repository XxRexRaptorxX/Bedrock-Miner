package xxrexraptorxx.bedrockminer.utils;

import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import com.electronwill.nightconfig.core.io.WritingMode;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;

import java.nio.file.Path;

@Mod.EventBusSubscriber
public class Config {

    public static final String CATEGORY_GENERAL = "general";
    public static final String CATEGORY_ITEMS = "items";
    public static final String CATEGORY_BLOCKS = "blocks";

    private static final ForgeConfigSpec.Builder COMMON_BUILDER = new ForgeConfigSpec.Builder();
    private static final ForgeConfigSpec.Builder CLIENT_BUILDER = new ForgeConfigSpec.Builder();

    public static ForgeConfigSpec COMMON_CONFIG;
    public static ForgeConfigSpec CLIENT_CONFIG;


    public static ForgeConfigSpec.BooleanValue UPDATE_CHECKER;
    public static ForgeConfigSpec.BooleanValue WORLD_GENERATION;
    public static ForgeConfigSpec.BooleanValue LOOT_GENERATION;

    public static ForgeConfigSpec.IntValue TOOL_DURABILITY;
    public static ForgeConfigSpec.DoubleValue TOOL_EFFICIENCY;
    public static ForgeConfigSpec.DoubleValue TOOL_DAMAGE;
    public static ForgeConfigSpec.IntValue TOOL_ENCHANTABILITY;
    public static ForgeConfigSpec.BooleanValue BEDROCK_ARMOR_EFFECTS;
    public static ForgeConfigSpec.BooleanValue HARVEST_OPERATOR_STUFF;


    static {
        COMMON_BUILDER.comment("General settings").push(CATEGORY_GENERAL);
        UPDATE_CHECKER = COMMON_BUILDER.comment("Activate the Update-Checker").define("update-checker", true);
        WORLD_GENERATION = COMMON_BUILDER.comment("Activate the world generation of the mod").define("world_generation", true);
        LOOT_GENERATION = COMMON_BUILDER.comment("Activate the dungeon loot generation of the mod").define("loot_generation", true);
        COMMON_BUILDER.pop();

        COMMON_BUILDER.comment("Item settings").push(CATEGORY_ITEMS);
        TOOL_DURABILITY = COMMON_BUILDER.comment("Set the durability for bedrock tools").defineInRange("tool_durability", 2500, 50, 10000);
        TOOL_EFFICIENCY = COMMON_BUILDER.comment("Set the efficiency for bedrock tools").defineInRange("tool_efficiency", 8.5F, 1.0F, 20.0F);
        TOOL_DAMAGE = COMMON_BUILDER.comment("Set the damage for bedrock tools").defineInRange("tool_damage", 3.5F, 1.0F, 20.0F);
        TOOL_ENCHANTABILITY = COMMON_BUILDER.comment("Set the enchantability for bedrock tools").defineInRange("tool_enchantability", 3, 0, 20);
        BEDROCK_ARMOR_EFFECTS = COMMON_BUILDER.comment("Activate special effects if you wear Bedrock Armor").define("bedrock_armor_effects", true);
        COMMON_BUILDER.pop();

        COMMON_BUILDER.comment("Block settings").push(CATEGORY_BLOCKS);
        HARVEST_OPERATOR_STUFF = COMMON_BUILDER.comment("This makes that the Bedrock Breaker harvests Commandblocks, Structureblocks, ... too!").define("harvest_operator_stuff", true);
        COMMON_BUILDER.pop();

        COMMON_CONFIG = COMMON_BUILDER.build();
        CLIENT_CONFIG = CLIENT_BUILDER.build();
    }




    public static void loadConfig(ForgeConfigSpec spec, Path path) {

        final CommentedFileConfig configData = CommentedFileConfig.builder(path)
                .sync()
                .autosave()
                .writingMode(WritingMode.REPLACE)
                .build();

        configData.load();
        spec.setConfig(configData);
    }


    @SubscribeEvent
    public static void onLoad(final ModConfig.Loading configEvent) {

    }


    @SubscribeEvent
    public static void onReload(final ModConfig.ConfigReloading configEvent) {
    }
}
