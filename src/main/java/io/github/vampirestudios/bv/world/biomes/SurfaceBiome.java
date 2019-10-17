package io.github.vampirestudios.bv.world.biomes;

import io.github.vampirestudios.bv.world.dimension.ShadowChunkGenerator;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityCategory;
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
import net.minecraft.world.gen.surfacebuilder.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.SurfaceConfig;

import javax.annotation.Nullable;
import java.util.Collection;
import java.util.List;

public abstract class SurfaceBiome extends Biome implements ConfigurableBiome {
    private final float ridgeWeight;
    private final float densityScale;

    private final int grassColor;
    private final int foliageColor;
    private final int skyColor;

    private final float fogStart;
    private final float fogEnd;

    protected SurfaceBiome(Properties properties) {
        super(properties);

        this.ridgeWeight = properties.ridgeWeight;
        this.densityScale = properties.densityScale;

        this.grassColor = properties.grassColor;
        this.foliageColor = properties.foliageColor;
        this.skyColor = properties.skyColor;

        this.fogStart = properties.fogStart;
        this.fogEnd = properties.fogEnd;
    }

    /*@Override
    public boolean doesWaterFreeze(IWorldReader world, BlockPos pos) {
        return false;
    }*/

    @Override
    public int getGrassColorAt(BlockPos pos) {
        return this.grassColor;
    }

    @Override
    public int getFoliageColorAt(BlockPos pos) {
        return this.foliageColor;
    }

    public float getRidgeWeight() {
        return this.ridgeWeight;
    }

    public float getDensityScale() {
        return this.densityScale;
    }

    public int getSkyColor() {
        return this.skyColor;
    }

    public float getFogStart() {
        return this.fogStart;
    }

    public float getFogEnd() {
        return this.fogEnd;
    }

    @Override
    public int getSkyColor(float temperature) {
        return this.skyColor;
    }

    @Override
    public void add(GenerationStep.Feature stage, ConfiguredFeature<?> feature) {
        super.addFeature(stage, feature);
    }

    @Override
    public <C extends CarverConfig> void add(GenerationStep.Carver stage, ConfiguredCarver<C> carver) {
        super.addCarver(stage, carver);
    }

    @Override
    public <C extends FeatureConfig> void add(StructureFeature<C> structure, C config) {
        super.addStructureFeature(structure, config);
    }

    @Override
    public void add(EntityCategory classification, SpawnEntry entry) {
        super.addSpawn(classification, entry);
    }

    @Override
    public void placeFeatures(GenerationStep.Feature stage, ShadowChunkGenerator generator, ChunkRegion world, long seed, ChunkRandom random, BlockPos origin) {
//        this.generateSurface(stage, generator, world, seed, random, origin);
    }

    @Override
    public void generateSurface(ChunkRandom random, Chunk chunk, int x, int z, int y, double depth, BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed) {
        this.buildSurface(random, chunk, x, z, y, depth, defaultBlock, defaultFluid, seaLevel, seed);
    }

    @Override
    public Collection<ConfiguredCarver<?>> getCarversFor(GenerationStep.Carver stage) {
        return this.carvers.get(stage);
    }

    @Override
    public List<SpawnEntry> getSpawnsFor(EntityCategory classification) {
        return this.getSpawnsFor(classification);
    }

    public static class Properties extends Biome.Settings {
        private float ridgeWeight = 1.0F;
        private float densityScale = 1.0F;
        private int grassColor = 0x766B9E;
        private int foliageColor = 0x8F6DBC;
        private int skyColor = 0x171B32;

        private float fogStart = 20.0F;
        private float fogEnd = 140.0F;

        public Properties() {
            super.precipitation(Precipitation.NONE);
            super.downfall(0.0F);
            super.temperature(0.0F);
            super.waterColor(0x361D78);
            super.waterFogColor(0x50533);
        }

        public Properties ridgeWeight(float ridgeWeight) {
            this.ridgeWeight = ridgeWeight;
            return this;
        }

        public Properties densityScale(float densityScale) {
            this.densityScale = densityScale;
            return this;
        }

        public Properties grassColor(int grassColor) {
            this.grassColor = grassColor;
            return this;
        }

        public Properties foliageColor(int foliageColor) {
            this.foliageColor = foliageColor;
            return this;
        }

        public Properties skyColor(int skyColor) {
            this.skyColor = skyColor;
            return this;
        }

        public Properties fog(float start, float end) {
            this.fogStart = start;
            this.fogEnd = end;
            return this;
        }

        @Override
        public <SC extends SurfaceConfig> Properties configureSurfaceBuilder(SurfaceBuilder<SC> surface, SC config) {
            super.configureSurfaceBuilder(surface, config);
            return this;
        }

        @Override
        public Properties surfaceBuilder(ConfiguredSurfaceBuilder<?> surface) {
            super.surfaceBuilder(surface);
            return this;
        }

        @Override
        public Properties precipitation(Precipitation rainType) {
            super.precipitation(rainType);
            return this;
        }

        @Override
        public Properties category(Category category) {
            super.category(category);
            return this;
        }

        @Override
        public Properties depth(float depth) {
            super.depth(depth);
            return this;
        }

        @Override
        public Properties scale(float scale) {
            super.scale(scale);
            return this;
        }

        @Override
        public Properties temperature(float temperature) {
            super.temperature(temperature);
            return this;
        }

        @Override
        public Properties downfall(float downfall) {
            super.downfall(downfall);
            return this;
        }

        @Override
        public Properties waterColor(int waterColor) {
            super.waterColor(waterColor);
            return this;
        }

        @Override
        public Properties waterFogColor(int waterFogColor) {
            super.waterFogColor(waterFogColor);
            return this;
        }

        @Override
        public Properties parent(@Nullable String parent) {
            super.parent(parent);
            return this;
        }
    }
}