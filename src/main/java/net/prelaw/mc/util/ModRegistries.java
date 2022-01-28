package net.prelaw.mc.util;

import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.block.ComposterBlock;
import net.prelaw.mc.MinecraftOverhaul;
import net.prelaw.mc.block.ModBlocks;
import net.prelaw.mc.item.ModItems;

public class ModRegistries {
    public static void registerModStuffs() {
        registerFuels();
        registerFlammables();
        registerModComposterChances();
    }

    // This registers fuels into the game. Fuels are items/blocks used in furnaces.
    private static void registerFuels() {
        System.out.println("Registering Fuels for " + MinecraftOverhaul.MOD_ID);
        FuelRegistry registry = FuelRegistry.INSTANCE;
        // Fuels
        registry.add(ModItems.LEAF, 10);
    }

    // Here we Register the blocks that can burn from catching fire.
    private static void registerFlammables() {
        System.out.println("Registering Flammable Blocks for " + MinecraftOverhaul.MOD_ID);
        // Encouragement = Speed
        // Flammability = Spread
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.BOOKSHELF_STAIRS, 30, 20);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.BOOKSHELF_SLAB, 30, 20);
    }

    // Here we register Commands


    // Here we register Events


    // Here we register ModItems for the Composter Block to use.
    // The float at the end determines the chance of the item increasing the composter.
    // All Vanilla values can be seen by Middle-Mouse-Clicking the ITEM_TO_LEVEL_INCREASE_CHANCE Method
    private static void registerModComposterChances() {
        // Least to Greatest
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.LEAF, 0.10f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.COCONUT_SHELL, 0.30f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.COCONUT_OPENED, 0.50f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.COTTON_SEEDS, 0.65f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.ORANGE, 0.65f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.BANANA, 0.65f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.COCONUT, 0.65f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.FLOUR, 0.85f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.HONEY_GLAZED_APPLE, 0.85f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.PINEAPPLE, 0.85f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModBlocks.SHIVER_LEAF, 0.85f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.OLD_HERB_BUNDLE, 1.0f);
    }
}
