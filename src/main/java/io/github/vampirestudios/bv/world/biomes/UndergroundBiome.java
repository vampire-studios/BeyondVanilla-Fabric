package io.github.vampirestudios.bv.world.biomes;

import com.google.common.base.Preconditions;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import io.github.vampirestudios.bv.world.dimension.ShadowChunkGenerator;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ChunkRegion;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.gen.ChunkRandom;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.carver.CarverConfig;
import net.minecraft.world.gen.carver.ConfiguredCarver;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.StructureFeature;
import net.minecraft.world.gen.surfacebuilder.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.SurfaceConfig;

import java.util.*;

public abstract class UndergroundBiome implements ConfigurableBiome {
    protected final ConfiguredSurfaceBuilder<?> surfaceBuilder;
    protected final float cavernDensity;
    protected final float floorHeight;
    protected final float ceilingHeight;
    protected final float heightScale;
    protected final float pillarWeight;

    protected final Multimap<GenerationStep.Carver, ConfiguredCarver<?>> carvers = HashMultimap.create();
    protected final Multimap<GenerationStep.Feature, ConfiguredFeature<?>> features = HashMultimap.create();
    protected final List<ConfiguredFeature<?>> flowers = new ArrayList<>();
    protected final Map<StructureFeature<?>, FeatureConfig> structures = new HashMap<>();
    protected final Map<EntityCategory, List<Biome.SpawnEntry>> spawns = new HashMap<>();

    public UndergroundBiome(Properties properties) {
        Preconditions.checkNotNull(properties.surfaceBuilder, "must have surfacebuilder");

        this.surfaceBuilder = properties.surfaceBuilder;
        this.cavernDensity = properties.cavernDensity;
        this.floorHeight = properties.floorHeight;
        this.ceilingHeight = properties.ceilingHeight;
        this.heightScale = properties.heightScale;
        this.pillarWeight = properties.pillarWeight;
    }

    @Override
    public void add(GenerationStep.Feature stage, ConfiguredFeature<?> feature) {
        if (feature.feature == Feature.DECORATED_FLOWER) {
            this.flowers.add(feature);
        }
        this.features.put(stage, feature);
    }

    @Override
    public <C extends CarverConfig> void add(GenerationStep.Carver stage, ConfiguredCarver<C> carver) {
        this.carvers.put(stage, carver);
    }

    @Override
    public <C extends FeatureConfig> void add(StructureFeature<C> structure, C config) {
        this.structures.put(structure, config);
    }

    @Override
    public void add(EntityCategory classification, Biome.SpawnEntry entry) {
        this.getSpawnsFor(classification).add(entry);
    }

    @Override
    public void placeFeatures(GenerationStep.Feature stage, ShadowChunkGenerator generator, ChunkRegion world, long seed, ChunkRandom random, BlockPos origin) {
        int index = 0;

        for (ConfiguredFeature<?> feature : this.features.get(stage)) {
            random.setFeatureSeed(seed, index, stage.ordinal());
            feature.generate(world, generator, random, origin);

            index++;
        }
    }

    @Override
    public void generateSurface(ChunkRandom random, Chunk chunk, int x, int z, int startY, double depth, BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed) {
        this.surfaceBuilder.initSeed(seed);
        this.surfaceBuilder.generate(random, chunk, Biomes.DEFAULT, x, z, startY, depth, defaultBlock, defaultFluid, seaLevel, seed);
    }

    @Override
    public Collection<ConfiguredCarver<?>> getCarversFor(GenerationStep.Carver stage) {
        return this.carvers.get(stage);
    }

    @Override
    public List<Biome.SpawnEntry> getSpawnsFor(EntityCategory classification) {
        return this.spawns.computeIfAbsent(classification, c -> new ArrayList<>());
    }

    public float getCavernDensity() {
        return this.cavernDensity;
    }

    public float getFloorHeight() {
        return this.floorHeight;
    }

    public float getCeilingHeight() {
        return this.ceilingHeight;
    }

    public float getHeightScale() {
        return this.heightScale;
    }

    public float getPillarWeight() {
        return this.pillarWeight;
    }

    public static class Properties {
        private ConfiguredSurfaceBuilder<?> surfaceBuilder;
        private float cavernDensity = -5.0F;
        private float floorHeight = 0.0F;
        private float ceilingHeight = 1.0F;
        private float heightScale = 0.1F;
        private float pillarWeight = 1.0F;

        protected Properties() {
        }

        public <SC extends SurfaceConfig> Properties surfaceBuilder(SurfaceBuilder<SC> surface, SC config) {
            this.surfaceBuilder = new ConfiguredSurfaceBuilder<>(surface, config);
            return this;
        }

        public Properties cavernDensity(float density) {
            this.cavernDensity = density;
            return this;
        }

        public Properties floorHeight(float floorHeight) {
            this.floorHeight = floorHeight;
            return this;
        }

        public Properties ceilingHeight(float ceilingHeight) {
            this.ceilingHeight = ceilingHeight;
            return this;
        }

        public Properties heightScale(float heightScale) {
            this.heightScale = heightScale;
            return this;
        }

        public Properties pillarWeight(float pillarWeight) {
            this.pillarWeight = pillarWeight;
            return this;
        }
    }
}