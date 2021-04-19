package io.github.vampirestudios.bv;

import io.github.vampirestudios.bv.init.BVBiomes;
import io.github.vampirestudios.bv.init.BVBlocks;
import io.github.vampirestudios.bv.init.BVPlacements;
import io.github.vampirestudios.bv.mixin.SkyPropertiesAccessor;
import io.github.vampirestudios.bv.world.dimension.FabricDimensionHelper;
import io.github.vampirestudios.bv.world.dimension.TheShadowSkyProperties;
import net.fabricmc.api.ModInitializer;
import net.minecraft.client.render.SkyProperties;
import net.minecraft.tag.BlockTags;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.source.VoronoiBiomeAccessType;
import net.minecraft.world.dimension.DimensionType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.OptionalLong;

public class BeyondVanilla implements ModInitializer {

    public static final String MOD_ID = "bv";
    public static final String MOD_NAME = "Beyond Vanilla";
    public static final String MOD_VERSION = "0.1.0";
    public static final Logger LOGGER = LogManager.getLogger("[" + MOD_NAME + "]");

    public static final SkyProperties THE_SHADOW_SKY_PROPERTIES = new TheShadowSkyProperties();

    public static final DimensionType THE_SHADOW = DimensionType.create(
            OptionalLong.of(18000L),
            false,
            true,
            true,
            false,
            8.0D,
            false,
            true,
            false,
            true,
            false,
            0,
            256,
            128,
            VoronoiBiomeAccessType.INSTANCE,
            BlockTags.INFINIBURN_NETHER.getId(),
            new Identifier(MOD_ID, "the_shadow"),
            0.1F
    );

    @Override
    public void onInitialize() {
        LOGGER.info(String.format("You are now running %s v%s", MOD_NAME, MOD_VERSION));

        SkyPropertiesAccessor.getBY_IDENTIFIER().put(RegistryKey.of(Registry.DIMENSION_TYPE_KEY, new Identifier(MOD_ID, "the_shadow")),
                new TheShadowSkyProperties());

        FabricDimensionHelper.register(THE_SHADOW, new Identifier(MOD_ID, "the_shadow"));
        new BVBlocks();
        new BVBiomes();
        new BVPlacements();
    }

}
