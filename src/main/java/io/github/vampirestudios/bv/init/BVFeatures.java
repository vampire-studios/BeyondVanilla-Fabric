package io.github.vampirestudios.bv.init;

import io.github.vampirestudios.bv.BeyondVanilla;
import io.github.vampirestudios.bv.world.gen.feature.LargeShadowTreeFeature;
import io.github.vampirestudios.bv.world.gen.feature.ShadowTreeFeature;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;

public class BVFeatures {

    public static final Feature<DefaultFeatureConfig> LARGE_SHADOW_TREE = Registry.register(Registry.FEATURE,
            new Identifier(BeyondVanilla.MOD_ID, "large_shadow_tree"), new LargeShadowTreeFeature(DefaultFeatureConfig::deserialize, false));
    public static final Feature<DefaultFeatureConfig> SHADOW_TREE = Registry.register(Registry.FEATURE,
            new Identifier(BeyondVanilla.MOD_ID, "lshadow_tree"), new ShadowTreeFeature(DefaultFeatureConfig::deserialize, false));


}
