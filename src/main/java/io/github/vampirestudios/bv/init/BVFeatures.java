package io.github.vampirestudios.bv.init;

import io.github.vampirestudios.bv.BeyondVanilla;
import io.github.vampirestudios.bv.world.gen.feature.ShadowTreeFeatureTest;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.BranchedTreeFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.stateprovider.SimpleStateProvider;

public class BVFeatures {

    /*public static final Feature<DefaultFeatureConfig> LARGE_SHADOW_TREE = Registry.register(Registry.FEATURE,
            new Identifier(BeyondVanilla.MOD_ID, "large_shadow_tree"), new LargeShadowTreeFeature(DefaultFeatureConfig::deserialize, false));*/
    /*public static final Feature<DefaultFeatureConfig> SHADOW_TREE = Registry.register(Registry.FEATURE,
            new Identifier(BeyondVanilla.MOD_ID, "shadow_tree"), new ShadowTreeFeature(DefaultFeatureConfig::deserialize, false));*/


    public static final Feature<BranchedTreeFeatureConfig> SHADOW_TREE_TEST = Registry.register(Registry.FEATURE,
            new Identifier(BeyondVanilla.MOD_ID, "shadow_tree"), new ShadowTreeFeatureTest(BranchedTreeFeatureConfig::deserialize2));

    public static final BranchedTreeFeatureConfig SHADOW_TREE_CONFIG =
            (new BranchedTreeFeatureConfig.Builder(new SimpleStateProvider(BVBlocks.SHADOW_LOG.getDefaultState()),
                    new SimpleStateProvider(BVBlocks.SHADOW_LEAVES.getDefaultState()), new BlobFoliagePlacer(2, 0)))
                    .baseHeight(5).heightRandA(2).heightRandB(2).trunkHeight(0).noVines().build();

}
