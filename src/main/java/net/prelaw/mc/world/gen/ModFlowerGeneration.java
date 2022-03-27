package net.prelaw.mc.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStep;
import net.prelaw.mc.world.feature.ModPlacedFeatures;

public class ModFlowerGeneration {
    public static void generateFlowers() {
        BiomeModifications.addFeature(BiomeSelectors.categories(Biome.Category.ICY),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.SHIVER_LEAF_PLACED_KEY);

        BiomeModifications.addFeature(BiomeSelectors.categories(Biome.Category.NETHER),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.FIRE_BLOSSOM_PLACED_KEY);
    }
}
