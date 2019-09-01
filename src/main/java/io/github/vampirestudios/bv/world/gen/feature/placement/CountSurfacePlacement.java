package io.github.vampirestudios.bv.world.gen.feature.placement;

import com.mojang.datafixers.Dynamic;
import io.github.vampirestudios.bv.world.PlacementLevel;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Heightmap;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.chunk.ChunkGeneratorConfig;
import net.minecraft.world.gen.decorator.CountDecoratorConfig;
import net.minecraft.world.gen.decorator.Decorator;

import java.util.Random;
import java.util.function.Function;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CountSurfacePlacement extends Decorator<CountDecoratorConfig> {
    private final PlacementLevel placementLevel;

    public CountSurfacePlacement(Function<Dynamic<?>, ? extends CountDecoratorConfig> deserialize, PlacementLevel placementLevel) {
        super(deserialize);
        this.placementLevel = placementLevel;
    }

    @Override
    public Stream<BlockPos> getPositions(IWorld world, ChunkGenerator<? extends ChunkGeneratorConfig> generator, Random random, CountDecoratorConfig config, BlockPos origin) {
        return IntStream.range(0, config.count).mapToObj(i -> {
            int x = random.nextInt(16);
            int z = random.nextInt(16);
            return this.placementLevel.getSurfacePos(world, Heightmap.Type.MOTION_BLOCKING, origin.add(x, 0, z));
        });
    }
}