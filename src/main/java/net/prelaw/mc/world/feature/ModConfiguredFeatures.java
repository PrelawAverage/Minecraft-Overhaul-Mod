package net.prelaw.mc.world.feature;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.trunk.ForkingTrunkPlacer;
import net.prelaw.mc.MinecraftOverhaul;
import net.prelaw.mc.block.ModBlocks;

import java.util.List;


public class ModConfiguredFeatures {
    public static final RegistryEntry<ConfiguredFeature<TreeFeatureConfig, ?>> PINK_SAKURA_TREE =
            ConfiguredFeatures.register("pink_sakura", Feature.TREE, new TreeFeatureConfig.Builder(
                    BlockStateProvider.of(ModBlocks.PINK_SAKURA_LOG),
                    // The way the logs will form
                    new ForkingTrunkPlacer(4, 5, 2),
                    BlockStateProvider.of(ModBlocks.PINK_SAKURA_LEAVES),
                    // The way the leaves will form
                    new BlobFoliagePlacer(ConstantIntProvider.create(1), ConstantIntProvider.create(0), 3),
                    new TwoLayersFeatureSize(1, 0, 2)).build());

    public static final RegistryEntry<PlacedFeature> PINK_SAKURA_CHECKED = PlacedFeatures.register("cherry_blossom_checked",
            PINK_SAKURA_TREE, PlacedFeatures.wouldSurvive(ModBlocks.PINK_SAKURA_SAPLING));

    public static final RegistryEntry<ConfiguredFeature<RandomFeatureConfig, ?>> PINK_SAKURA_SPAWN =
            ConfiguredFeatures.register("pink_sakura_spawn", Feature.RANDOM_SELECTOR,
                    new RandomFeatureConfig(List.of(new RandomFeatureEntry(PINK_SAKURA_CHECKED,
                            0.5F)), PINK_SAKURA_CHECKED));


    public static final RegistryEntry<ConfiguredFeature<RandomPatchFeatureConfig, ?>> SHIVER_LEAF =
            ConfiguredFeatures.register("shiver_leaf", Feature.FLOWER,
                    new RandomPatchFeatureConfig(32, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                            new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.SHIVER_LEAF)))));

    public static final RegistryEntry<ConfiguredFeature<RandomPatchFeatureConfig, ?>> FIRE_BLOSSOM =
            ConfiguredFeatures.register("fire_blossom", Feature.FLOWER,
                    new RandomPatchFeatureConfig(32, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                            new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.FIRE_BLOSSOM)))));

    public static final List<OreFeatureConfig.Target> OVERWORLD_SILVER_ORES = List.of(
            OreFeatureConfig.createTarget(OreConfiguredFeatures.STONE_ORE_REPLACEABLES, ModBlocks.SILVER_ORE.getDefaultState()),
            OreFeatureConfig.createTarget(OreConfiguredFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.DEEPSLATE_SILVER_ORE.getDefaultState()));

    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> SILVER_ORE = ConfiguredFeatures.register("silver_ore",
            Feature.ORE, new OreFeatureConfig(OVERWORLD_SILVER_ORES, 9));


    // Just Registers it
    public static void registerConfiguredFeatures() {
        System.out.println("Registering ModConfiguredFeatures for " + MinecraftOverhaul.MOD_ID);
    }
}