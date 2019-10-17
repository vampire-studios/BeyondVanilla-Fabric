//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package io.github.vampirestudios.bv.world.dimension;

import io.github.vampirestudios.bv.world.utils.NoiseChunkPrimer;
import net.minecraft.util.SystemUtil;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.noise.OctavePerlinNoiseSampler;
import net.minecraft.world.ChunkRegion;
import net.minecraft.world.IWorld;
import net.minecraft.world.SpawnHelper;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.source.BiomeSource;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.gen.ChunkRandom;
import net.minecraft.world.gen.chunk.ChunkGeneratorConfig;
import net.minecraft.world.gen.chunk.SurfaceChunkGenerator;
import net.minecraft.world.level.LevelGeneratorType;

public class ShadowChunkGenerator extends SurfaceChunkGenerator<ChunkGeneratorConfig> {
    private static final float[] BIOME_WEIGHT_TABLE = SystemUtil.consume(new float[25], (floats_1) -> {
        for(int int_1 = -2; int_1 <= 2; ++int_1) {
            for(int int_2 = -2; int_2 <= 2; ++int_2) {
                float float_1 = 10.0F / MathHelper.sqrt((float)(int_1 * int_1 + int_2 * int_2) + 0.2F);
                floats_1[int_1 + 2 + (int_2 + 2) * 5] = float_1;
            }
        }

    });

    public static final int SURFACE_LEVEL = 78;

    public static final int MIN_CAVE_HEIGHT = 20;
    public static final int MAX_CAVE_HEIGHT = 46;

    public static final int SURFACE_CAVE_BOUNDARY = MAX_CAVE_HEIGHT + 12;

    public static final int SEA_LEVEL = SURFACE_LEVEL + 2;

    public static final int HORIZONTAL_GRANULARITY = 4;
    public static final int VERTICAL_GRANULARITY = 4;

    public static final int NOISE_WIDTH = 16 / HORIZONTAL_GRANULARITY;
    public static final int NOISE_HEIGHT = 256 / VERTICAL_GRANULARITY;

    private static final int BUFFER_WIDTH = NOISE_WIDTH + 1;
    private static final int BUFFER_HEIGHT = NOISE_HEIGHT + 1;

    private static final int BIOME_WEIGHT_RADIUS = 2;

    private static final int NOISE_SURFACE_CAVE_BOUNDARY = SURFACE_CAVE_BOUNDARY / VERTICAL_GRANULARITY;

    private final OctavePerlinNoiseSampler noiseSampler;
    private final NoiseChunkPrimer noisePrimer;
    private final boolean amplified;
    private final double[] noiseFalloff = this.buidlNoiseFalloff();

    public ShadowChunkGenerator(IWorld iWorld_1, BiomeSource biomeSource_1, ChunkGeneratorConfig config) {
        super(iWorld_1, biomeSource_1, HORIZONTAL_GRANULARITY, VERTICAL_GRANULARITY, 128, config, false);
        this.random.consume(2620);
        this.noiseSampler = new OctavePerlinNoiseSampler(this.random, 15, 0);
        this.amplified = iWorld_1.getLevelProperties().getGeneratorType() == LevelGeneratorType.AMPLIFIED;
        this.noisePrimer = new NoiseChunkPrimer(HORIZONTAL_GRANULARITY, VERTICAL_GRANULARITY, NOISE_WIDTH, NOISE_HEIGHT);
    }

    @Override
    public void populateNoise(IWorld world, Chunk chunk) {
//        double[] noise = this.noiseGenerator.sampleChunkNoise(chunk.getPos(), this.surfaceLayers, this.undergroundLayers);
        /*double[] noise = new double[BUFFER_HEIGHT * BUFFER_WIDTH * BUFFER_WIDTH];
        this.noisePrimer.primeChunk((ProtoChunk) chunk, noise, (density, x, y, z) -> {
            if (density > 0.0F) {
                return this.defaultBlock;
            } else if (y < SEA_LEVEL && y > SURFACE_CAVE_BOUNDARY) {
                return this.defaultFluid;
            }
            return null;
        });*/
        super.populateNoise(world, chunk);
    }

