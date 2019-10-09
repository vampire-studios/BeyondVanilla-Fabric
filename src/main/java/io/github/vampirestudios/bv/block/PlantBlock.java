package io.github.vampirestudios.bv.block;

import io.github.vampirestudios.bv.init.BVBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.class_4538;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;
import net.minecraft.world.IWorld;

public class PlantBlock extends Block {
   PlantBlock(Block.Settings block$Settings_1) {
      super(block$Settings_1);
   }

   private boolean canPlantOnTop(BlockState blockState_1, BlockView blockView_1, BlockPos blockPos_1) {
      Block block_1 = blockState_1.getBlock();
      return block_1 == Blocks.GRASS_BLOCK || block_1 == Blocks.DIRT || block_1 == Blocks.COARSE_DIRT || block_1 == Blocks.SAND ||
              block_1 == Blocks.PODZOL || block_1 == Blocks.FARMLAND || block_1 == BVBlocks.SHADOW_GRASS || block_1 == BVBlocks.SHADOW_DIRT;
   }

   public BlockState getStateForNeighborUpdate(BlockState blockState_1, Direction direction_1, BlockState blockState_2, IWorld iWorld_1, BlockPos blockPos_1, BlockPos blockPos_2) {
      return !blockState_1.canPlaceAt(iWorld_1, blockPos_1) ? Blocks.AIR.getDefaultState() : super.getStateForNeighborUpdate(blockState_1, direction_1, blockState_2, iWorld_1, blockPos_1, blockPos_2);
   }

   public boolean canPlaceAt(BlockState blockState_1, class_4538 viewableWorld_1, BlockPos blockPos_1) {
      BlockPos blockPos_2 = blockPos_1.method_10074();
      return this.canPlantOnTop(viewableWorld_1.getBlockState(blockPos_2), viewableWorld_1, blockPos_2);
   }

   public boolean isTranslucent(BlockState blockState_1, BlockView blockView_1, BlockPos blockPos_1) {
      return true;
   }
}
