package net.prelaw.mc.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.prelaw.mc.MinecraftOverhaul;



public class ModBlocks {


    public static final Block COMPRESSED_BLOCK_OF_COAL = registerBlock("compressed_block_of_coal",
            new Block(FabricBlockSettings.of(Material.STONE).strength(22.5f, 600).requiresTool()), ItemGroup.BUILDING_BLOCKS);

    public static final Block BLOCK_OF_RAW_SILVER = registerBlock("block_of_raw_silver",
            new Block(FabricBlockSettings.of(Material.STONE).strength(5f, 6).requiresTool()), ItemGroup.BUILDING_BLOCKS);

    public static final Block BLOCK_OF_SILVER = registerBlock("block_of_silver",
            new Block(FabricBlockSettings.of(Material.STONE).strength(5f, 6).requiresTool()), ItemGroup.BUILDING_BLOCKS);

    // Registering Stuff
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
