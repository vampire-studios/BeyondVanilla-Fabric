package io.github.vampirestudios.bv.world.biomes;

import io.github.vampirestudios.bv.init.BVBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.sound.BiomeMoodSound;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeEffects;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.biome.SpawnSettings;
import net.minecraft.world.gen.surfacebuilder.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.TernarySurfaceConfig;

public class ShadowPlains extends Biome {
    static final ConfiguredSurfaceBuilder<?> SURFACE_BUILDER = new ConfiguredSurfaceBuilder<>(SurfaceBuilder.DEFAULT, new TernarySurfaceConfig(BVBlocks.SHADOW_GRASS.getDefaultState(),
            BVBlocks.SHADOW_DIRT.getDefaultState(), Blocks.AIR.getDefaultState()));
    static final Weather WEATHER = new Weather(Precipitation.NONE, 0.0F, TemperatureModifier.NONE, 0.0F);
    static final SpawnSettings.Builder SPAWN_SETTINGS = new SpawnSettings.Builder();
    static final GenerationSettings.Builder GENERATION_SETTINGS = (new GenerationSettings.Builder()).surfaceBuilder(SURFACE_BUILDER);

    public ShadowPlains() {
        super(WEATHER, Category.UNDERGROUND, 1.0F, 1.0F, (new BiomeEffects.Builder())
                .waterColor(0xFFFFFF).waterFogColor(0xFFFFFF).fogColor(0x171B32).skyColor(0x171B32)
                .moodSound(BiomeMoodSound.CAVE).build(), GENERATION_SETTINGS.build(), SPAWN_SETTINGS.build());
    }

    static {
//        DefaultBiomeFeatures.addDefaultUndergroundStructures(GENERATION_SETTINGS);
//        DefaultBiomeFeatures.addLandCarvers(GENERATION_SETTINGS);
//        DefaultBiomeFeatures.addDungeons(GENERATION_SETTINGS);
//        DefaultBiomeFeatures.addMineables(GENERATION_SETTINGS);
//        DefaultBiomeFeatures.addDefaultOres(GENERATION_SETTINGS);
//        DefaultBiomeFeatures.addDefaultDisks(GENERATION_SETTINGS);
//        DefaultBiomeFeatures.addDefaultMushrooms(GENERATION_SETTINGS);
//        DefaultBiomeFeatures.addDefaultVegetation(GENERATION_SETTINGS);
//        DefaultBiomeFeatures.addFrozenTopLayer(GENERATION_SETTINGS);
//        SPAWN_SETTINGS.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.PIG, 10, 4, 4));
//        SPAWN_SETTINGS.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.WOLF, 8, 4, 4));
//        SPAWN_SETTINGS.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.RABBIT, 4, 2, 3));
//        SPAWN_SETTINGS.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.FOX, 8, 2, 4));
//        SPAWN_SETTINGS.spawn(SpawnGroup.AMBIENT, new SpawnSettings.SpawnEntry(EntityType.BAT, 10, 8, 8));
//        SPAWN_SETTINGS.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.CAVE_SPIDER, 100, 4, 4));
//        SPAWN_SETTINGS.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.SLIME, 100, 4, 4));
//        SPAWN_SETTINGS.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.ENDERMAN, 10, 1, 4));
//        SPAWN_SETTINGS.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.WITCH, 5, 1, 1));
    }
}