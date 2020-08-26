package com.apocfarce.minestuck_alternia.world.gen.feature;

import java.util.Random;
import java.util.function.Function;

import com.mojang.datafixers.Dynamic;

import net.minecraft.util.Mirror;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.template.PlacementSettings;
import net.minecraft.world.gen.feature.template.Template;
import net.minecraft.world.gen.feature.template.TemplateManager;
import net.minecraft.world.server.ServerWorld;

public class BronzeHiveFeature extends Feature<NoFeatureConfig> {
   public BronzeHiveFeature(Function<Dynamic<?>, ? extends NoFeatureConfig> p_i49915_1_) {
      super(p_i49915_1_);
   }


	@Override
	public boolean place(IWorld worldIn, ChunkGenerator<? extends GenerationSettings> generator, Random rand, BlockPos pos, NoFeatureConfig config) {
		if(worldIn.getWorld() instanceof ServerWorld){
			ChunkPos chunkpos = new ChunkPos(pos);
			TemplateManager manager = ((ServerWorld)worldIn.getWorld()).getSaveHandler().getStructureTemplateManager();
			Template template = manager.getTemplateDefaulted(new ResourceLocation("minestuck_alternia:burgundy_start1"));
			
			PlacementSettings placementSettings = new PlacementSettings();
			System.out.println(pos);
		    
			template.addBlocksToWorld(worldIn, pos, placementSettings);
			
			return true;
		}
		return false;
	}
}