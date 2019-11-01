package io.github.vampirestudios.bv.world.biomes;

import io.github.vampirestudios.bv.init.BVBlocks;
import io.github.vampirestudios.bv.init.BVFeatures;
import net.minecraft.block.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.decorator.CountExtraChanceDecoratorConfig;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.TernarySurfaceConfig;

public class ShadowPlains extends Biome {

    public ShadowPlains() {
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

        this.addFeature(GenerationStep.Feature.UNDERGROUND_DECORATION, BVFeatures.SHADOW_TREE_TEST.configure(BVFeatures.SHADOW_TREE_CONFIG)
                .createDecoratedFeature(Decorator.COUNT_EXTRA_HEIGHTMAP.configure(new CountExtraChanceDecoratorConfig(0, 0.05F, 1))));
//        this.addFeature(GenerationStep.Feature.UNDERGROUND_DECORATION, configureFeature(Feature.NETHER_SPRING, new NetherSpringFeatureConfig(false), Decorator.COUNT_RANGE, new RangeDecoratorConfig(8, 4, 8, 128)));
//        this.addFeature(GenerationStep.Feature.UNDERGROUND_DECORATION, configureFeature(Feature.HELL_FIRE, FeatureConfig.DEFAULT, Decorator.HELL_FIRE, new CountDecoratorConfig(10)));
//        this.addFeature(GenerationStep.Feature.UNDERGROUND_DECORATION, configureFeature(Feature.GLOWSTONE_BLOB, FeatureConfig.DEFAULT, Decorator.LIGHT_GEM_CHANCE, new CountDecoratorConfig(10)));
//        this.addFeature(GenerationStep.Feature.UNDERGROUND_DECORATION, configureFeature(Feature.GLOWSTONE_BLOB, FeatureConfig.DEFAULT, Decorator.COUNT_RANGE, new RangeDecoratorConfig(10, 0, 0, 128)));
//        this.addFeature(GenerationStep.Feature.UNDERGROUND_DECORATION, configureFeature(Feature.BUSH, new BushFeatureConfig(Blocks.BROWN_MUSHROOM.getDefaultState()), Decorator.CHANCE_RANGE, new ChanceRangeDecoratorConfig(0.5F, 0, 0, 128)));
//        this.addFeature(GenerationStep.Feature.UNDERGROUND_DECORATION, configureFeature(Feature.BUSH, new BushFeatureConfig(Blocks.RED_MUSHROOM.getDefaultState()), Decorator.CHANCE_RANGE, new ChanceRangeDecoratorConfig(0.5F, 0, 0, 128)));
    }

    @Override
    public int getSkyColor(float float_1) {
        return 0x171B32;
    }

}
