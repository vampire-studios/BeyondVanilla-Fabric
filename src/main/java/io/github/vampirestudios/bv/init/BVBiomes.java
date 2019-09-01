package io.github.vampirestudios.bv.init;

import io.github.vampirestudios.bv.BeyondVanilla;
import io.github.vampirestudios.bv.world.biomes.ShadowPlains;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;

public class BVBiomes {

    public static Biome SHADOW_PLAINS;

    static {
        SHADOW_PLAINS = Registry.register(Registry.BIOME, new Identifier(BeyondVanilla.MOD_ID, "shadow_plains"), new ShadowPlains());
    }

}
