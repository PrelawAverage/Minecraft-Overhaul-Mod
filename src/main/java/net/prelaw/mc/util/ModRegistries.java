package net.prelaw.mc.util;

import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.prelaw.mc.MinecraftOverhaul;
import net.prelaw.mc.block.ModBlocks;
import net.prelaw.mc.item.ModItems;

public class ModRegistries {
    public static void registerModStuffs() {

    }

    private static void registerFuels() {
        System.out.println("Registering Fuels for " + MinecraftOverhaul.MOD_ID);
        FuelRegistry registry = FuelRegistry.INSTANCE;

        // Fuels
        registry.add(ModItems.LEAF, 10);

    }
}
