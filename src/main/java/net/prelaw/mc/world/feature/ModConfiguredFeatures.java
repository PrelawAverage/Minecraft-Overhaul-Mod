package net.prelaw.mc.world.feature;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.trunk.ForkingTrunkPlacer;
import net.prelaw.mc.MinecraftOverhaul;
import net.prelaw.mc.block.ModBlocks;

import java.util.List;


public class ModConfiguredFeatures {
    public static final ConfiguredFeature<TreeFeatureConfig, ?> PINK_SAKURA_TREE =
            register("pink_sakura", Feature.TREE.configure(new TreeFeatureConfig.Builder(
                    BlockStateProvider.of(ModBlocks.PINK_SAKURA_LOG),
                    // The way the logs will form
                    new ForkingTrunkPlacer(4, 5, 2),
                    BlockStateProvider.of(ModBlocks.PINK_SAKURA_LEAVES),
                    // The way the leaves will form
                    new BlobFoliagePlacer(ConstantIntProvider.create(1), ConstantIntProvider.create(0), 3),
                    new TwoLayersFeatureSize(1, 0, 2)).build()));


    public static final ConfiguredFeature<RandomFeatureConfig, ?> PINK_SAKURA_TREE_RANDOM = register("pink_sakura_feature",
            Feature.RANDOM_SELECTOR.configure(new RandomFeatureConfig(List.of(new RandomFeatureEntry(
                    PINK_SAKURA_TREE.withWouldSurviveFilter(ModBlocks.PINK_SAKURA_SAPLING), 0.1f)),
                    PINK_SAKURA_TREE.withWouldSurviveFilter(ModBlocks.PINK_SAKURA_SAPLING))));


    public static final ConfiguredFeature<RandomPatchFeatureConfig, ?> SHIVER_LEAF =
            ModConfiguredFeatures.register("shiver_leaf", Feature.FLOWER.configure(
                    createRandomPatchFeatureConfig(BlockStateProvider.of(ModBlocks.SHIVER_LEAF), 64)));

    public static final ConfiguredFeature<RandomPatchFeatureConfig, ?> FIRE_BLOSSOM =
            ModConfiguredFeatures.register("fire_blossom", Feature.RANDOM_PATCH.configure(
                    createRandomPatchFeatureConfig(BlockStateProvider.of(ModBlocks.FIRE_BLOSSOM), 64)));


    private static RandomPatchFeatureConfig createRandomPatchFeatureConfig(BlockStateProvider block, int tries) {
        return ConfiguredFeatures.createRandomPatchFeatureConfig(tries,
                Feature.SIMPLE_BLOCK.configure(new SimpleBlockFeatureConfig(block)).withInAirFilter());
    }

    public static final List<OreFeatureConfig.Target> OVERWORLD_SILVER_ORES = List.of(
            OreFeatureConfig.createTarget(OreConfiguredFeatures.STONE_ORE_REPLACEABLES, ModBlocks.SILVER_ORE.getDefaultState()),
            OreFeatureConfig.createTarget(OreConfiguredFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.DEEPSLATE_SILVER_ORE.getDefaultState()));

    public static final ConfiguredFeature<?, ?> SILVER_ORE = register("silver_ore",
            Feature.ORE.configure(new OreFeatureConfig(OVERWORLD_SILVER_ORES, 9)));

    public static <FC extends FeatureConfig> ConfiguredFeature<FC, ?> register(String name, ConfiguredFeature<FC, ?> configuredFeature) {
        return Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier(MinecraftOverhaul.MOD_ID, name),
                configuredFeature);
    }

    // Just Registers it
    public static void registerConfiguredFeatures() {
        System.out.println("Registering ModConfiguredFeatures for " + MinecraftOverhaul.MOD_ID);
    }
}