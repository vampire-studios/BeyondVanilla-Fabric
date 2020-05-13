package io.github.vampirestudios.bv.world.biomes.source;

import com.google.common.collect.ImmutableList;
import io.github.vampirestudios.bv.world.biomes.layer.AbyssalBiomeLayer;
import io.github.vampirestudios.bv.world.biomes.layer.AbyssalSubBiomeLayer;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.layer.AddSunflowerPlainsLayer;
import net.minecraft.world.biome.layer.ScaleLayer;
import net.minecraft.world.biome.layer.util.*;
import net.minecraft.world.biome.source.BiomeLayerSampler;

import java.util.HashSet;
import java.util.Set;
import java.util.function.LongFunction;

public final class BVAbyssalBiomeLayers {

	private static Set<Biome> biomes = new HashSet<>();

	public static BiomeLayerSampler[] createLayers(long seed) {
		ImmutableList<LayerFactory<CachingLayerSampler>> samplers = build(seed, (salt) -> new CachingLayerContext(25, seed, salt));
		BiomeLayerSampler noiseLayer = new BiomeLayerSampler(samplers.get(0));
		BiomeLayerSampler biomeLayer = new BiomeLayerSampler(samplers.get(1));

		return new BiomeLayerSampler[]{noiseLayer, biomeLayer};
	}

	private static <T extends LayerSampler, C extends LayerSampleContext<T>> ImmutableList<LayerFactory<T>> build(long seed, LongFunction<C> context) {
		int biomeSize = 4;

		LayerFactory<T> biomeFactory = AbyssalBiomeLayer.INSTANCE.create(context.apply(1L));
		biomes = AbyssalBiomeLayer.INSTANCE.getBiomes();

		biomeFactory = ScaleLayer.NORMAL.create(context.apply(1000L), biomeFactory);
		biomeFactory = ScaleLayer.NORMAL.create(context.apply(1001L), biomeFactory);

		biomeFactory = AbyssalSubBiomeLayer.INSTANCE.create(context.apply(2L), biomeFactory);
		biomes = AbyssalSubBiomeLayer.INSTANCE.addBiomes(biomes);

		for (int i = 0; i < biomeSize; ++i) {
			biomeFactory = ScaleLayer.NORMAL.create(context.apply(2000 + i), biomeFactory);
		}

		LayerFactory<T> cellScaleFactory = AddSunflowerPlainsLayer.INSTANCE.create(context.apply(10L), biomeFactory);

		return ImmutableList.of(biomeFactory, cellScaleFactory);
	}

	public static Set<Biome> getBiomes() {
		return biomes;
	}
}