package net.prelaw.mc.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.prelaw.mc.MinecraftOverhaul;
import net.prelaw.mc.block.custom.crops.ModCottonBlock;
import net.prelaw.mc.block.custom.flowers.PottedShiverLeafFlowerBlock;
import net.prelaw.mc.block.custom.flowers.ShiverLeafFlowerBlock;
import net.prelaw.mc.block.custom.util.ModDoorBlock;
import net.prelaw.mc.block.custom.util.ModPressurePlateBlock;
import net.prelaw.mc.block.custom.util.ModStairBlock;
import net.prelaw.mc.block.custom.util.ModStoneButtonBlock;
import org.lwjgl.system.CallbackI;


public class ModBlocks {

    // Building Blocks
    public static final Block COMPRESSED_COAL_BLOCK = registerBlock("compressed_coal_block",
            new Block(FabricBlockSettings.of(Material.STONE).strength(22.5f, 600).requiresTool().sounds(BlockSoundGroup.STONE)), ItemGroup.BUILDING_BLOCKS);
    public static final Block RAW_SILVER_BLOCK = registerBlock("raw_silver_block",
            new Block(FabricBlockSettings.of(Material.STONE).strength(5f, 6).requiresTool().sounds(BlockSoundGroup.STONE)), ItemGroup.BUILDING_BLOCKS);
    public static final Block SILVER_BLOCK = registerBlock("silver_block",
            new Block(FabricBlockSettings.of(Material.STONE).strength(5f, 6).requiresTool().sounds(BlockSoundGroup.STONE)), ItemGroup.BUILDING_BLOCKS);
    public static final Block SILVER_ORE = registerBlock("silver_ore",
            new Block(FabricBlockSettings.of(Material.STONE).strength(3f, 3).requiresTool().sounds(BlockSoundGroup.STONE)), ItemGroup.BUILDING_BLOCKS);
    public static final Block DEEPSLATE_SILVER_ORE = registerBlock("deepslate_silver_ore",
            new Block(FabricBlockSettings.of(Material.STONE).strength(4.5f, 3).requiresTool().sounds(BlockSoundGroup.STONE)), ItemGroup.BUILDING_BLOCKS);
    public static final Block SMOOTH_SANDSTONE_BRICK = registerBlock("smooth_sandstone_brick",
            new Block(FabricBlockSettings.of(Material.STONE).strength(4.5f, 3).requiresTool().sounds(BlockSoundGroup.STONE)), ItemGroup.BUILDING_BLOCKS);
    public static final Block PACKED_ICE_STAIRS = registerBlock("packed_ice_stairs",
            new ModStairBlock(Blocks.ICE.getDefaultState(), FabricBlockSettings.of(Material.DENSE_ICE).strength(0.5f, 0.5f).nonOpaque().slipperiness(0.98f).sounds(BlockSoundGroup.GLASS)), ItemGroup.BUILDING_BLOCKS);
    public static final Block PACKED_ICE_SLAB = registerBlock("packed_ice_slab",
            new SlabBlock(FabricBlockSettings.of(Material.DENSE_ICE).strength(0.5f, 0.5f).nonOpaque().slipperiness(0.98f).sounds(BlockSoundGroup.GLASS)), ItemGroup.BUILDING_BLOCKS);
    public static final Block BOOKSHELF_STAIRS = registerBlock("bookshelf_stairs",
            new ModStairBlock(Blocks.BOOKSHELF.getDefaultState(), FabricBlockSettings.of(Material.WOOD).strength(1.5f, 1.5f).sounds(BlockSoundGroup.WOOD)), ItemGroup.BUILDING_BLOCKS);
    public static final Block BOOKSHELF_SLAB = registerBlock("bookshelf_slab",
            new SlabBlock(FabricBlockSettings.of(Material.WOOD).strength(1.5f, 1.5f).sounds(BlockSoundGroup.WOOD)), ItemGroup.BUILDING_BLOCKS);

    // Decoration
    public static final Block COTTON_CROP = registerBlockWithoutBlockItem("cotton_crop",
            new ModCottonBlock(FabricBlockSettings.copy(Blocks.BEETROOTS)));
    public static final Block SHIVER_LEAF = registerBlock("shiver_leaf",
            new ShiverLeafFlowerBlock(StatusEffects.GLOWING, 8, FabricBlockSettings.copy(Blocks.PINK_TULIP).ticksRandomly().luminance((state) -> 5)), ItemGroup.DECORATIONS);
    public static final Block SHIVER_LEAF_DEAD = registerBlockWithoutBlockItem("shiver_leaf_dead",
            new FlowerBlock(StatusEffects.GLOWING, 8, FabricBlockSettings.copy(Blocks.PINK_TULIP)));
    public static final Block POTTED_SHIVER_LEAF = registerBlockWithoutBlockItem("potted_shiver_leaf",
            new PottedShiverLeafFlowerBlock(ModBlocks.SHIVER_LEAF, FabricBlockSettings.copy(Blocks.POTTED_ALLIUM).luminance((state) -> 4)));

    // Redstone
    public static final Block COPPER_BUTTON = registerBlock("copper_button",
            new ModStoneButtonBlock(FabricBlockSettings.of(Material.METAL).strength(0.5f, 0.5f).sounds(BlockSoundGroup.METAL)), ItemGroup.REDSTONE);
    public static final Block COPPER_PRESSURE_PLATE = registerBlock("copper_pressure_plate",
            new ModPressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING, FabricBlockSettings.of(Material.METAL).strength(0.5f, 0.5f).sounds(BlockSoundGroup.METAL)), ItemGroup.REDSTONE);
    public static final Block GLASS_OAK_DOOR = registerBlock("glass_oak_door",
            new ModDoorBlock(FabricBlockSettings.of(Material.WOOD).strength(3.0f, 3.0f).nonOpaque().sounds(BlockSoundGroup.WOOD)), ItemGroup.REDSTONE);
    public static final Block GLASS_SPRUCE_DOOR = registerBlock("glass_spruce_door",
            new ModDoorBlock(FabricBlockSettings.of(Material.WOOD).strength(3.0f, 3.0f).nonOpaque().sounds(BlockSoundGroup.WOOD)), ItemGroup.REDSTONE);
    public static final Block GLASS_DARK_OAK_DOOR = registerBlock("glass_dark_oak_door",
            new ModDoorBlock(FabricBlockSettings.of(Material.WOOD).strength(3.0f, 3.0f).nonOpaque().sounds(BlockSoundGroup.WOOD)), ItemGroup.REDSTONE);
    public static final Block GLASS_DOOR = registerBlock("glass_door",
            new ModDoorBlock(FabricBlockSettings.of(Material.GLASS).strength(0.3f).nonOpaque().sounds(BlockSoundGroup.GLASS)), ItemGroup.REDSTONE);

    // Registering Stuff
    private static Block registerBlockWithoutBlockItem(String name, Block block) {
        return Registry.register(Registry.BLOCK, new Identifier(MinecraftOverhaul.MOD_ID, name), block);
    }

    private static Block registerBlock(String name, Block block, ItemGroup group) {
        registerBlockItem(name, block, group);
        return Registry.register(Registry.BLOCK, new Identifier(MinecraftOverhaul.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block, ItemGroup group) {
        return Registry.register(Registry.ITEM, new Identifier(MinecraftOverhaul.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings().group(group)));
    }

    public static void registerModBlocks() {
        System.out.println("Registering Mod Blocks for " + MinecraftOverhaul.MOD_ID);
    }
}
