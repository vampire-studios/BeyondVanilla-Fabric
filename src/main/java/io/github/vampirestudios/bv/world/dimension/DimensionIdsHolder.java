package io.github.vampirestudios.bv.world.dimension;

import net.minecraft.nbt.CompoundTag;

/**
 * An object holding a raw id -> full id map for fabric dimensions
 */
public interface DimensionIdsHolder {
	CompoundTag fabric_getDimensionIds();
}