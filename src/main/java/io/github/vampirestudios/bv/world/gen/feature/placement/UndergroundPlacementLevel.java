package io.github.vampirestudios.bv.world.gen.feature.placement;

import io.github.vampirestudios.bv.world.PlacementLevel;
import io.github.vampirestudios.bv.world.dimension.ShadowChunkGenerator;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Heightmap;
import net.minecraft.world.IWorld;
import net.minecraft.world.chunk.Chunk;

import java.util.function.Predicate;

public class UndergroundPlacementLevel implements PlacementLevel {
    public static final PlacementLevel INSTANCE = new UndergroundPlacementLevel();

    private UndergroundPlacementLevel() {
    }

    @Override
    public BlockPos getSurfacePos(IWorld world, Heightmap.Type heightmap, BlockPos pos) {
        Chunk chunk = world.getChunk(pos);
        Predicate<BlockState> predicate = heightmap.getBlockPredicate();

        BlockPos.Mutable mutablePos = new BlockPos.Mutable(pos);

        for (int y = 5; y < ShadowChunkGenerator.SURFACE_CAVE_BOUNDARY; y++) {
            mutablePos.setY(y);

            BlockState state = chunk.getBlockState(mutablePos);
            if (!predicate.test(state)) {
                return mutablePos.toImmutable();
            }
        }

        return pos;
    }

    @Override
    public boolean containsY(IWorld world, int y) {
        return y < ShadowChunkGenerator.SURFACE_CAVE_BOUNDARY;
    }
}