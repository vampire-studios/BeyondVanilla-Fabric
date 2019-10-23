package io.github.vampirestudios.bv.world.biomes;

import io.github.vampirestudios.bv.init.BVBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.TernarySurfaceConfig;

public class ShadowForest extends Biome {

    public ShadowForest() {
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

        /*this.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, net.minecraft.world.gen.feature.Feature.RANDOM_SELECTOR.method_23397(
                new RandomFeatureConfig(ImmutableList.of(BVFeatures.SHADOW_TREE_TEST.method_23397(BVFeatures.SHADOW_TREE_CONFIG).method_23387(0.2F),
                        BVFeatures.LARGE_SHADOW_TREE.method_23397(FeatureConfig.DEFAULT).method_23387(0.1F)),
                        net.minecraft.world.gen.feature.Feature.NORMAL_TREE.method_23397(DefaultBiomeFeatures.field_21191)))
                .method_23388(Decorator.COUNT_EXTRA_HEIGHTMAP.method_23475(new CountExtraChanceDecoratorConfig(10, 0.1F, 1))));*/
    }

    @Override
    public int getSkyColor(float float_1) {
        return 0x171B32;
    }

}
