package main.java.com.apocfarce.minestuck_alternia.block;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class DarkStone extends Block {
	public DarkStone(Block.Properties properties) {
		super(properties);
		/*
		setCreativeTab(TabAlternia.instance);
		-setUnlocalizedName("dark_stone");
		-setRegistryName("dark_stone");
		-setSoundType(SoundType.GROUND);
		-setHardness(1.5F);
		-setResistance(10.0F);
		setHarvestLevel("pickaxe", 0);*/
	}
	@Override
	public IItemProvider getItemDropped(IBlockState state,World worldIn, BlockPos pos,int fortune){
		return AlterniaBlocks.darkCobble.getItemDropped(state,worldIn,pos, fortune);
	}
}
