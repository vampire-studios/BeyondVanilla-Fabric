package io.github.vampirestudios.bv.world.dimension;

import io.github.vampirestudios.bv.BeyondVanilla;
import io.github.vampirestudios.bv.init.BVBlocks;
import io.github.vampirestudios.bv.world.biomes.source.BVAbyssalBiomeSource;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.dimension.Dimension;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.chunk.ChunkGeneratorConfig;

import javax.annotation.Nullable;

public class AbyssalDimension extends Dimension {

    public AbyssalDimension(World world_1, DimensionType dimensionType_1) {
        super(world_1, dimensionType_1, 0.0F);
    }

    @Environment(EnvType.CLIENT)
    public Vec3d getFogColor(float float_1, float float_2) {
        return new Vec3d(0.1, 0.1, 0.2);
    }

    @Nullable
    @Environment(EnvType.CLIENT)
    public float[] getBackgroundColor(float float_1, float float_2) {
        return null;
    }

    @Override
    public ChunkGenerator<?> createChunkGenerator() {
        ChunkGeneratorConfig config = new ChunkGeneratorConfig();
        config.setDefaultBlock(BVBlocks.SHADOW_STONE.getDefaultState());
        config.setDefaultFluid(Blocks.WATER.getDefaultState());

        return BeyondVanilla.ABYSSAL_CHUNK_GENERATOR.create(this.world, new BVAbyssalBiomeSource(this.world.getSeed()), config);
    }

    @Override
    public BlockPos getSpawningBlockInChunk(ChunkPos chunkPos, boolean b) {
        return null;
    }

    @Override
    public BlockPos getTopSpawningBlockPosition(int var1, int var2, boolean var3) {
        return null;
    }

    @Override
    public float getSkyAngle(long long_1, float float_1) {
        return 0.5F;
    }

    @Override
    public boolean hasVisibleSky() {
        return false;
    }

    @Override
    public boolean canPlayersSleep() {
        return false;
    }

    @Override
    public boolean hasSkyLight() {
        return false;
    }

    @Override
    public boolean isFogThick(int i, int j) {
        return false;
    }

    @Override
    public DimensionType getType() {
        return BeyondVanilla.THE_ABYSS;
    }

}