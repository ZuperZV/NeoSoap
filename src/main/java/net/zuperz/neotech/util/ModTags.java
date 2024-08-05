package net.zuperz.neotech.util;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.zuperz.neotech.NeoTech;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> INCORRECT_FOR_ELECTRIKE_TOOL = createTag("incorrect_for_electrike_tool");
        public static final TagKey<Block> NEEDS_ELECTRIKE_TOOL = createTag("needs_electrike_tool");

        private static TagKey<Block> createTag(String name) {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(NeoTech.MOD_ID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> HAMMER_ITEM = createTag("hammer_item");

        private static TagKey<Item> createTag(String name) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(NeoTech.MOD_ID, name));
        }
    }
}