package io.github.vampirestudios.bv.world.biomes;

import io.github.vampirestudios.bv.init.BVBlocks;
import io.github.vampirestudios.bv.init.BVFeatures;
import net.minecraft.block.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.decorator.CountExtraChanceDecoratorConfig;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.TernarySurfaceConfig;

public class ShadowSwamp extends Biome {

    public ShadowSwamp() {
        super(new Settings()
                .configureSurfaceBuilder(SurfaceBuilder.DEFAULT, new TernarySurfaceConfig(BVBlocks.SHADOW_GRASS_BLOCK.getDefaultState(),
                        BVBlocks.SHADOW_DIRT.getDefaultState(), Blocks.AIR.getDefaultState()))
                .scale(1.0F)
                .temperature(0.0F)
                .waterColor(0xFFFFFF)
                .waterFogColor(0xFFFFFF)
                .downfall(0.0F)
                .category(Category.NETHER)
                .precipitation(Precipitation.NONE)
                .depth(1.0F)
        );

        this.addFeature(GenerationStep.Feature.UNDERGROUND_DECORATION, Biome.configureFeature(BVFeatures.SHADOW_TREE, FeatureConfig.DEFAULT,
                Decorator.COUNT_EXTRA_HEIGHTMAP, new CountExtraChanceDecoratorConfig(2, 0.1F, 1)));
    }

    @Override
    public int getSkyColor(float float_1) {
        return 0x171B32;
    }

}
