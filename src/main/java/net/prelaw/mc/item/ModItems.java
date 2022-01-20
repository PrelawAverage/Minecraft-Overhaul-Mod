package net.prelaw.mc.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.prelaw.mc.MinecraftOverhaul;

public class ModItems {

    // Items
    public static final Item LEAF = registerItem("leaf",
            new Item(new FabricItemSettings().group(ItemGroup.MISC)));

    public static final Item RAW_SILVER = registerItem("raw_silver",
            new Item(new FabricItemSettings().group(ItemGroup.MATERIALS)));

    public static final Item SILVER_INGOT = registerItem("silver_ingot",
            new Item(new FabricItemSettings().group(ItemGroup.MATERIALS)));

    public static final Item SILVER_NUGGET = registerItem("silver_nugget",
            new Item(new FabricItemSettings().group(ItemGroup.MATERIALS)));

    public static final Item THREAD = registerItem("thread",
            new Item(new FabricItemSettings().group(ItemGroup.MATERIALS)));

    public static final Item PELT = registerItem("pelt",
            new Item(new FabricItemSettings().group(ItemGroup.MATERIALS)));

    public static final Item BOUND_LEATHER = registerItem("bound_leather",
            new Item(new FabricItemSettings().group(ItemGroup.MATERIALS)));

    public static final Item TREATED_LEATHER = registerItem("treated_leather",
            new Item(new FabricItemSettings().group(ItemGroup.MATERIALS)));


    // Helper Method to help register the items
    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(MinecraftOverhaul.MOD_ID, name), item);
    }

    // Method that is used to register the items
    public static void registerModItems() {
        System.out.println("Registering Mod Items for " + MinecraftOverhaul.MOD_ID);
    }
}
