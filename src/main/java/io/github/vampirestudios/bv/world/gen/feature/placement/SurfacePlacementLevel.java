package io.github.vampirestudios.bv.world.gen.feature.placement;

import io.github.vampirestudios.bv.world.PlacementLevel;
import io.github.vampirestudios.bv.world.dimension.ShadowChunkGenerator;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Heightmap;
import net.minecraft.world.IWorld;

public class SurfacePlacementLevel implements PlacementLevel {
    public static final PlacementLevel INSTANCE = new SurfacePlacementLevel();

    private SurfacePlacementLevel() {
    }

    @Override
    public BlockPos getSurfacePos(IWorld world, Heightmap.Type type, BlockPos pos) {
        return world.getTopPosition(type, pos);
    }

    @Override
    public boolean containsY(IWorld world, int y) {
        return y > ShadowChunkGenerator.SURFACE_CAVE_BOUNDARY;
    }
}