package io.github.vampirestudios.bv.init;

import io.github.vampirestudios.bv.BeyondVanilla;
import io.github.vampirestudios.bv.world.gen.feature.ShadowTreeFeatureTest;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NormalTreeFeatureConfig;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.stateprovider.SimpleStateProvider;

public class BVFeatures {

    /*public static final Feature<DefaultFeatureConfig> LARGE_SHADOW_TREE = Registry.register(Registry.FEATURE,
            new Identifier(BeyondVanilla.MOD_ID, "large_shadow_tree"), new LargeShadowTreeFeature(DefaultFeatureConfig::deserialize, false));*/
    /*public static final Feature<DefaultFeatureConfig> SHADOW_TREE = Registry.register(Registry.FEATURE,
            new Identifier(BeyondVanilla.MOD_ID, "shadow_tree"), new ShadowTreeFeature(DefaultFeatureConfig::deserialize, false));*/


    public static final Feature<NormalTreeFeatureConfig> SHADOW_TREE_TEST = Registry.register(Registry.FEATURE,
            new Identifier(BeyondVanilla.MOD_ID, "shadow_tree"), new ShadowTreeFeatureTest(NormalTreeFeatureConfig::method_23426));

    public static final NormalTreeFeatureConfig SHADOW_TREE_CONFIG = (new NormalTreeFeatureConfig.Builder(new SimpleStateProvider(BVBlocks.SHADOW_LOG.getDefaultState()), new SimpleStateProvider(BVBlocks.SHADOW_LEAVES.getDefaultState()), new BlobFoliagePlacer(2, 0))).method_23428(5).method_23430(2).method_23432(2).method_23433(0).method_23427().method_23431();;

}
