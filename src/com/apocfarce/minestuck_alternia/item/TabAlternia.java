package com.apocfarce.minestuck_alternia.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class TabAlternia extends CreativeTabs
{
	public static final TabAlternia instance = new TabAlternia("tabAlternia");
	
	private TabAlternia(String label)
	{
		super(label);
	}
	
	@Override
	public ItemStack getTabIconItem()
	{
		return new ItemStack(AlterniaItems.item);
	}
}