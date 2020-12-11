package com.apocfarce.minestuck_alternia.util;

import com.apocfarce.minestuck_alternia.MinestuckAlternia;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.Tags;

public class AlterniaTags {
	public static class Blocks {
		
		public static final Tags.IOptionalNamedTag<Block> PYRAL_LOGS = tag("logs/pyral");
		public static final Tags.IOptionalNamedTag<Block> MIRRAGE_LOGS = tag("logs/mirrage");
		public static final Tags.IOptionalNamedTag<Block> PLANKS = tag("planks");
		public static final Tags.IOptionalNamedTag<Block> WOODEN_STAIRS = tag("wooden_stairs");
		public static final Tags.IOptionalNamedTag<Block> WOODEN_SLABS = tag("wooden_slabs");
		public static final Tags.IOptionalNamedTag<Block> WOODEN_FENCES = tag("wooden_fences");
		public static final Tags.IOptionalNamedTag<Block> SAPLINGS = tag("saplings");
		public static final Tags.IOptionalNamedTag<Block> LEAVES = tag("leaves");
		public static final Tags.IOptionalNamedTag<Block> ALTERNIA_STONE = tag("alternia_stone");
		
		private static Tags.IOptionalNamedTag<Block> tag(String name) {
			return BlockTags.createOptional(new ResourceLocation(MinestuckAlternia.MOD_ID, name));
		}
	}
	
	public static class Items {
		public static final Tags.IOptionalNamedTag<Item> PYRAL_LOGS = tag("logs/pyral");
		public static final Tags.IOptionalNamedTag<Item> MIRRAGE_LOGS = tag("logs/mirrage");
		public static final Tags.IOptionalNamedTag<Item> PLANKS = tag("planks");
		public static final Tags.IOptionalNamedTag<Item> WOODEN_STAIRS = tag("wooden_stairs");
		public static final Tags.IOptionalNamedTag<Item> WOODEN_SLABS = tag("wooden_slabs");
		public static final Tags.IOptionalNamedTag<Item> WOODEN_FENCES = tag("wooden_fences");
		public static final Tags.IOptionalNamedTag<Item> SAPLINGS = tag("saplings");
		public static final Tags.IOptionalNamedTag<Item> LEAVES = tag("leaves");
		
		private static Tags.IOptionalNamedTag<Item> tag(String name) {
			return ItemTags.createOptional(new ResourceLocation(MinestuckAlternia.MOD_ID, name));
		}
	}
}