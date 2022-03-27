package net.prelaw.mc.util;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tag.Tag;
import net.minecraft.util.Identifier;
import net.prelaw.mc.MinecraftOverhaul;

public class ModTags {
    public static class Blocks {

        // Registering Tags
        public static final Tag.Identified<Block> SILVER_BLOCKS = createCommonTag("silver_blocks");
        public static final Tag.Identified<Block> SILVER_ORES = createCommonTag("silver_ores");

        // Registry Method
        private static Tag.Identified<Block> createTag(String name) {
            return TagFactory.BLOCK.create(new Identifier(MinecraftOverhaul.MOD_ID, name));
        }
        // Registry Method
        private static Tag.Identified<Block> createCommonTag(String name) {
            return TagFactory.BLOCK.create(new Identifier("c", name));
        }
    }

    public static class Items {

        // Registering Tags
        public static final Tag.Identified<Item> SILVER_INGOTS = createCommonTag("silver_ingots");
        public static final Tag.Identified<Item> SILVER_NUGGETS = createCommonTag("silver_nuggets");
        public static final Tag.Identified<Item> CORAL_SET = createTag("coral_set");

        // Registry Method
        private static Tag.Identified<Item> createTag(String name) {
            return TagFactory.ITEM.create(new Identifier(MinecraftOverhaul.MOD_ID, name));
        }
        // Registry Method
        private static Tag.Identified<Item> createCommonTag(String name) {
            return TagFactory.ITEM.create(new Identifier("c", name));
        }
    }
}
