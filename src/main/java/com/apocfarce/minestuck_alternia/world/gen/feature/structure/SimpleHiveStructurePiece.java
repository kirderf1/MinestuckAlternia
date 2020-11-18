package com.apocfarce.minestuck_alternia.world.gen.feature.structure;

import com.apocfarce.minestuck_alternia.Item.BloodColor;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.NBTUtil;
import net.minecraft.util.Mirror;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.feature.structure.TemplateStructurePiece;
import net.minecraft.world.gen.feature.template.BlockIgnoreStructureProcessor;
import net.minecraft.world.gen.feature.template.PlacementSettings;
import net.minecraft.world.gen.feature.template.Template;
import net.minecraft.world.gen.feature.template.TemplateManager;

import javax.annotation.Nullable;
import java.util.Random;

public class SimpleHiveStructurePiece extends TemplateStructurePiece implements LiveableHive {
	
	private final ResourceLocation templateName;
	private final BloodColor color;
	private final BlockPos spawn;
	private final BlockPos floor;
	private final Rotation rotation;
	private boolean isOccupied = false;
	
	public static HiveType.PieceConstructor with(BloodColor color, BlockPos floor, BlockPos spawn) {
		return (templates, name, pos, rotation) -> new SimpleHiveStructurePiece(templates, name, color, pos, floor, spawn, rotation);
	}
	
	protected SimpleHiveStructurePiece(TemplateManager templates, ResourceLocation templateName, BloodColor color, BlockPos pos, BlockPos floor, BlockPos spawn, Rotation rotation) {
		super(PieceTypes.HIVE, 0);
		this.templateName = new ResourceLocation(templateName.getNamespace(), "hives/" + templateName.getPath());
		this.color = color;
		this.templatePosition = pos;
		this.spawn = templatePosition.add(spawn.subtract(floor).rotate(rotation));
		this.floor = floor;
		this.rotation = rotation;
		setupTemplate(templates);
	}
	
	public SimpleHiveStructurePiece(TemplateManager templates, CompoundNBT nbt) {
		super(PieceTypes.HIVE, nbt);
		templateName = new ResourceLocation(nbt.getString("template"));
		color = BloodColor.valueOf(nbt.getString("color"));
		spawn = NBTUtil.readBlockPos(nbt.getCompound("spawn"));
		floor = NBTUtil.readBlockPos(nbt.getCompound("floor"));
		rotation = Rotation.valueOf(nbt.getString("rot"));
		isOccupied = nbt.getBoolean("occupied");
		setupTemplate(templates);
	}
	
	@Override
	protected void readAdditional(CompoundNBT nbt) {
		super.readAdditional(nbt);
		nbt.putString("template", templateName.toString());
		nbt.putString("color", color.name());
		nbt.put("spawn", NBTUtil.writeBlockPos(spawn));
		nbt.put("floor", NBTUtil.writeBlockPos(floor));
		nbt.putString("rot", rotation.name());
	}
	
	private void setupTemplate(TemplateManager templates) {
		Template t = templates.getTemplateDefaulted(templateName);
		PlacementSettings settings = new PlacementSettings().setRotation(rotation).setMirror(Mirror.NONE).setCenterOffset(floor).addProcessor(BlockIgnoreStructureProcessor.STRUCTURE_BLOCK);
		setup(t, templatePosition, settings);
	}
	
	@Override
	protected void handleDataMarker(String function, BlockPos pos, IWorld worldIn, Random rand, MutableBoundingBox sbb) {
	
	}
	
	@Nullable
	@Override
	public BlockPos tryOccupy(BloodColor color) {
		if(!isOccupied && color == this.color) {
			isOccupied = true;
			return spawn;
		}
		return null;
	}
}