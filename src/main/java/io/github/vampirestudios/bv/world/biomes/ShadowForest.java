package io.github.vampirestudios.bv.world.biomes;

import io.github.vampirestudios.bv.init.BVBlocks;
import io.github.vampirestudios.bv.init.BVPlacements;
import io.github.vampirestudios.bv.world.gen.feature.ShadowTreeFeature;
import net.minecraft.block.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.decorator.CountDecoratorConfig;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.TernarySurfaceConfig;

public class ShadowForest extends Biome {

    public ShadowForest() {
        super(new Settings()
                .configureSurfaceBuilder(SurfaceBuilder.DEFAULT, new TernarySurfaceConfig(BVBlocks.SHADOW_GRASS.getDefaultState(),
                        BVBlocks.SHADOW_DIRT.getDefaultState(), Blocks.AIR.getDefaultState()))
                .scale(1.0F)
                .temperature(0.0F)
                .waterColor(0xFFFFFF)
                .waterFogColor(0xFFFFFF)
                .downfall(0.0F)
                .category(Category.PLAINS)
                .precipitation(Precipitation.NONE)
                .depth(1.0F)
        );

        this.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Biome.configureFeature(new ShadowTreeFeature(DefaultFeatureConfig::deserialize, true), FeatureConfig.DEFAULT, BVPlacements.COUNT_UNDERGROUND_32, new CountDecoratorConfig(10)));
    }

    @Override
    public int getSkyColor(float float_1) {
        return 0x171B32;
    }

}
