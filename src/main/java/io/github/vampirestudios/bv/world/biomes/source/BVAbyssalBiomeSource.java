package io.github.vampirestudios.bv.world.biomes.source;

import com.google.common.collect.ImmutableSet;
import io.github.vampirestudios.bv.init.BVBiomes;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.source.BiomeLayerSampler;
import net.minecraft.world.biome.source.BiomeSource;

import java.util.Set;

public class BVAbyssalBiomeSource extends BiomeSource {
	private final BiomeLayerSampler noiseLayer;
	private static final Set<Biome> biomes = ImmutableSet.of(BVBiomes.ABYSSAL_PLAINS);

	public BVAbyssalBiomeSource(long seed) {
		super(biomes);

		BiomeLayerSampler[] layerSamplers = BVAbyssalBiomeLayers.createLayers(seed);

		this.noiseLayer = layerSamplers[0];
	}

	public Biome getBiomeForNoiseGen(int x, int y, int z) {
		return this.noiseLayer.sample(x, z);
	}

}