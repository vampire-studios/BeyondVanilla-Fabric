package io.github.vampirestudios.bv.block.sapling;

import io.github.vampirestudios.bv.init.BVFeatures;
import net.minecraft.block.sapling.SaplingGenerator;
import net.minecraft.world.gen.feature.BranchedTreeFeatureConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;

import javax.annotation.Nullable;
import java.util.Random;

public class ShadowSaplingGenerator extends SaplingGenerator {
   @Nullable
   protected ConfiguredFeature<BranchedTreeFeatureConfig, ?> createTreeFeature(Random random_1) {
      return BVFeatures.SHADOW_TREE_TEST.configure(BVFeatures.SHADOW_TREE_CONFIG);
   }
}
