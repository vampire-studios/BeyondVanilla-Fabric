package io.github.vampirestudios.bv.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Fertilizable;
import net.minecraft.block.sapling.SaplingGenerator;
import net.minecraft.entity.EntityContext;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

import java.util.Random;

public class SaplingBlock extends PlantBlock implements Fertilizable {
   private static final IntProperty STAGE;
   private static final VoxelShape SHAPE;
   private final SaplingGenerator generator;

   protected SaplingBlock(SaplingGenerator saplingGenerator_1, Block.Settings block$Settings_1) {
      super(block$Settings_1);
      this.generator = saplingGenerator_1;
      this.setDefaultState(this.stateFactory.getDefaultState().with(STAGE, 0));
   }

   public VoxelShape getOutlineShape(BlockState blockState_1, BlockView blockView_1, BlockPos blockPos_1, EntityContext entityContext_1) {
      return SHAPE;
   }

   public void scheduledTick(BlockState blockState_1, ServerWorld world_1, BlockPos blockPos_1, Random random_1) {
      super.scheduledTick(blockState_1, world_1, blockPos_1, random_1);
      if (world_1.getLightLevel(blockPos_1.up()) >= 9 && random_1.nextInt(7) == 0) {
         this.generate(world_1, blockPos_1, blockState_1, random_1);
      }

   }

   private void generate(ServerWorld iWorld_1, BlockPos blockPos_1, BlockState blockState_1, Random random_1) {
      if (blockState_1.get(STAGE) == 0) {
         iWorld_1.setBlockState(blockPos_1, blockState_1.cycle(STAGE), 4);
      } else {
         this.generator.generate(iWorld_1, iWorld_1.method_14178().getChunkGenerator(), blockPos_1, blockState_1, random_1);
      }

   }

   public boolean isFertilizable(BlockView blockView_1, BlockPos blockPos_1, BlockState blockState_1, boolean boolean_1) {
      return true;
   }

   public boolean canGrow(World world_1, Random random_1, BlockPos blockPos_1, BlockState blockState_1) {
      return (double)world_1.random.nextFloat() < 0.45D;
   }

   public void grow(ServerWorld world_1, Random random_1, BlockPos blockPos_1, BlockState blockState_1) {
      this.generate(world_1, blockPos_1, blockState_1, random_1);
   }

   protected void appendProperties(StateManager.Builder<Block, BlockState> stateFactory$Builder_1) {
      stateFactory$Builder_1.add(STAGE);
   }

   static {
      STAGE = Properties.STAGE;
      SHAPE = Block.createCuboidShape(2.0D, 0.0D, 2.0D, 14.0D, 12.0D, 14.0D);
   }
}
