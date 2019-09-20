package io.github.vampirestudios.bv.world.biomes.source;

import com.google.common.collect.ImmutableSet;
import io.github.vampirestudios.bv.init.BVBiomes;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.layer.BiomeLayerSampler;
import net.minecraft.world.biome.source.BiomeSource;

public class BVShadowBiomeSource extends BiomeSource {
	private final BiomeLayerSampler noiseLayer;
	private final BiomeLayerSampler biomeLayer;

	public BVShadowBiomeSource(long seed) {
		super(ImmutableSet.of(BVBiomes.SHADOW_PLAINS));

		BiomeLayerSampler[] layerSamplers = BVShadowBiomeLayers.createLayers(seed);

//		this.field_20643.addAll(BVShadowBiomeLayers.getBiomes());
		this.noiseLayer = layerSamplers[0];
		this.biomeLayer = layerSamplers[1];
	}

	public Biome getBiome(int x, int y, int z) {
		return this.biomeLayer.sample(x, z);
	}

}