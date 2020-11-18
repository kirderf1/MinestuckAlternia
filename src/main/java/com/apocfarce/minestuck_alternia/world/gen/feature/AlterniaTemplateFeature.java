package com.apocfarce.minestuck_alternia.world.gen.feature;

import com.mojang.datafixers.Dynamic;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.template.PlacementSettings;
import net.minecraft.world.gen.feature.template.Template;
import net.minecraft.world.gen.feature.template.TemplateManager;
import net.minecraft.world.server.ServerWorld;

import java.util.Random;
import java.util.function.Function;

public class AlterniaTemplateFeature extends Feature<NoFeatureConfig> {
	BlockPos floorPos;
	public AlterniaTemplateFeature(Function<Dynamic<?>, ? extends NoFeatureConfig> p_i49915_1_,BlockPos floor) {
		super(p_i49915_1_);
		floorPos = floor;
	}


	@Override
	public boolean place(IWorld worldIn, ChunkGenerator<? extends GenerationSettings> generator, Random rand, BlockPos pos, NoFeatureConfig config) {
		if(worldIn.getWorld() instanceof ServerWorld){
			TemplateManager manager = ((ServerWorld)worldIn.getWorld()).getSaveHandler().getStructureTemplateManager();
			//if(manager.getTemplate(getRegistryName()) == null) System.out.println("template not found: "+getRegistryName());
			Template template = manager.getTemplateDefaulted(this.getRegistryName());
			PlacementSettings placementSettings = new PlacementSettings();
			template.addBlocksToWorld(worldIn, pos.subtract(floorPos), placementSettings);
			//worldIn.setBlockState(pos, Blocks.GOLD_BLOCK.getDefaultState(),0);
			return true;
		}
		return false;
	}
	

	
}