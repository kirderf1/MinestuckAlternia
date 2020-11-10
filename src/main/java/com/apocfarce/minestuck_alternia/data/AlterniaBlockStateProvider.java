package com.apocfarce.minestuck_alternia.data;

import com.apocfarce.minestuck_alternia.Minestuck_alternia;
import com.apocfarce.minestuck_alternia.block.AlterniaBlocks;
import net.minecraft.block.*;
import net.minecraft.data.DataGenerator;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ExistingFileHelper;
import net.minecraftforge.client.model.generators.ModelProvider;

@SuppressWarnings("ConstantConditions")
public class AlterniaBlockStateProvider extends BlockStateProvider {
	
	public AlterniaBlockStateProvider(DataGenerator gen, ExistingFileHelper exFileHelper) {
		super(gen, Minestuck_alternia.MOD_ID, exFileHelper);
	}
	
	@Override
	protected void registerStatesAndModels() {
		simpleBlock(AlterniaBlocks.darkStone);
		simpleBlockItem(AlterniaBlocks.darkStone);
		simpleBlock(AlterniaBlocks.darkCobble);
		simpleBlockItem(AlterniaBlocks.darkCobble);
		simpleBlock(AlterniaBlocks.redRock);
		simpleBlockItem(AlterniaBlocks.redRock);
		simpleBlock(AlterniaBlocks.redCobble);
		simpleBlockItem(AlterniaBlocks.redCobble);
		
		cross(AlterniaBlocks.pyralSapling);
		simpleFlatBlockItem(AlterniaBlocks.pyralSapling);
		leaves(AlterniaBlocks.pyralLeaves);
		simpleBlockItem(AlterniaBlocks.pyralLeaves);
		logBlock(AlterniaBlocks.pyralLog);
		simpleBlockItem(AlterniaBlocks.pyralLog);
		strippedLogBlock(AlterniaBlocks.strippedPyralLog, AlterniaBlocks.pyralLog);
		simpleBlockItem(AlterniaBlocks.strippedPyralLog);
		simpleBlock(AlterniaBlocks.pyralWood, blockTexture(AlterniaBlocks.pyralLog));
		simpleBlockItem(AlterniaBlocks.pyralWood);
		simpleBlock(AlterniaBlocks.strippedPyralWood, blockTexture(AlterniaBlocks.strippedPyralLog));
		simpleBlockItem(AlterniaBlocks.strippedPyralWood);
		simpleBlock(AlterniaBlocks.pyralPlanks);
		simpleBlockItem(AlterniaBlocks.pyralPlanks);
		stairsBlock(AlterniaBlocks.pyralStairs, blockTexture(AlterniaBlocks.pyralPlanks));
		simpleBlockItem(AlterniaBlocks.pyralStairs);
		slabBlock(AlterniaBlocks.pyralSlab, blockTexture(AlterniaBlocks.pyralPlanks), blockTexture(AlterniaBlocks.pyralPlanks));
		simpleBlockItem(AlterniaBlocks.pyralSlab);
		fenceBlock(AlterniaBlocks.pyralFence, blockTexture(AlterniaBlocks.pyralPlanks));
		inventoryFenceItem(AlterniaBlocks.pyralFence, blockTexture(AlterniaBlocks.pyralPlanks));
		fenceGateBlock(AlterniaBlocks.pyralFenceGate, blockTexture(AlterniaBlocks.pyralPlanks));
		simpleBlockItem(AlterniaBlocks.pyralFenceGate);
		
		cross(AlterniaBlocks.mirrageSapling);
		simpleFlatBlockItem(AlterniaBlocks.mirrageSapling);
		leaves(AlterniaBlocks.mirrageLeaves, blockTexture(Blocks.ACACIA_LEAVES));
		simpleBlockItem(AlterniaBlocks.mirrageLeaves);
		logBlock(AlterniaBlocks.mirrageLog);
		simpleBlockItem(AlterniaBlocks.mirrageLog);
		strippedLogBlock(AlterniaBlocks.strippedmirrageLog, AlterniaBlocks.mirrageLog);
		simpleBlockItem(AlterniaBlocks.strippedmirrageLog);
		simpleBlock(AlterniaBlocks.mirrageWood, blockTexture(AlterniaBlocks.mirrageLog));
		simpleBlockItem(AlterniaBlocks.mirrageWood);
		simpleBlock(AlterniaBlocks.strippedmirrageWood, blockTexture(AlterniaBlocks.strippedmirrageLog));
		simpleBlockItem(AlterniaBlocks.strippedmirrageWood);
		simpleBlock(AlterniaBlocks.mirragePlanks);
		simpleBlockItem(AlterniaBlocks.mirragePlanks);
		stairsBlock(AlterniaBlocks.mirrageStairs, blockTexture(AlterniaBlocks.mirragePlanks));
		simpleBlockItem(AlterniaBlocks.mirrageStairs);
		slabBlock(AlterniaBlocks.mirrageSlab, blockTexture(AlterniaBlocks.mirragePlanks), blockTexture(AlterniaBlocks.mirragePlanks));
		simpleBlockItem(AlterniaBlocks.mirrageSlab);
		fenceBlock(AlterniaBlocks.mirrageFence, blockTexture(AlterniaBlocks.mirragePlanks));
		inventoryFenceItem(AlterniaBlocks.mirrageFence, blockTexture(AlterniaBlocks.mirragePlanks));
		fenceGateBlock(AlterniaBlocks.mirrageFenceGate, blockTexture(AlterniaBlocks.mirragePlanks));
		simpleBlockItem(AlterniaBlocks.mirrageFenceGate);
		
		tintedCross(AlterniaBlocks.pyralGrass);
		simpleFlatBlockItem(AlterniaBlocks.pyralGrass);
		
		for(PaneBlock glass : AlterniaBlocks.hiveGlass) {
			if(glass != null) {
				paneBlock(glass);
				simpleFlatBlockItem(glass);
			}
		}
	}
	
