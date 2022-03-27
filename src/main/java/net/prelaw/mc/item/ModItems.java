package net.prelaw.mc.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.prelaw.mc.MinecraftOverhaul;
import net.prelaw.mc.block.ModBlocks;
import net.prelaw.mc.entity.ModEntities;
import net.prelaw.mc.item.custom.ModPickaxeItem;
import net.prelaw.mc.item.custom.foodstuffs.OrangeJuiceItem;
import net.prelaw.mc.item.custom.misc.OldBundleItems;
import net.prelaw.mc.item.custom.tools.OreDetectorItem;
import net.prelaw.mc.item.custom.foodstuffs.SweetBerryJuiceItem;
import net.prelaw.mc.item.custom.weapons.ShortBowItem;
import net.prelaw.mc.item.util.*;
import net.prelaw.mc.sound.ModSounds;

public class ModItems {

    // Misc
    public static final Item OLD_HERB_BUNDLE = registerItem("old_herb_bundle",
            new OldBundleItems(new FabricItemSettings().group(ItemGroup.MISC)));
    public static final Item OLD_MINERS_BUNDLE = registerItem("old_miners_bundle",
            new OldBundleItems(new FabricItemSettings().group(ItemGroup.MISC)));
    public static final Item COTTON_SEEDS = registerItem("cotton_seeds",
            new AliasedBlockItem(ModBlocks.COTTON_CROP,
                    new FabricItemSettings().group(ItemGroup.MISC)));
    public static final Item MUSIC_DISC_AVIVA = registerItem("music_disc_aviva",
            new ModMusicDiscItem(9, ModSounds.MUSIC_AVIVA,
                    new FabricItemSettings().group(ItemGroup.MISC).maxCount(1)));
    public static final Item MUSIC_DISC_FLAKE = registerItem("music_disc_flake",
            new ModMusicDiscItem(9, ModSounds.MUSIC_FLAKE,
                    new FabricItemSettings().group(ItemGroup.MISC).maxCount(1)));
    public static final Item PINK_SAKURA_SIGN = registerItem("pink_sakura_sign",
            new SignItem(new FabricItemSettings().group(ItemGroup.MISC).maxCount(1),
                    ModBlocks.PINK_SAKURA_SIGN_BLOCK, ModBlocks.PINK_SAKURA_WALL_SIGN_BLOCK));
    public static final Item JUMBO_SPAWN_EGG = registerItem("jumbo_spawn_egg",
            new SpawnEggItem(ModEntities.JUMBO, 0x948e8d, 0x948e8d, new FabricItemSettings().group(ItemGroup.MISC)));
    public static final Item RED_SHROOMITE_SPAWN_EGG = registerItem("red_shroomite_spawn_egg",
            new SpawnEggItem(ModEntities.RED_SHROOM, 0x948e8d, 0x948e8d, new FabricItemSettings().group(ItemGroup.MISC)));
    public static final Item JOLLY_LLAMA_SPAWN_EGG = registerItem("jolly_llama_spawn_egg",
            new SpawnEggItem(ModEntities.JOLLY_LLAMA, 0x948e8d, 0x948e8d, new FabricItemSettings().group(ItemGroup.MISC)));

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
    public static final Item COTTON = registerItem("cotton",
            new Item(new FabricItemSettings().group(ItemGroup.MATERIALS)));
    public static final Item ROSE_GOLD_INGOT = registerItem("rose_gold_ingot",
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
    public static final Item CORAL_PICKAXE = registerItem("coral_pickaxe",
            new ModPickaxeItem(ModToolMaterial.CORAL, 1, -2.8f, new FabricItemSettings().group(ItemGroup.TOOLS)));
    public static final Item CORAL_SHOVEL = registerItem("coral_shovel",
            new ShovelItem(ModToolMaterial.CORAL, 1.5f, -3.0f, new FabricItemSettings().group(ItemGroup.TOOLS)));
    public static final Item CORAL_AXE = registerItem("coral_axe",
            new ModAxeItem(ModToolMaterial.CORAL, 7.0f, -3.2f, new FabricItemSettings().group(ItemGroup.TOOLS)));
    public static final Item CORAL_HOE = registerItem("coral_hoe", (
            new ModHoeItem(ModToolMaterial.CORAL, -1, -2.0f, new FabricItemSettings().group(ItemGroup.TOOLS))));

    // Weapons
    public static final Item CORAL_SWORD = registerItem("coral_sword",
            new SwordItem(ModToolMaterial.CORAL, 3, -2.4f, new FabricItemSettings().group(ItemGroup.COMBAT)));
    public static final Item SHORT_BOW = registerItem("short_bow",
            new ShortBowItem(new FabricItemSettings().group(ItemGroup.COMBAT)));

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
