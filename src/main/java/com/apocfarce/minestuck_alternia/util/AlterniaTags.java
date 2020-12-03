package com.apocfarce.minestuck_alternia.util;

import com.apocfarce.minestuck_alternia.MinestuckAlternia;
import net.minecraft.block.Block;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.Tags;

public class AlterniaTags {
	public static class Blocks {
		
		public static final Tags.IOptionalNamedTag<Block> PYRAL_LOGS = tag("logs/pyral");
		public static final Tags.IOptionalNamedTag<Block> MIRRAGE_LOGS = tag("logs/mirrage");
		public static final Tags.IOptionalNamedTag<Block> LEAVES = tag("leaves");
		public static final Tags.IOptionalNamedTag<Block> FENCES = tag("fences");
		
		private static Tags.IOptionalNamedTag<Block> tag(String name) {
			return BlockTags.createOptional(new ResourceLocation(MinestuckAlternia.MOD_ID, name));
		}
	}
}