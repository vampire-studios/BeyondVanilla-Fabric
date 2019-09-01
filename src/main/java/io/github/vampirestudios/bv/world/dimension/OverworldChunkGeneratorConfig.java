//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package io.github.vampirestudios.bv.world.dimension;

import net.minecraft.world.gen.chunk.ChunkGeneratorConfig;

public class OverworldChunkGeneratorConfig extends ChunkGeneratorConfig {
    private final int field_13224 = 4;
    private final int field_13223 = 4;
    private final int field_13222 = -1;
    private final int field_13221 = 63;

    public OverworldChunkGeneratorConfig() {
    }

    public int getBiomeSize() {
        return 4;
    }

    public int getRiverSize() {
        return 4;
    }

    public int getForcedBiome() {
        return -1;
    }

    public int getMinY() {
        return 0;
    }
}
