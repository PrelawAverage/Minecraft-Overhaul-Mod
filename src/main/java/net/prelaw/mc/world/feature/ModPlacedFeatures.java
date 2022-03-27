package net.prelaw.mc.world.feature;


import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.decorator.BiomePlacementModifier;
import net.minecraft.world.gen.decorator.HeightRangePlacementModifier;
import net.minecraft.world.gen.decorator.RarityFilterPlacementModifier;
import net.minecraft.world.gen.decorator.SquarePlacementModifier;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.PlacedFeatures;
import net.minecraft.world.gen.feature.VegetationPlacedFeatures;
import net.prelaw.mc.MinecraftOverhaul;

public class ModPlacedFeatures {
    public static final RegistryKey<PlacedFeature> PINK_SAKURA_PLACED_KEY = registerKey("pink_sakura_placed");
    public static final RegistryKey<PlacedFeature> SHIVER_LEAF_PLACED_KEY = registerKey("shiver_leaf_placed");
    public static final RegistryKey<PlacedFeature> FIRE_BLOSSOM_PLACED_KEY = registerKey("fire_blossom_placed");
    public static final RegistryKey<PlacedFeature> SILVER_ORE_PLACED_KEY = registerKey("silver_ore_placed");

    public static final PlacedFeature PINK_SAKURA_PLACED = registerPlacedFeature("pink_sakura_placed",
            ModConfiguredFeatures.PINK_SAKURA_TREE_RANDOM.withPlacement(VegetationPlacedFeatures.modifiers(
                    PlacedFeatures.createCountExtraModifier(0, 0.25f, 1))));

    public static final PlacedFeature SHIVER_LEAF_PLACED = registerPlacedFeature("shiver_leaf_placed",
            ModConfiguredFeatures.SHIVER_LEAF.withPlacement(RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(),
                    PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of()));
    public static final PlacedFeature FIRE_BLOSSOM_PLACED = registerPlacedFeature("fire_blossom_placed",
            ModConfiguredFeatures.FIRE_BLOSSOM.withPlacement(RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(),
                    PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of()));

    public static final PlacedFeature SILVER_ORE_PLACED = registerPlacedFeature("silver_ore_placed",
            ModConfiguredFeatures.SILVER_ORE.withPlacement(ModOreFeatures.modifiersWithCount(7,
                    HeightRangePlacementModifier.trapezoid(YOffset.aboveBottom(-80), YOffset.aboveBottom(80)))));



    // Registry
    private static PlacedFeature registerPlacedFeature(String name, PlacedFeature placedFeature) {
        return Registry.register(BuiltinRegistries.PLACED_FEATURE, new Identifier(MinecraftOverhaul.MOD_ID, name), placedFeature);
    }
    private static RegistryKey<PlacedFeature> registerKey(String name) {
        return RegistryKey.of(Registry.PLACED_FEATURE_KEY, new Identifier(MinecraftOverhaul.MOD_ID, name));
    }
}