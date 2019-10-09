package io.github.vampirestudios.bv;

import io.github.vampirestudios.bv.init.BVBiomes;
import io.github.vampirestudios.bv.init.BVBlocks;
import io.github.vampirestudios.bv.init.BVItems;
import io.github.vampirestudios.bv.init.BVPlacements;
import io.github.vampirestudios.bv.world.dimension.ChunkGeneratorTypeWorkaround;
import io.github.vampirestudios.bv.world.dimension.ShadowChunkGenerator;
import io.github.vampirestudios.bv.world.dimension.ShadowDimension;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.dimension.v1.FabricDimensionType;
import net.minecraft.block.pattern.BlockPattern;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.gen.chunk.ChunkGeneratorConfig;
import net.minecraft.world.gen.chunk.ChunkGeneratorType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BeyondVanilla implements ModInitializer {

    public static final String MOD_ID = "bv";
    public static final String MOD_NAME = "Beyond Vanilla";
    public static final String MOD_VERSION = "0.1.0";
    public static final Logger LOGGER = LogManager.getLogger("[" + MOD_NAME + "]");

    public static final DimensionType THE_SHADOW = FabricDimensionType.builder().desiredRawId(100).defaultPlacer(
            (teleported, destination, portalDir, portalX, portalY) -> new BlockPattern.TeleportTarget(new Vec3d(0, 100, 0), teleported.getVelocity(), 0)).
            factory(ShadowDimension::new).buildAndRegister(new Identifier(MOD_ID, "the_shadow"));
    public static final ChunkGeneratorType<ChunkGeneratorConfig, ShadowChunkGenerator> SHADOW_CHUNK_GENERATOR =
            new ChunkGeneratorTypeWorkaround().getChunkGeneratorType(ChunkGeneratorConfig::new);

    @Override
    public void onInitialize() {
        LOGGER.info(String.format("You are now running %s v%s", MOD_NAME, MOD_VERSION));

        new BVBlocks();
        new BVItems();
        new BVBiomes();
        new BVPlacements();
    }

}
