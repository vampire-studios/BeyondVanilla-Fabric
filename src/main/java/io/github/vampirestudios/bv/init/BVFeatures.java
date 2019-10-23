package io.github.vampirestudios.bv.init;

import io.github.vampirestudios.bv.BeyondVanilla;
import io.github.vampirestudios.bv.world.gen.feature.ShadowTreeFeatureTest;
import net.minecraft.class_4640;
import net.minecraft.class_4645;
import net.minecraft.class_4656;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.Feature;

public class BVFeatures {

    /*public static final Feature<DefaultFeatureConfig> LARGE_SHADOW_TREE = Registry.register(Registry.FEATURE,
            new Identifier(BeyondVanilla.MOD_ID, "large_shadow_tree"), new LargeShadowTreeFeature(DefaultFeatureConfig::deserialize, false));*/
    /*public static final Feature<DefaultFeatureConfig> SHADOW_TREE = Registry.register(Registry.FEATURE,
            new Identifier(BeyondVanilla.MOD_ID, "shadow_tree"), new ShadowTreeFeature(DefaultFeatureConfig::deserialize, false));*/


    public static final Feature<class_4640> SHADOW_TREE_TEST = Registry.register(Registry.FEATURE,
            new Identifier(BeyondVanilla.MOD_ID, "shadow_tree"), new ShadowTreeFeatureTest(class_4640::method_23426));

    public static final class_4640 SHADOW_TREE_CONFIG = (new class_4640.class_4641(new class_4656(BVBlocks.SHADOW_LOG.getDefaultState()), new class_4656(BVBlocks.SHADOW_LEAVES.getDefaultState()), new class_4645(2, 0))).method_23428(5).method_23430(2).method_23432(2).method_23433(0).method_23427().method_23431();;

}
