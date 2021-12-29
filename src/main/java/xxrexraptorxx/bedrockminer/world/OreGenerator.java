package xxrexraptorxx.bedrockminer.world;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ForgeRegistries;
import xxrexraptorxx.bedrockminer.main.ModBlocks;
import xxrexraptorxx.bedrockminer.utils.Config;

public class OreGenerator {

    public static void setupOreGeneration() {
        for (Biome biome : ForgeRegistries.BIOMES) {
            if (Config.WORLD_GENERATION.get() ) {                                                                                                                                                                                               // vein size                                             rarity           minY           maxY          max
                biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, ModBlocks.BEDROCK_INFUSED_STONE.getDefaultState(), 10), Placement.COUNT_RANGE, new CountRangeConfig(15, 1, 5, 10)));
            }
        }
    }
}