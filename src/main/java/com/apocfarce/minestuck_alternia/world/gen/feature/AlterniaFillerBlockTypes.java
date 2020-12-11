package com.apocfarce.minestuck_alternia.world.gen.feature;

import com.apocfarce.minestuck_alternia.util.AlterniaTags;
import net.minecraft.world.gen.feature.template.RuleTest;
import net.minecraft.world.gen.feature.template.TagMatchRuleTest;

public class AlterniaFillerBlockTypes {
	public static RuleTest alterniaStone() {
		return new TagMatchRuleTest(AlterniaTags.Blocks.ALTERNIA_STONE);
	}
}