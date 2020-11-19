package com.apocfarce.minestuck_alternia.util;

public enum BloodColor {
	BURGUNDY("burgundy"),
	BRONZE("bronze"),
	GOLD("gold"),
	OLIVE("olive"),
	JADE("jade"),
	TEAL("teal"),
	CERULEAN("cerulean"),
	INDIGO("indigo"),
	PURPLE("purple"),
	VIOLET("violet"),
	FUCHSIA("fuchsia"),
	MUTANT("mutant", "grey"),
	LIME("lime");
	
	private final String bloodName;
	private final String blockName;
	
	BloodColor(String bloodName) {
		this(bloodName, bloodName);
	}
	
	BloodColor(String bloodName, String blockName) {
		this.bloodName = bloodName;
		this.blockName = blockName;
	}
	
	public String getBloodName() {
		return bloodName;
	}
	
	public String getBlockName() {
		return blockName;
	}
}
