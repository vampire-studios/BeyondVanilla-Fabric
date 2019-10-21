package io.github.vampirestudios.bv.world.biomes;

import io.github.vampirestudios.bv.init.BVBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.TernarySurfaceConfig;

public class AbyssalPlains extends Biome {

    public AbyssalPlains() {
        super(new Settings()
                .configureSurfaceBuilder(SurfaceBuilder.DEFAULT, new TernarySurfaceConfig(BVBlocks.SHADOW_GRASS_BLOCK.getDefaultState(),
                        BVBlocks.SHADOW_DIRT.getDefaultState(), Blocks.WATER.getDefaultState()))
                .scale(1.0F)
                .temperature(0.0F)
                .waterColor(4159204)
                .waterFogColor(329011)
                .downfall(0.0F)
                .category(Category.PLAINS)
                .precipitation(Precipitation.NONE)
                .depth(1.0F)
        );

//        this.addFeature(GenerationStep.Feature.UNDERGROUND_DECORATION, Biome.configureFeature(new ShadowTreeFeature(DefaultFeatureConfig::deserialize, true), FeatureConfig.DEFAULT, Decorator.COUNT_EXTRA_HEIGHTMAP, new CountExtraChanceDecoratorConfig(10, 0.1F, 1)));
    }

    @Override
    public int getSkyColor(float float_1) {
        return 0x171B32;
    }

}
