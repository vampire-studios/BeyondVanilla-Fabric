package io.github.vampirestudios.bv.world.biomes.source;

import com.google.common.collect.Sets;
import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.source.BiomeLayerSampler;
import net.minecraft.world.biome.source.BiomeSource;
import net.minecraft.world.biome.source.VanillaLayeredBiomeSource;
import net.minecraft.world.gen.feature.StructureFeature;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class BVShadowBiomeSource extends BiomeSource {
	private final BiomeLayerSampler biomeLayer;
	private final Registry<Biome> biomeRegistry;

	public BVShadowBiomeSource(long seed, Registry<Biome> biomeRegistry) {
		super(Immutable);
		this.biomeRegistry = biomeRegistry;
		this.biomes = BVShadowBiomeLayers.getBiomes();

		BiomeLayerSampler[] layerSamplers = BVShadowBiomeLayers.createLayers(seed);
		this.biomeLayer = layerSamplers[0];
	}

	@Override
	public Biome getBiomeForNoiseGen(int biomeX, int biomeY, int biomeZ) {
		return this.biomeLayer.sample(this.biomeRegistry, biomeX, biomeZ);
	}

	@Override
	protected Codec<? extends BiomeSource> getCodec() {
		return null;
	}

	@Override
	public BiomeSource withSeed(long seed) {
		return null;
	}
}