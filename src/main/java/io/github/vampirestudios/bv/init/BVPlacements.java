package io.github.vampirestudios.bv.init;

import io.github.vampirestudios.bv.BeyondVanilla;
import io.github.vampirestudios.bv.world.gen.feature.placement.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.decorator.ChanceRangeDecoratorConfig;
import net.minecraft.world.gen.decorator.CountChanceDecoratorConfig;
import net.minecraft.world.gen.decorator.CountDecoratorConfig;
import net.minecraft.world.gen.decorator.Decorator;

public class BVPlacements {
    public static final Decorator<CountDecoratorConfig> COUNT_SURFACE = new CountSurfacePlacement(CountDecoratorConfig::deserialize, SurfacePlacementLevel.INSTANCE);
    public static final Decorator<CountDecoratorConfig> COUNT_SURFACE_32 = new CountSurface32Placement(CountDecoratorConfig::deserialize, SurfacePlacementLevel.INSTANCE);
    public static final Decorator<CountDecoratorConfig> COUNT_SURFACE_DOUBLE = new CountSurfaceDoublePlacement(CountDecoratorConfig::deserialize, SurfacePlacementLevel.INSTANCE);
    public static final Decorator<ChanceRangeDecoratorConfig> CHANCE_SURFACE = new ChanceSurfacePlacement(ChanceRangeDecoratorConfig::deserialize, SurfacePlacementLevel.INSTANCE);
    public static final Decorator<ChanceRangeDecoratorConfig> CHANCE_SURFACE_DOUBLE = new ChanceSurfaceDoublePlacement(ChanceRangeDecoratorConfig::deserialize, SurfacePlacementLevel.INSTANCE);
    public static final Decorator<CountChanceDecoratorConfig> COUNT_CHANCE_SURFACE_DOUBLE = new CountWithChanceSurfaceDoublePlacement(CountChanceDecoratorConfig::deserialize, SurfacePlacementLevel.INSTANCE);

    public static final Decorator<CountDecoratorConfig> COUNT_UNDERGROUND = new CountSurfacePlacement(CountDecoratorConfig::deserialize, UndergroundPlacementLevel.INSTANCE);
    public static final Decorator<CountDecoratorConfig> COUNT_UNDERGROUND_32 = new CountSurface32Placement(CountDecoratorConfig::deserialize, UndergroundPlacementLevel.INSTANCE);
    public static final Decorator<ChanceRangeDecoratorConfig> CHANCE_UNDERGROUND = new ChanceSurfacePlacement(ChanceRangeDecoratorConfig::deserialize, UndergroundPlacementLevel.INSTANCE);
    public static final Decorator<ChanceRangeDecoratorConfig> CHANCE_UNDERGROUND_DOUBLE = new ChanceSurfaceDoublePlacement(ChanceRangeDecoratorConfig::deserialize, UndergroundPlacementLevel.INSTANCE);

    static {
        Registry.register(Registry.DECORATOR, new Identifier(BeyondVanilla.MOD_ID, "count_surface"), COUNT_SURFACE);
        Registry.register(Registry.DECORATOR, new Identifier(BeyondVanilla.MOD_ID, "count_surface_32"), COUNT_SURFACE_32);
        Registry.register(Registry.DECORATOR, new Identifier(BeyondVanilla.MOD_ID, "count_surface_double"), COUNT_SURFACE_DOUBLE);
        Registry.register(Registry.DECORATOR, new Identifier(BeyondVanilla.MOD_ID, "chance_surface"), CHANCE_SURFACE);
        Registry.register(Registry.DECORATOR, new Identifier(BeyondVanilla.MOD_ID, "chance_surface_double"), CHANCE_SURFACE_DOUBLE);
        Registry.register(Registry.DECORATOR, new Identifier(BeyondVanilla.MOD_ID, "count_chance_surface_double"), COUNT_CHANCE_SURFACE_DOUBLE);

        Registry.register(Registry.DECORATOR, new Identifier(BeyondVanilla.MOD_ID, "count_underground"), COUNT_UNDERGROUND);
        Registry.register(Registry.DECORATOR, new Identifier(BeyondVanilla.MOD_ID, "count_underground_32"), COUNT_UNDERGROUND_32);
        Registry.register(Registry.DECORATOR, new Identifier(BeyondVanilla.MOD_ID, "chance_underground"), CHANCE_UNDERGROUND);
        Registry.register(Registry.DECORATOR, new Identifier(BeyondVanilla.MOD_ID, "chance_underground_double"), CHANCE_UNDERGROUND_DOUBLE);
    }

}