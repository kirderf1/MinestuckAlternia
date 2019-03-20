package main.java.com.apocfarce.minestuck_alternia.block;


import main.java.com.apocfarce.minestuck_alternia.Item.ENUM_BLOOD_COLOR;
import net.minecraft.block.Block;
import net.minecraft.block.BlockPane;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;

public class HiveGlass  extends BlockPane {
	
	public ENUM_BLOOD_COLOR color;
	
	public HiveGlass(Block.Properties properties,ENUM_BLOOD_COLOR bloodColor) {
		super(properties);
		color=bloodColor;
	}
	public ENUM_BLOOD_COLOR GetBloodColor() {
		return color;
	}
	@Override
	public int getOpacity(IBlockState state, IBlockReader worldIn, BlockPos pos) {
		return(Blocks.GLASS_PANE.getDefaultState().getOpacity(worldIn, pos));
	}
	  public BlockRenderLayer getRenderLayer() {
	      return BlockRenderLayer.TRANSLUCENT;
	   }
	
	
}
