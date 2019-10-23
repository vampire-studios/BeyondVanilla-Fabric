package io.github.vampirestudios.bv.world.biomes;

import io.github.vampirestudios.bv.world.dimension.ShadowChunkGenerator;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityCategory;
import net.minecraft.entity.EntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ChunkRegion;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.gen.ChunkRandom;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.carver.CarverConfig;
import net.minecraft.world.gen.carver.ConfiguredCarver;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.StructureFeature;

import java.util.Collection;
import java.util.List;

public interface ConfigurableBiome {
    void add(GenerationStep.Feature stage, ConfiguredFeature<?, ?> feature);

    <C extends CarverConfig> void add(GenerationStep.Carver stage, ConfiguredCarver<C> carver);

    <C extends FeatureConfig> void add(ConfiguredFeature<C, ? extends StructureFeature<C>> structure);

    void add(EntityCategory classification, Biome.SpawnEntry entry);

    void placeFeatures(GenerationStep.Feature stage, ShadowChunkGenerator generator, ChunkRegion world, long seed, ChunkRandom random, BlockPos origin);

    void generateSurface(ChunkRandom random, Chunk chunk, int x, int z, int y, double depth, BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed);

    Collection<ConfiguredCarver<?>> getCarversFor(GenerationStep.Carver stage);

    List<Biome.SpawnEntry> getSpawnsFor(EntityType classification);
}