package io.github.vampirestudios.bv.block.sapling;

import io.github.vampirestudios.bv.init.BVFeatures;
import net.minecraft.block.sapling.SaplingGenerator;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.NormalTreeFeatureConfig;

import javax.annotation.Nullable;
import java.util.Random;

public class ShadowSaplingGenerator extends SaplingGenerator {
   @Nullable
   protected ConfiguredFeature<NormalTreeFeatureConfig, ?> createTreeFeature(Random random_1) {
      return BVFeatures.SHADOW_TREE_TEST.configure(BVFeatures.SHADOW_TREE_CONFIG);
   }
}
