package com.apocfarce.minestuck_alternia.data;

import com.apocfarce.minestuck_alternia.Item.AlterniaItems;
import com.apocfarce.minestuck_alternia.block.AlterniaBlocks;
import net.minecraft.data.*;
import net.minecraft.item.Items;

import java.util.function.Consumer;

public class AlterniaRecipeProvider extends RecipeProvider {
	public AlterniaRecipeProvider(DataGenerator generatorIn) {
		super(generatorIn);
	}
	
	@Override
	protected void registerRecipes(Consumer<IFinishedRecipe> consumer) {
		ShapedRecipeBuilder.shapedRecipe(AlterniaItems.cherubKey).key('E', Items.EMERALD).key('R', Items.RED_DYE).key('G', Items.LIME_DYE).patternLine("  E").patternLine("ER ").patternLine("GE ").setGroup("cherub_key").addCriterion("has_emerald", hasItem(Items.EMERALD)).build(consumer);
		ShapedRecipeBuilder.shapedRecipe(AlterniaItems.cherubKey).key('E', Items.EMERALD).key('R', Items.RED_DYE).key('G', Items.LIME_DYE).patternLine("  E").patternLine("EG ").patternLine("RE ").setGroup("cherub_key").addCriterion("has_emerald", hasItem(Items.EMERALD)).build(consumer, AlterniaItems.cherubKey.getRegistryName().toString()+"_inverted");
		
		ShapedRecipeBuilder.shapedRecipe(AlterniaBlocks.portalCenter).key('I', Items.IRON_BLOCK).key('D', Items.DIAMOND).key('O', Items.OBSIDIAN).patternLine("DID").patternLine("IOI").patternLine("DID").addCriterion("has_key", hasItem(AlterniaItems.cherubKey)).build(consumer);
		ShapedRecipeBuilder.shapedRecipe(AlterniaBlocks.portalBase).key('I', Items.IRON_BLOCK).patternLine("III").patternLine("III").addCriterion("has_key", hasItem(AlterniaItems.cherubKey)).build(consumer);
		ShapedRecipeBuilder.shapedRecipe(AlterniaBlocks.portalCrown).key('I', Items.IRON_BLOCK).key('D', Items.DIAMOND).key('O', Items.OBSIDIAN).patternLine("IOI").patternLine("DID").addCriterion("has_key", hasItem(AlterniaItems.cherubKey)).build(consumer);
		ShapedRecipeBuilder.shapedRecipe(AlterniaBlocks.redSnake).key('I', Items.IRON_BLOCK).key('E', Items.EMERALD_BLOCK).key('R', Items.RED_DYE).patternLine(" RE").patternLine(" I ").patternLine("II ").addCriterion("has_key", hasItem(AlterniaItems.cherubKey)).build(consumer);
		ShapedRecipeBuilder.shapedRecipe(AlterniaBlocks.greenSnake).key('I', Items.IRON_BLOCK).key('E', Items.EMERALD_BLOCK).key('G', Items.LIME_DYE).patternLine(" GE").patternLine(" I ").patternLine("II ").addCriterion("has_key", hasItem(AlterniaItems.cherubKey)).build(consumer);
		
		ShapedRecipeBuilder.shapedRecipe(AlterniaBlocks.pyralWood, 3).key('#', AlterniaBlocks.pyralLog).patternLine("##").patternLine("##").setGroup("bark").addCriterion("has_log", hasItem(AlterniaBlocks.pyralLog)).build(consumer);
		ShapelessRecipeBuilder.shapelessRecipe(AlterniaBlocks.pyralPlanks, 4).addIngredient(AlterniaBlocks.pyralLog).setGroup("planks").addCriterion("has_log", hasItem(AlterniaBlocks.pyralLog)).build(consumer);
		ShapedRecipeBuilder.shapedRecipe(AlterniaBlocks.pyralStairs, 4).key('#', AlterniaBlocks.pyralPlanks).patternLine("#  ").patternLine("## ").patternLine("###").setGroup("wooden_stairs").addCriterion("has_planks", hasItem(AlterniaBlocks.pyralPlanks)).build(consumer);
		ShapedRecipeBuilder.shapedRecipe(AlterniaBlocks.pyralSlab, 6).key('#', AlterniaBlocks.pyralPlanks).patternLine("###").setGroup("wooden_slab").addCriterion("has_planks", hasItem(AlterniaBlocks.pyralPlanks)).build(consumer);
		ShapedRecipeBuilder.shapedRecipe(AlterniaBlocks.pyralFence, 3).key('W', AlterniaBlocks.pyralPlanks).key('#', Items.STICK).patternLine("W#W").patternLine("W#W").setGroup("wooden_fence").addCriterion("has_planks", hasItem(AlterniaBlocks.pyralPlanks)).build(consumer);
		ShapedRecipeBuilder.shapedRecipe(AlterniaBlocks.pyralFenceGate).key('W', AlterniaBlocks.pyralPlanks).key('#', Items.STICK).patternLine("#W#").patternLine("#W#").setGroup("wooden_fence_gate").addCriterion("has_planks", hasItem(AlterniaBlocks.pyralPlanks)).build(consumer);
		
		ShapedRecipeBuilder.shapedRecipe(AlterniaBlocks.mirrageWood, 3).key('#', AlterniaBlocks.mirrageLog).patternLine("##").patternLine("##").setGroup("bark").addCriterion("has_log", hasItem(AlterniaBlocks.mirrageLog)).build(consumer);
		ShapelessRecipeBuilder.shapelessRecipe(AlterniaBlocks.mirragePlanks, 4).addIngredient(AlterniaBlocks.mirrageLog).setGroup("planks").addCriterion("has_log", hasItem(AlterniaBlocks.mirrageLog)).build(consumer);
		ShapedRecipeBuilder.shapedRecipe(AlterniaBlocks.mirrageStairs, 4).key('#', AlterniaBlocks.mirragePlanks).patternLine("#  ").patternLine("## ").patternLine("###").setGroup("wooden_stairs").addCriterion("has_planks", hasItem(AlterniaBlocks.mirragePlanks)).build(consumer);
		ShapedRecipeBuilder.shapedRecipe(AlterniaBlocks.mirrageSlab, 6).key('#', AlterniaBlocks.mirragePlanks).patternLine("###").setGroup("wooden_slab").addCriterion("has_planks", hasItem(AlterniaBlocks.mirragePlanks)).build(consumer);
		ShapedRecipeBuilder.shapedRecipe(AlterniaBlocks.mirrageFence, 3).key('W', AlterniaBlocks.mirragePlanks).key('#', Items.STICK).patternLine("W#W").patternLine("W#W").setGroup("wooden_fence").addCriterion("has_planks", hasItem(AlterniaBlocks.mirragePlanks)).build(consumer);
		ShapedRecipeBuilder.shapedRecipe(AlterniaBlocks.mirrageFenceGate).key('W', AlterniaBlocks.mirragePlanks).key('#', Items.STICK).patternLine("#W#").patternLine("#W#").setGroup("wooden_fence_gate").addCriterion("has_planks", hasItem(AlterniaBlocks.mirragePlanks)).build(consumer);
		
		ShapedRecipeBuilder.shapedRecipe(AlterniaItems.oblongMeatProduct).key('B', Items.BREAD).key('G', Items.PORKCHOP).patternLine("BBB").patternLine("GGG").patternLine("BBB").addCriterion("has_bread", hasItem(Items.BREAD)).build(consumer);
	}
	
	@Override
	public String getName() {
		return "Alternia Recipe provider";
	}
}