	protected ResourceLocation extend(ResourceLocation rl, String suffix) {
		return new ResourceLocation(rl.getNamespace(), rl.getPath() + suffix);
	}
	
	protected void simpleBlock(Block block, ResourceLocation texture) {
		simpleBlock(block, models().cubeAll(block.getRegistryName().getPath(), texture));
	}
	
	protected void simpleBlockItem(Block block) {
		simpleBlockItem(block, blockTexture(block));
	}
	
	protected void simpleBlockItem(Block block, ResourceLocation parent) {
		simpleBlockItem(block, models().getExistingFile(parent));
	}
	
	protected void simpleFlatBlockItem(Block block) {
		itemModels().getBuilder(block.getRegistryName().getPath()).parent(itemModels().getExistingFile(mcLoc("item/generated")))
				.texture("layer0", blockTexture(block));
	}
	
	protected void cross(Block block) {
		simpleBlock(block, models().cross(block.getRegistryName().getPath(), blockTexture(block)));
	}
	
	protected void tintedCross(Block block) {
		simpleBlock(block, models().singleTexture(block.getRegistryName().getPath(), mcLoc(ModelProvider.BLOCK_FOLDER + "/tinted_cross"), "cross", blockTexture(block)));
	}
	
	protected void leaves(Block leaves) {
		leaves(leaves, blockTexture(leaves));
	}
	
	protected void leaves(Block leaves, ResourceLocation texture) {
		simpleBlock(leaves, models().singleTexture(leaves.getRegistryName().getPath(), mcLoc(ModelProvider.BLOCK_FOLDER + "/leaves"), "all", texture));
	}
	
	protected void strippedLogBlock(LogBlock block, LogBlock regularLog) {
		axisBlock(block, blockTexture(block), extend(blockTexture(regularLog), "_top"));
	}
	
	protected void inventoryFenceItem(FenceBlock block, ResourceLocation texture) {
		String baseName = block.getRegistryName().toString();
		simpleBlockItem(block, models().fenceInventory(baseName + "_inventory", texture));
	}
	
	protected void paneBlock(PaneBlock block) {
		paneBlock(block, blockTexture(block), blockTexture(block));
	}
}