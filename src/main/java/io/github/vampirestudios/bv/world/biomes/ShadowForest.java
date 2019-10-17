package io.github.vampirestudios.bv.world.biomes;

import io.github.vampirestudios.bv.init.BVBlocks;
import io.github.vampirestudios.bv.world.gen.feature.ShadowTreeFeature;
import net.minecraft.block.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.decorator.CountExtraChanceDecoratorConfig;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.TernarySurfaceConfig;

public class ShadowForest extends UndergroundBiome {

    public ShadowForest() {
        super(new Properties()
                .surfaceBuilder(SurfaceBuilder.DEFAULT, new TernarySurfaceConfig(BVBlocks.SHADOW_GRASS.getDefaultState(),
                        BVBlocks.SHADOW_DIRT.getDefaultState(), Blocks.AIR.getDefaultState()))
                .heightScale(1.0F)
        );

        this.add(GenerationStep.Feature.UNDERGROUND_DECORATION, Biome.configureFeature(new ShadowTreeFeature(DefaultFeatureConfig::deserialize, true), FeatureConfig.DEFAULT, Decorator.COUNT_EXTRA_HEIGHTMAP, new CountExtraChanceDecoratorConfig(10, 0.1F, 1)));
    }

    /*@Override
    public int getSkyColor(float float_1) {
        return 0x171B32;
    }*/

}
