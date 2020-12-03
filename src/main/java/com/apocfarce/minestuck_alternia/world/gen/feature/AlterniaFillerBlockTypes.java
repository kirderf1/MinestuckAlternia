package com.apocfarce.minestuck_alternia.world.gen.feature;

import com.apocfarce.minestuck_alternia.block.AlterniaBlocks;
import net.minecraft.world.gen.feature.template.BlockMatchRuleTest;
import net.minecraft.world.gen.feature.template.RuleTest;

public class AlterniaFillerBlockTypes {
	public static RuleTest darkStone() {
		return new BlockMatchRuleTest(AlterniaBlocks.DARK_STONE);
	}
}