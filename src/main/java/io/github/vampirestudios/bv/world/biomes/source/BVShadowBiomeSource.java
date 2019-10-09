package io.github.vampirestudios.bv.world.biomes.source;

import com.google.common.collect.ImmutableSet;
import io.github.vampirestudios.bv.init.BVBiomes;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.layer.BiomeLayerSampler;
import net.minecraft.world.biome.source.BiomeSource;

import java.util.Set;

public class BVShadowBiomeSource extends BiomeSource {
	private final BiomeLayerSampler noiseLayer;
	private static final Set<Biome> biomes = ImmutableSet.of(BVBiomes.SHADOW_PLAINS, BVBiomes.SHADOW_FOREST, BVBiomes.SHADOW_SWAMP);

	public BVShadowBiomeSource(long seed) {
		super(biomes);

		BiomeLayerSampler[] layerSamplers = BVShadowBiomeLayers.createLayers(seed);

		this.noiseLayer = layerSamplers[0];
	}

	public Biome getBiome(int x, int y, int z) {
		return this.noiseLayer.sample(x, z);
	}

}