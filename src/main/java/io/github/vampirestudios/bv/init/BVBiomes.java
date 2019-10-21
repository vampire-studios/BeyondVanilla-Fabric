package io.github.vampirestudios.bv.init;

import io.github.vampirestudios.bv.BeyondVanilla;
import io.github.vampirestudios.bv.world.biomes.AbyssalPlains;
import io.github.vampirestudios.bv.world.biomes.ShadowForest;
import io.github.vampirestudios.bv.world.biomes.ShadowPlains;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;

public class BVBiomes {

    public static Biome SHADOW_PLAINS;
    public static Biome SHADOW_FOREST;
    public static Biome SHADOW_SWAMP;
    public static Biome ABYSSAL_PLAINS;

    static {
        SHADOW_PLAINS = Registry.register(Registry.BIOME, new Identifier(BeyondVanilla.MOD_ID, "shadow_plains"), new ShadowPlains());
        SHADOW_FOREST = Registry.register(Registry.BIOME, new Identifier(BeyondVanilla.MOD_ID, "shadow_forest"), new ShadowForest());
        SHADOW_SWAMP = Registry.register(Registry.BIOME, new Identifier(BeyondVanilla.MOD_ID, "shadow_swamp"), new ShadowPlains());
        ABYSSAL_PLAINS = Registry.register(Registry.BIOME, new Identifier(BeyondVanilla.MOD_ID, "abyssal_plains"), new AbyssalPlains());
    }

}
