package io.github.vampirestudios.bv.world.gen;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Heightmap;
import net.minecraft.world.IWorld;

public interface PlacementLevel {
    BlockPos getSurfacePos(IWorld world, Heightmap.Type heightmap, BlockPos pos);

    boolean containsY(IWorld world, int y);
}