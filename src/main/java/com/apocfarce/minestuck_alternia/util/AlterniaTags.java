package com.apocfarce.minestuck_alternia.util;

import com.apocfarce.minestuck_alternia.Minestuck_alternia;
import net.minecraft.block.Block;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.Tag;
import net.minecraft.util.ResourceLocation;

public class AlterniaTags {
	public static class Blocks {
		
		public static final Tag<Block> PYRAL_LOGS = tag("logs/pyral");
		public static final Tag<Block> MIRRAGE_LOGS = tag("logs/mirrage");
		public static final Tag<Block> LEAVES = tag("leaves");
		public static final Tag<Block> FENCES = tag("fences");
		
		private static Tag<Block> tag(String name) {
			return new BlockTags.Wrapper(new ResourceLocation(Minestuck_alternia.MOD_ID, name));
		}
	}
}