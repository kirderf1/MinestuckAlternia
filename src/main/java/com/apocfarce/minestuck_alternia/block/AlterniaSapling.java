package com.apocfarce.minestuck_alternia.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.BushBlock;
import net.minecraft.block.IGrowable;
import net.minecraft.block.trees.Tree;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import java.util.Random;

public class AlterniaSapling extends BushBlock implements IGrowable {
   public static final IntegerProperty STAGE = BlockStateProperties.STAGE_0_1;
   protected static final VoxelShape SHAPE = Block.makeCuboidShape(2.0D, 0.0D, 2.0D, 14.0D, 12.0D, 14.0D);
   private final Tree tree;

   public AlterniaSapling(Tree p_i48337_1_, Block.Properties properties) {
      super(properties);
      this.tree = p_i48337_1_;
      this.setDefaultState(this.stateContainer.getBaseState().with(STAGE, Integer.valueOf(0)));
   }

   @Override
   public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
      return SHAPE;
   }
   
   @Override
   public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random random) {
      if (!worldIn.isAreaLoaded(pos, 1)) return; // Forge: prevent loading unloaded chunks when checking neighbor's light
      if (worldIn.getLight(pos.up()) >= 9 && random.nextInt(7) == 0) {
         this.grow(worldIn, random, pos, state);
      }

   }
   
   @Override
   public void grow(ServerWorld worldIn, Random rand, BlockPos pos, BlockState state) {
      if (state.get(STAGE) == 0) {
         worldIn.setBlockState(pos, state.func_235896_a_(STAGE), 4);
      } else {
         if (!net.minecraftforge.event.ForgeEventFactory.saplingGrowTree(worldIn, rand, pos)) return;
         this.tree.attemptGrowTree(worldIn, worldIn.getChunkProvider().getChunkGenerator(), pos, state, rand);
      }

   }

   /**
    * Whether this IGrowable can grow
    */
   @Override
   public boolean canGrow(IBlockReader worldIn, BlockPos pos, BlockState state, boolean isClient) {
      return true;
   }
   
   @Override
   public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, BlockState state) {
      return (double)worldIn.rand.nextFloat() < 0.45D;
   }
   
   @Override
   protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
      builder.add(STAGE);
   }
}