package com.apocfarce.minestuck_alternia.block;

import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

import java.util.ArrayList;

public abstract class Portal extends HorizontalBlock{
	

	public abstract BlockPos getMainCorner(IWorld worldIn, BlockPos pos,Direction facing);
	protected abstract MutableBoundingBox getBaseBox(IWorld worldIn, BlockPos pos);
	public abstract void destroyPart(World worldIn, BlockPos mainCorner, Direction facing, boolean isCreative);

	
	
	
	public Portal(Properties properties) {
		super(properties);
	}
	


	public Direction getOrientation(IWorld worldIn, BlockPos pos){
		if( worldIn.getBlockState(pos).getBlock() instanceof Portal) {
			return getOrientation(worldIn, ((Portal)worldIn.getBlockState(pos).getBlock()).getBaseBox(worldIn, pos));
		}
		return Direction.DOWN;

	}
	
	@Override
	public boolean removedByPlayer(BlockState state, World world, BlockPos pos, PlayerEntity player, boolean willHarvest, FluidState fluid) {
		Direction facing = getOrientation(world, pos);
		if(facing == null) {
			facing = player.getHorizontalFacing();			
		}
		BlockPos mainCorner = getMainCorner(world, pos, facing);
		destroyPart(world, mainCorner, facing,player.isCreative());
        ItemStack minedItem = player.getHeldItemMainhand();

//       if (!world.isRemote && !player.isCreative()) {
//       	spawnDrops(state, world, pos, (TileEntity)null, player, minedItem);
//        }
		return super.removedByPlayer(state, world, pos, player, willHarvest, fluid);
		
	}
	/**
	 * returns the orientation of the portal
	 * returns null if there are no components connected to the base
	 * @param worldIn
	 * @param baseBox
	 * @return
	 */
	public Direction getOrientation(IWorld worldIn, MutableBoundingBox baseBox){
		if(worldIn.getBlockState(new BlockPos(baseBox.minX+2,baseBox.minY+1,baseBox.minZ)).hasProperty(GreenSnake.PART)
			||worldIn.getBlockState(new BlockPos(baseBox.minX+2,baseBox.minY+1,baseBox.maxZ)).hasProperty(RedSnake.PART)) {
			return Direction.EAST;
		}
		if(worldIn.getBlockState(new BlockPos(baseBox.maxX-2,baseBox.minY+1,baseBox.maxZ)).hasProperty(GreenSnake.PART)
				||worldIn.getBlockState(new BlockPos(baseBox.maxX-2,baseBox.minY+1,baseBox.minZ)).hasProperty(RedSnake.PART)) {
				return Direction.WEST;
		}
		if(worldIn.getBlockState(new BlockPos(baseBox.maxX,baseBox.minY+1,baseBox.minZ+2)).hasProperty(GreenSnake.PART)
				||worldIn.getBlockState(new BlockPos(baseBox.minX,baseBox.minY+1,baseBox.minZ+2)).hasProperty(RedSnake.PART)) {
				return Direction.SOUTH;
		}
		if(worldIn.getBlockState(new BlockPos(baseBox.minX,baseBox.minY+1,baseBox.maxZ-2)).hasProperty(GreenSnake.PART)
				||worldIn.getBlockState(new BlockPos(baseBox.maxX,baseBox.minY+1,baseBox.maxZ-2)).hasProperty(RedSnake.PART)) {
				return Direction.NORTH;
		}
		return null;
	}
	/**
	 * returns the block position of the "down stage right" most corner,
	 * or the corner you would have placed the portal by
	 * will return null if the base has no other parts on it
	 * @param facing
	 * @param box
	 * @return
	 */
	protected BlockPos getMainCorner(Direction facing, MutableBoundingBox box) {
		switch(facing) {
		case NORTH:return new BlockPos(box.minX,box.minY,box.maxZ);
		case EAST:return new BlockPos(box.minX,box.minY,box.minZ);
		case SOUTH:return new BlockPos(box.maxX,box.minY,box.minZ);
		case WEST:return new BlockPos(box.maxX,box.minY,box.maxZ);
		default:return null;
		}
	}
	/**
	 * Returns a list of all the parts which the base is missing
	 * not totally varified yet
	 * @param worldIn
	 * @param pos
	 * @return
	 */
	public ArrayList<PortalPart> getMissingParts(IWorld worldIn, BlockPos pos) {
		ArrayList<PortalPart> parts = new ArrayList<PortalPart>();
		MutableBoundingBox base = getBaseBox(worldIn,pos);
		Direction facing = getOrientation(worldIn,base);
		//if no orientation has been decided yet, everything but the base is missing
		if(facing==null) {
			for(int i =0;i< PortalPart.values().length;i++) {
				parts.add(PortalPart.values()[i]);
			}
			return parts;
		}
		BlockPos mainCorner=getMainCorner(facing,base);
		
		
		if(!hasPart(PortalPart.GREEN_SNAKE,worldIn,mainCorner)) 
			parts.add(PortalPart.GREEN_SNAKE);
		if(!hasPart(PortalPart.RED_SNAKE,worldIn,mainCorner))
			parts.add(PortalPart.RED_SNAKE);
		if(!hasPart(PortalPart.CENTER,worldIn,mainCorner))
			parts.add(PortalPart.CENTER);
		if(!hasPart(PortalPart.CROWN,worldIn,mainCorner))
			parts.add(PortalPart.CROWN);
		return parts;
	}
	/**
	 * returns weather or not the portal has a specific part
	 * 
	 * @param part
	 * @param worldIn
	 * @param MainCorner
	 * @return
	 */
	public boolean hasPart(PortalPart part,IWorld worldIn,BlockPos MainCorner) {
		Direction facing = worldIn.getBlockState(MainCorner).get(HORIZONTAL_FACING).getOpposite();
		switch(part) {
			case GREEN_SNAKE:return worldIn.getBlockState(MainCorner.offset(facing,2).up()).hasProperty(GreenSnake.PART);
			case RED_SNAKE: return worldIn.getBlockState(MainCorner.offset(facing,2).up().offset(facing.rotateY(),3)).hasProperty(RedSnake.PART);
			case CENTER: return worldIn.getBlockState(MainCorner.offset(facing,2).up().offset(facing.rotateY(),1)).hasProperty(PortalCenter.IsOpen);
			case CROWN:return worldIn.getBlockState(MainCorner.offset(facing,2).up(3).offset(facing.rotateY())).getBlock() instanceof PortalCrown;
			default: return false;
		}
	}
	/**
	 * returns true only when all parts of the portal have been added to the portal
	 * 
	 * @param worldIn
	 * @param pos
	 * @return
	 */
	public boolean isComplete(IWorld worldIn, BlockPos pos) {
		if(getMissingParts(worldIn,pos).isEmpty()) {
			return true;
		}
		return false;
	}
	public void destroyPart(PortalPart part, World worldIn, BlockPos mainCorner, Direction facing, boolean isCreative) {
		if(hasPart(part, worldIn, mainCorner)) {
			Portal portalBlock;
			switch(part) {
			case GREEN_SNAKE:
				portalBlock=(Portal)worldIn.getBlockState(mainCorner.offset(facing,2).up()).getBlock();
				break;
			case RED_SNAKE:portalBlock=(Portal)worldIn.getBlockState(mainCorner.offset(facing,2).up().offset(facing.rotateY(),3)).getBlock();
				break;
			case CENTER:portalBlock=(Portal)worldIn.getBlockState(mainCorner.offset(facing,2).up().offset(facing.rotateY(),1)).getBlock();
				break;
			case CROWN:portalBlock=(Portal)worldIn.getBlockState(mainCorner.offset(facing,2).up(3).offset(facing.rotateY())).getBlock();
				break;
			case BASE: default:	portalBlock=(Portal)worldIn.getBlockState(mainCorner).getBlock();
				break;
			}
			portalBlock.destroyPart(worldIn, mainCorner, facing,isCreative);
		}
	}
	
	public enum PortalPart{
		GREEN_SNAKE,
		RED_SNAKE,
		CROWN,
		CENTER,
		BASE;
	}
}