    public void populateEntities(ChunkRegion chunkRegion_1) {
        int int_1 = chunkRegion_1.getCenterChunkX();
        int int_2 = chunkRegion_1.getCenterChunkZ();
        Biome biome_1 = chunkRegion_1.getBiome((new ChunkPos(int_1, int_2)).getCenterBlockPos());
        ChunkRandom chunkRandom_1 = new ChunkRandom();
        chunkRandom_1.setSeed(chunkRegion_1.getSeed(), int_1 << 4, int_2 << 4);
        SpawnHelper.populateEntities(chunkRegion_1, biome_1, int_1, int_2, chunkRandom_1);
    }

    @Override
    protected void sampleNoiseColumn(double[] doubles_1, int int_1, int int_2) {
        this.sampleNoiseColumn(doubles_1, int_1, int_2, 684.412D,
                2053.236D, 8.555150000000001D, 34.2206D, 3, -10);
    }

    protected double computeNoiseFalloff(double double_1, double double_2, int int_1) {
        return this.noiseFalloff[int_1];
    }

    private double[] buidlNoiseFalloff() {
        double[] doubles_1 = new double[this.getNoiseSizeY()];

        for(int int_1 = 0; int_1 < this.getNoiseSizeY(); ++int_1) {
            doubles_1[int_1] = Math.cos((double)int_1 * 3.141592653589793D * 6.0D / (double)this.getNoiseSizeY()) * 2.0D;
            double double_1 = int_1;
            if (int_1 > this.getNoiseSizeY() / 2) {
                double_1 = this.getNoiseSizeY() - 1 - int_1;
            }

            if (double_1 < 4.0D) {
                double_1 = 4.0D - double_1;
                doubles_1[int_1] -= double_1 * double_1 * double_1 * 10.0D;
            }
        }

        return doubles_1;
    }

    protected double[] computeNoiseRange(int int_1, int int_2) {
        double[] doubles_1 = new double[2];
        float float_1 = 0.0F;
        float float_2 = 0.0F;
        float float_3 = 0.0F;
        int int_4 = this.getSeaLevel();
        float float_4 = this.biomeSource.getBiome(int_1, int_4, int_2).getDepth();

        for(int int_5 = -2; int_5 <= 2; ++int_5) {
            for(int int_6 = -2; int_6 <= 2; ++int_6) {
                Biome biome_1 = this.biomeSource.getBiome(int_1 + int_6, 100, int_2 + int_6);
                float float_5 = biome_1.getDepth();
                float float_6 = biome_1.getScale();
                if (this.amplified && float_5 > 0.0F) {
                    float_5 = 1.0F + float_5 * 2.0F;
                    float_6 = 1.0F + float_6 * 4.0F;
                }

                float float_7 = BIOME_WEIGHT_TABLE[int_6 + 2 + (int_6 + 2) * 5] / (float_5 + 2.0F);
                if (biome_1.getDepth() > float_4) {
                    float_7 /= 2.0F;
                }

                float_1 += float_6 * float_7;
                float_2 += float_5 * float_7;
                float_3 += float_7;
            }
        }

        float_1 /= float_3;
        float_2 /= float_3;
        float_1 = float_1 * 0.9F + 0.1F;
        float_2 = (float_2 * 4.0F - 1.0F) / 8.0F;
        doubles_1[0] = (double)float_2 + this.method_16414(int_1, int_2);
        doubles_1[1] = float_1;
        return doubles_1;
    }

    private double method_16414(int int_1, int int_2) {
        double double_1 = this.noiseSampler.sample(int_1 * 200, 10.0D, int_2 * 200, 1.0D, 0.0D, true) / 8000.0D;
        if (double_1 < 0.0D) {
            double_1 = -double_1 * 0.3D;
        }

        double_1 = double_1 * 3.0D - 2.0D;
        if (double_1 < 0.0D) {
            double_1 /= 28.0D;
        } else {
            if (double_1 > 1.0D) {
                double_1 = 1.0D;
            }

            double_1 /= 40.0D;
        }

        return double_1;
    }

    @Override
    public int getMaxY() {
        return 128;
    }

    public int getSpawnHeight() {
        return this.world.getSeaLevel() + 1;
    }

    public int getSeaLevel() {
        return SEA_LEVEL;
    }

}
