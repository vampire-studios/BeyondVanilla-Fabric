package io.github.vampirestudios.bv.world.gen.carver;

import com.mojang.datafixers.Dynamic;
import com.mushroom.midnight.common.registry.MidnightBlocks;
import com.mushroom.midnight.common.world.MidnightChunkGenerator;
import io.github.vampirestudios.bv.world.dimension.ShadowChunkGenerator;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.material.Material;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.ProbabilityConfig;
import net.minecraft.world.gen.carver.CaveCarver;

import java.util.BitSet;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Function;

public class MidnightCaveCarver extends CaveCarver {
    private final float radiusScale;

    public MidnightCaveCarver(Function<Dynamic<?>, ? extends ProbabilityConfig> deserialize, float radiusScale) {
        super(deserialize, 256);
        this.radiusScale = radiusScale;
    }

    @Override
    protected int getCaveY(Random random) {
        return random.nextInt(random.nextInt(ShadowChunkGenerator.SEA_LEVEL) + 8);
    }

    @Override
    public boolean carve(Chunk chunk, Function<BlockPos, Biome> function, Random random, int i, int i1, int i2, int i3, int i4, BitSet bitSet, ProbabilityConfig probabilityConfig) {
        return false;
    }

    @Override
    public boolean carve(Chunk chunk, BitSet carvingMask, Random random, BlockPos.MutableBlockPos posHere, BlockPos.MutableBlockPos posAbove, BlockPos.MutableBlockPos posBelow, int p_222703_7_, int p_222703_8_, int p_222703_9_, int globalX, int globalZ, int x, int y, int z, AtomicBoolean foundSurface) {
        int index = x | z << 4 | y << 8;
        if (carvingMask.get(index)) {
            return false;
        }

        carvingMask.set(index);
        posHere.setPos(globalX, y, globalZ);

        BlockState state = chunk.getBlockState(posHere);
        BlockState stateAbove = chunk.getBlockState(posAbove.setPos(posHere).move(Direction.UP));
        if (!this.canCarveBlock(state, stateAbove)) {
            return false;
        }

        if (y > 10) {
            chunk.setBlockState(posHere, CAVE_AIR, false);
        } else {
            chunk.setBlockState(posHere, MidnightBlocks.MIASMA.getDefaultState(), false);
        }

        return true;
    }

    @Override
    protected boolean canCarveBlock(BlockState state, BlockState aboveState) {
        if (state.getBlock() == Blocks.BEDROCK) return false;

        Material material = state.getMaterial();
        Material aboveMaterial = aboveState.getMaterial();
        return (material == Material.ROCK || material == Material.EARTH || material == Material.ORGANIC)
                && material != Material.WATER && material != Material.LAVA
                && aboveMaterial != Material.WATER && aboveMaterial != Material.LAVA;
    }

    @Override
    protected float generateCaveRadius(Random random) {
        return super.generateCaveRadius(random) * this.radiusScale;
    }
}