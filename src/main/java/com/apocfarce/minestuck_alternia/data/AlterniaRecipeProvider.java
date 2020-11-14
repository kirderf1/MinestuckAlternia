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
		ShapedRecipeBuilder.shapedRecipe(AlterniaItems.CHERUB_KEY).key('E', Items.EMERALD).key('R', Items.RED_DYE).key('G', Items.LIME_DYE).patternLine("  E").patternLine("ER ").patternLine("GE ").setGroup("cherub_key").addCriterion("has_emerald", hasItem(Items.EMERALD)).build(consumer);
		ShapedRecipeBuilder.shapedRecipe(AlterniaItems.CHERUB_KEY).key('E', Items.EMERALD).key('R', Items.RED_DYE).key('G', Items.LIME_DYE).patternLine("  E").patternLine("EG ").patternLine("RE ").setGroup("cherub_key").addCriterion("has_emerald", hasItem(Items.EMERALD)).build(consumer, AlterniaItems.CHERUB_KEY.getRegistryName().toString()+"_inverted");
		
		ShapedRecipeBuilder.shapedRecipe(AlterniaItems.PORTAL_CENTER).key('I', Items.IRON_BLOCK).key('D', Items.DIAMOND).key('O', Items.OBSIDIAN).patternLine("DID").patternLine("IOI").patternLine("DID").addCriterion("has_key", hasItem(AlterniaItems.CHERUB_KEY)).build(consumer);
		ShapedRecipeBuilder.shapedRecipe(AlterniaItems.PORTAL_BASE).key('I', Items.IRON_BLOCK).patternLine("III").patternLine("III").addCriterion("has_key", hasItem(AlterniaItems.CHERUB_KEY)).build(consumer);
		ShapedRecipeBuilder.shapedRecipe(AlterniaItems.PORTAL_CROWN).key('I', Items.IRON_BLOCK).key('D', Items.DIAMOND).key('O', Items.OBSIDIAN).patternLine("IOI").patternLine("DID").addCriterion("has_key", hasItem(AlterniaItems.CHERUB_KEY)).build(consumer);
		ShapedRecipeBuilder.shapedRecipe(AlterniaItems.RED_SNAKE).key('I', Items.IRON_BLOCK).key('E', Items.EMERALD_BLOCK).key('R', Items.RED_DYE).patternLine(" RE").patternLine(" I ").patternLine("II ").addCriterion("has_key", hasItem(AlterniaItems.CHERUB_KEY)).build(consumer);
		ShapedRecipeBuilder.shapedRecipe(AlterniaItems.GREEN_SNAKE).key('I', Items.IRON_BLOCK).key('E', Items.EMERALD_BLOCK).key('G', Items.LIME_DYE).patternLine(" GE").patternLine(" I ").patternLine("II ").addCriterion("has_key", hasItem(AlterniaItems.CHERUB_KEY)).build(consumer);
		
		ShapedRecipeBuilder.shapedRecipe(AlterniaBlocks.PYRAL_WOOD, 3).key('#', AlterniaBlocks.PYRAL_LOG).patternLine("##").patternLine("##").setGroup("bark").addCriterion("has_log", hasItem(AlterniaBlocks.PYRAL_LOG)).build(consumer);
		ShapelessRecipeBuilder.shapelessRecipe(AlterniaBlocks.PYRAL_PLANKS, 4).addIngredient(AlterniaBlocks.PYRAL_LOG).setGroup("planks").addCriterion("has_log", hasItem(AlterniaBlocks.PYRAL_LOG)).build(consumer);
		ShapedRecipeBuilder.shapedRecipe(AlterniaBlocks.PYRAL_STAIRS, 4).key('#', AlterniaBlocks.PYRAL_PLANKS).patternLine("#  ").patternLine("## ").patternLine("###").setGroup("wooden_stairs").addCriterion("has_planks", hasItem(AlterniaBlocks.PYRAL_PLANKS)).build(consumer);
		ShapedRecipeBuilder.shapedRecipe(AlterniaBlocks.PYRAL_SLAB, 6).key('#', AlterniaBlocks.PYRAL_PLANKS).patternLine("###").setGroup("wooden_slab").addCriterion("has_planks", hasItem(AlterniaBlocks.PYRAL_PLANKS)).build(consumer);
		ShapedRecipeBuilder.shapedRecipe(AlterniaBlocks.PYRAL_FENCE, 3).key('W', AlterniaBlocks.PYRAL_PLANKS).key('#', Items.STICK).patternLine("W#W").patternLine("W#W").setGroup("wooden_fence").addCriterion("has_planks", hasItem(AlterniaBlocks.PYRAL_PLANKS)).build(consumer);
		ShapedRecipeBuilder.shapedRecipe(AlterniaBlocks.PYRAL_FENCE_GATE).key('W', AlterniaBlocks.PYRAL_PLANKS).key('#', Items.STICK).patternLine("#W#").patternLine("#W#").setGroup("wooden_fence_gate").addCriterion("has_planks", hasItem(AlterniaBlocks.PYRAL_PLANKS)).build(consumer);
		
		ShapedRecipeBuilder.shapedRecipe(AlterniaBlocks.MIRRAGE_WOOD, 3).key('#', AlterniaBlocks.MIRRAGE_LOG).patternLine("##").patternLine("##").setGroup("bark").addCriterion("has_log", hasItem(AlterniaBlocks.MIRRAGE_LOG)).build(consumer);
		ShapelessRecipeBuilder.shapelessRecipe(AlterniaBlocks.MIRRAGE_PLANKS, 4).addIngredient(AlterniaBlocks.MIRRAGE_LOG).setGroup("planks").addCriterion("has_log", hasItem(AlterniaBlocks.MIRRAGE_LOG)).build(consumer);
		ShapedRecipeBuilder.shapedRecipe(AlterniaBlocks.MIRRAGE_STAIRS, 4).key('#', AlterniaBlocks.MIRRAGE_PLANKS).patternLine("#  ").patternLine("## ").patternLine("###").setGroup("wooden_stairs").addCriterion("has_planks", hasItem(AlterniaBlocks.MIRRAGE_PLANKS)).build(consumer);
		ShapedRecipeBuilder.shapedRecipe(AlterniaBlocks.MIRRAGE_SLAB, 6).key('#', AlterniaBlocks.MIRRAGE_PLANKS).patternLine("###").setGroup("wooden_slab").addCriterion("has_planks", hasItem(AlterniaBlocks.MIRRAGE_PLANKS)).build(consumer);
		ShapedRecipeBuilder.shapedRecipe(AlterniaBlocks.MIRRAGE_FENCE, 3).key('W', AlterniaBlocks.MIRRAGE_PLANKS).key('#', Items.STICK).patternLine("W#W").patternLine("W#W").setGroup("wooden_fence").addCriterion("has_planks", hasItem(AlterniaBlocks.MIRRAGE_PLANKS)).build(consumer);
		ShapedRecipeBuilder.shapedRecipe(AlterniaBlocks.MIRRAGE_FENCE_GATE).key('W', AlterniaBlocks.MIRRAGE_PLANKS).key('#', Items.STICK).patternLine("#W#").patternLine("#W#").setGroup("wooden_fence_gate").addCriterion("has_planks", hasItem(AlterniaBlocks.MIRRAGE_PLANKS)).build(consumer);
		
		ShapedRecipeBuilder.shapedRecipe(AlterniaItems.OBLONG_MEAT_PRODUCT).key('B', Items.BREAD).key('G', Items.PORKCHOP).patternLine("BBB").patternLine("GGG").patternLine("BBB").addCriterion("has_bread", hasItem(Items.BREAD)).build(consumer);
	}
	
	@Override
	public String getName() {
		return "Alternia Recipe provider";
	}
}
