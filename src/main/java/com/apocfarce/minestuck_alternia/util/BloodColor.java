package com.apocfarce.minestuck_alternia.util;

import net.minecraft.network.PacketBuffer;
import net.minecraft.util.math.MathHelper;

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
	
	public String getTranslationKey() {
		return "blood." + getBloodName();
	}
	
	public static BloodColor fromBuffer(PacketBuffer buffer) {
		int index = buffer.readInt();
		return values()[MathHelper.clamp(index, 0, values().length)];
	}
	
	public void toBuffer(PacketBuffer buffer) {
		buffer.writeInt(ordinal());
	}
}
