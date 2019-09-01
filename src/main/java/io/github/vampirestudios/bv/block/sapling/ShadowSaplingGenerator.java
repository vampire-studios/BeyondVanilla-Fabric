package io.github.vampirestudios.bv.block.sapling;

import io.github.vampirestudios.bv.world.gen.feature.ShadowTreeFeature;
import net.minecraft.block.sapling.SaplingGenerator;
import net.minecraft.world.gen.feature.AbstractTreeFeature;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;

import javax.annotation.Nullable;
import java.util.Random;

public class ShadowSaplingGenerator extends SaplingGenerator {
   @Nullable
   protected AbstractTreeFeature<DefaultFeatureConfig> createTreeFeature(Random random_1) {
      return new ShadowTreeFeature(DefaultFeatureConfig::deserialize, true);
   }
}
