package net.prelaw.mc.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.prelaw.mc.MinecraftOverhaul;
import net.prelaw.mc.item.custom.foodstuffs.OrangeJuiceItem;
import net.prelaw.mc.item.custom.misc.OldBundleItems;
import net.prelaw.mc.item.custom.tools.OreDetectorItem;
import net.prelaw.mc.item.custom.foodstuffs.SweetBerryJuiceItem;

public class ModItems {

    // Misc
    public static final Item OLD_HERB_BUNDLE = registerItem("old_herb_bundle",
            new OldBundleItems(new FabricItemSettings().group(ItemGroup.MISC)));
    public static final Item OLD_MINERS_BUNDLE = registerItem("old_miners_bundle",
            new OldBundleItems(new FabricItemSettings().group(ItemGroup.MISC)));

    // Materials
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
    public static final Item FLOUR = registerItem("flour",
            new Item(new FabricItemSettings().group(ItemGroup.MATERIALS)));
    public static final Item COCONUT = registerItem("coconut",
            new Item(new FabricItemSettings().group(ItemGroup.FOOD)));
    public static final Item COCONUT_SHELL = registerItem("coconut_shell",
            new Item(new FabricItemSettings().group(ItemGroup.MATERIALS)));
    public static final Item PEARL = registerItem("pearl",
            new Item(new FabricItemSettings().group(ItemGroup.MATERIALS)));
    public static final Item PLATE = registerItem("plate",
            new Item(new FabricItemSettings().group(ItemGroup.MATERIALS)));

    // Foods
    public static final Item ORANGE = registerItem("orange",
            new Item(new FabricItemSettings().group(ItemGroup.FOOD).food(ModFoodComponents.ORANGE)));
    public static final Item BANANA = registerItem("banana",
            new Item(new FabricItemSettings().group(ItemGroup.FOOD).food(ModFoodComponents.BANANA)));
    public static final Item COCONUT_OPENED = registerItem("opened_coconut",
            new Item(new FabricItemSettings().food(ModFoodComponents.COCONUT_OPENED)));
    public static final Item PINEAPPLE = registerItem("pineapple",
            new Item(new FabricItemSettings().group(ItemGroup.FOOD).food(ModFoodComponents.ORANGE)));
    public static final Item HONEY_GLAZED_APPLE = registerItem("honey_glazed_apple",
            new Item(new FabricItemSettings().group(ItemGroup.FOOD).food(ModFoodComponents.HONEY_GLAZED_APPLE)));
    public static final Item SWEET_BERRY_JUICE = registerItem("sweet_berry_juice",
            new SweetBerryJuiceItem(new FabricItemSettings().group(ItemGroup.FOOD).food(ModFoodComponents.SWEET_BERRY_JUICE).maxCount(16)));
    public static final Item ORANGE_JUICE = registerItem("orange_juice",
            new OrangeJuiceItem(new FabricItemSettings().group(ItemGroup.FOOD).food(ModFoodComponents.ORANGE_JUICE).maxCount(16)));
    public static final Item SWEET_BERRY_DISH = registerItem("sweet_berry_dish",
            new StewItem(new FabricItemSettings().group(ItemGroup.FOOD).food(ModFoodComponents.ORANGE_JUICE).maxCount(1)));

    // Tools
    public static final Item ORE_DETECTOR = registerItem("ore_detector",
            new OreDetectorItem(new FabricItemSettings().group(ItemGroup.TOOLS).maxDamage(50)));

    // Weapons


    // Armor
    public static final Item TURTLE_CHESTPLATE = registerItem("turtle_chestplate",
            new ArmorItem(ArmorMaterials.TURTLE, EquipmentSlot.CHEST, new FabricItemSettings().group(ItemGroup.COMBAT)));
    public static final Item TURTLE_LEGGINGS = registerItem("turtle_leggings",
            new ArmorItem(ArmorMaterials.TURTLE, EquipmentSlot.LEGS, new FabricItemSettings().group(ItemGroup.COMBAT)));
    public static final Item TURTLE_BOOTS = registerItem("turtle_boots",
            new ArmorItem(ArmorMaterials.TURTLE, EquipmentSlot.FEET, new FabricItemSettings().group(ItemGroup.COMBAT)));

    // Horse Armor
    public static final Item HORSE_ARMOR_NETHERITE = registerItem("horse_armor_netherite",
            new HorseArmorItem(15, "netherite", new FabricItemSettings().group(ItemGroup.MISC)));

    // Helper Method to help register the items
    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(MinecraftOverhaul.MOD_ID, name), item);
    }

    // Method that is used to register the items
    public static void registerModItems() {
        System.out.println("Registering Mod Items for " + MinecraftOverhaul.MOD_ID);
    }
}
