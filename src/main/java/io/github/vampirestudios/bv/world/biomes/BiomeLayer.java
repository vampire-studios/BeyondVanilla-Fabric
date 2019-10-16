package io.github.vampirestudios.bv.world.biomes;

import net.minecraft.world.biome.layer.CachingLayerSampler;

import javax.annotation.Nonnull;
import java.lang.reflect.Array;
import java.util.function.IntFunction;

public final class BiomeLayer<T> {
    private final Class<T> type;
    private final CachingLayerSampler sampler;
    private final IntFunction<T> function;
    private final T defaultValue;

    BiomeLayer(Class<T> type, CachingLayerSampler sampler, IntFunction<T> function, T defaultValue) {
        this.type = type;
        this.sampler = sampler;
        this.function = function;
        this.defaultValue = defaultValue;
    }

    @Nonnull
    public T sample(int x, int y) {
        int value = this.sampler.sample(x, y);
        return this.applyFunction(value);
    }

    @SuppressWarnings("unchecked")
    public T[] sample(int x, int y, int width, int height) {
        T[] result = (T[]) Array.newInstance(this.type, width * height);
        for (int localY = 0; localY < height; localY++) {
            for (int localX = 0; localX < width; localX++) {
                int value = this.sampler.sample(localX + x, localY + y);
                result[localX + localY * width] = this.applyFunction(value);
            }
        }

        return result;
    }

    @Nonnull
    private T applyFunction(int value) {
        T biome = this.function.apply(value);
        if (biome == null) {
//            Midnight.LOGGER.error("Got null value for id {} of type {}", value, this.type);
            return this.defaultValue;
        }
        return biome;
    }
}