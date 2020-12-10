package com.apocfarce.minestuck_alternia.block;

import net.minecraft.block.OreBlock;
import net.minecraft.util.math.MathHelper;

import java.util.Random;

public class CustomOreBlock extends OreBlock {
	private final int minExp, maxExp;
	
	public CustomOreBlock(int minExp, int maxExp, Properties properties) {
		super(properties);
		this.minExp = minExp;
		this.maxExp = maxExp;
	}
	
	@Override
	protected int getExperience(Random rand) {
		return MathHelper.nextInt(rand, minExp, maxExp);
	}
}