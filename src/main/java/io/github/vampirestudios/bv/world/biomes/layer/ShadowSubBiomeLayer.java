package io.github.vampirestudios.bv.world.biomes.layer;

import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.layer.type.IdentitySamplingLayer;
import net.minecraft.world.biome.layer.util.LayerRandomnessSource;
import org.apache.commons.lang3.ArrayUtils;

import java.util.*;

public enum ShadowSubBiomeLayer implements IdentitySamplingLayer {
	INSTANCE;

	@Override
	public int sample(LayerRandomnessSource rand, int prev) {
		Biome biome = BuiltinRegistries.BIOME.get(prev);
		if (subBiomeMap.containsKey(biome)) {
			for (SubBiomeEntry entry : subBiomeMap.get(biome)) {
				if (rand.nextInt(100) < entry.chance) {
					return BuiltinRegistries.BIOME.getRawId(entry.biome);
				}
			}

		}

		// if the sub biome will not generate return previous biome
		return prev;
	}

	private final Map<Biome, List<SubBiomeEntry>> subBiomeMap = new HashMap<>();

	private Set<Biome> subBiomesList = new HashSet<>();

	/**
	 * @param parent the biome in which this biome generates
	 * @param subBiome the biome to be added as a sub biome
	 * @param chance the chance of this biome replacing the parent biome, out of 100
	 */
	public void addSubBiome(Biome parent, Biome subBiome, int chance) {
		subBiomesList.add(subBiome);
		subBiomeMap.computeIfAbsent(parent, b -> new ArrayList<>()).add(new SubBiomeEntry(subBiome, chance));
	}

	private static final class SubBiomeEntry {
		final Biome biome;
		final int chance;

		SubBiomeEntry(Biome biome, int chance) {
			this.biome = biome;
			this.chance = chance;
		}
	}

	public Biome[] addBiomes(Biome[] biomes) {
		return ArrayUtils.addAll(biomes, subBiomesList.toArray(new Biome[0]));
	}
}