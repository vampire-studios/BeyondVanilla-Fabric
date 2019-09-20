package io.github.vampirestudios.bv.world.dimension;

import net.fabricmc.fabric.impl.registry.RemapException;

public class DimensionRemapException extends RuntimeException {
	public DimensionRemapException(String message, RemapException cause) {
		super(message, cause);
	}
}