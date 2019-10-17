package io.github.vampirestudios.bv.init;

import io.github.vampirestudios.bv.BeyondVanilla;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.ProbabilityConfig;
import net.minecraft.world.gen.carver.Carver;

public class MidnightCarvers {
    public static final Carver<ProbabilityConfig> WIDE_CAVE = new MidnightCaveCarver(ProbabilityConfig::deserialize, 3.0F);

    public static void registerCarvers(IForgeRegistry<WorldCarver<?>> registry) {
        RegUtil.generic(registry)
                .add("wide_cave", WIDE_CAVE);
    }

    static {
        Registry.register(Registry.CARVER, new Identifier(BeyondVanilla.MOD_ID, "wide_cave"), WIDE_CAVE);
    }

}