package net.prelaw.mc.util;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tag.Tag;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.prelaw.mc.MinecraftOverhaul;

public class ModTags {
    public static class Blocks {

        // Registering Tags
        public static final TagKey<Block> SILVER_BLOCKS = createCommonTag("silver_blocks");
        public static final TagKey<Block> SILVER_ORES = createCommonTag("silver_ores");

        // Registry Method
        private static TagKey<Block> createTag(String name) {
            return TagKey.of(Registry.BLOCK_KEY, new Identifier(MinecraftOverhaul.MOD_ID, name));
        }
        // Registry Method
        private static TagKey<Block> createCommonTag(String name) {
            return TagKey.of(Registry.BLOCK_KEY, new Identifier("c", name));
        }
    }

    public static class Items {

        // Registering Tags
        public static final TagKey<Item> SILVER_INGOTS = createCommonTag("silver_ingots");
        public static final TagKey<Item> SILVER_NUGGETS = createCommonTag("silver_nuggets");
        public static final TagKey<Item> CORAL_SET = createTag("coral_set");

        // Registry Method
        private static TagKey<Item> createTag(String name) {
            return TagKey.of(Registry.ITEM_KEY, new Identifier(MinecraftOverhaul.MOD_ID, name));
        }
        // Registry Method
        private static TagKey<Item> createCommonTag(String name) {
            return TagKey.of(Registry.ITEM_KEY, new Identifier("c", name));
        }
    }
}
