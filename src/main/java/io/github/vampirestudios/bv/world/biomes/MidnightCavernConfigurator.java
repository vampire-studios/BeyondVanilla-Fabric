package io.github.vampirestudios.bv.world.biomes;

import com.mushroom.midnight.Midnight;
import com.mushroom.midnight.common.registry.MidnightBlocks;
import com.mushroom.midnight.common.registry.MidnightCarvers;
import com.mushroom.midnight.common.registry.MidnightEntities;
import com.mushroom.midnight.common.registry.MidnightFeatures;
import com.mushroom.midnight.common.registry.MidnightPlacements;
import com.mushroom.midnight.common.world.feature.config.CrystalClusterConfig;
import io.github.vampirestudios.bv.init.BVPlacements;
import net.minecraft.entity.EntityCategory;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityGroup;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.decorator.CountDecoratorConfig;
import net.minecraft.world.gen.feature.BushConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.ProbabilityConfig;
import net.minecraft.world.gen.placement.ChanceConfig;
import net.minecraft.world.gen.placement.FrequencyConfig;

public class MidnightCavernConfigurator {
    public static void addCaves(ConfigurableBiome biome) {
        biome.add(GenerationStep.Carving.AIR, Biome.createCarver(
                MidnightCarvers.WIDE_CAVE, new ProbabilityConfig(1.0F / 7.0F)
        ));
    }

    public static void addStandardFeatures(ConfigurableBiome biome) {
        biome.add(GenerationStep.Feature.VEGETAL_DECORATION, Biome.createDecoratedFeature(
                Feature.BUSH, new BushConfig(MidnightBlocks.CRYSTALOTUS.getDefaultState()),
                BVPlacements.CHANCE_UNDERGROUND_DOUBLE, new CountDecoratorConfig(20)
        ));

        biome.add(GenerationStep.Feature.VEGETAL_DECORATION, Biome.createDecoratedFeature(
                MidnightFeatures.STINGER_EGG, IFeatureConfig.NO_FEATURE_CONFIG,
                BVPlacements.COUNT_UNDERGROUND, new CountDecoratorConfig(1)
        ));
    }

    public static void addTendrilweed(ConfigurableBiome biome) {
        biome.add(GenerationStep.Feature.VEGETAL_DECORATION, Biome.createDecoratedFeature(
                Feature.BUSH, new BushConfig(MidnightBlocks.TENDRILWEED.getDefaultState()),
                BVPlacements.COUNT_UNDERGROUND_32, new CountDecoratorConfig(1)
        ));
    }

    public static void addRouxeClusters(ConfigurableBiome biome) {
        biome.add(GenerationStep.Feature.SURFACE_STRUCTURES, Biome.createDecoratedFeature(
                MidnightFeatures.CRYSTAL_CLUSTER, new CrystalClusterConfig(MidnightBlocks.ROUXE_ROCK.getDefaultState(), MidnightBlocks.ROUXE.getDefaultState()),
                BVPlacements.COUNT_UNDERGROUND, new CountDecoratorConfig(5)
        ));
    }

    public static void addBulbFungi(ConfigurableBiome biome) {
        biome.add(GenerationStep.Feature.VEGETAL_DECORATION, Biome.createDecoratedFeature(
                MidnightFeatures.GLOB_FUNGI_FLOWERS, IFeatureConfig.NO_FEATURE_CONFIG,
                BVPlacements.COUNT_UNDERGROUND_32, new CountDecoratorConfig(7)
        ));

        biome.add(GenerationStep.Feature.VEGETAL_DECORATION, Biome.createDecoratedFeature(
                MidnightFeatures.LARGE_GLOB_FUNGUS, IFeatureConfig.NO_FEATURE_CONFIG,
                BVPlacements.COUNT_UNDERGROUND, new CountDecoratorConfig(3)
        ));
    }

    /*public static void addStandardSpawns(ConfigurableBiome biome) {
//        addMonster(biome, MidnightEntities.STINGER, 100, 2, 4);
        addMonster(biome, EntityType.ENDERMAN, 10, 4, 4);
    }

    private static void addCreature(ConfigurableBiome biome, EntityType<?> type, int weight, int minGroupSize, int maxGroupSize) {
        biome.add(EntityCategory.CREATURE, new Biome.SpawnListEntry(type, weight, minGroupSize, maxGroupSize));
    }

    private static void addMonster(ConfigurableBiome biome, EntityType<?> type, int weight, int minGroupSize, int maxGroupSize) {
        biome.add(Midnight.MIDNIGHT_MOB, new Biome.SpawnListEntry(type, weight, minGroupSize, maxGroupSize));
    }*/
}