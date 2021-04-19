package io.github.vampirestudios.bv.world.dimension;

import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.dimension.DimensionType;

public class FabricDimensionHelper {
    private static final Registry<DimensionType> DIMENSION_TYPES = (Registry<DimensionType>) Registry.REGISTRIES.get(Registry.DIMENSION_TYPE_KEY.getValue());

    public static void register(DimensionType dimensionType, Identifier id) {
        Registry.register(DIMENSION_TYPES, id, dimensionType);
    }
}