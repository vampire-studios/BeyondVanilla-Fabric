package io.github.vampirestudios.bv.world.gen.feature.placement;

import com.mojang.datafixers.Dynamic;
import io.github.vampirestudios.bv.world.PlacementLevel;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Heightmap;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.chunk.ChunkGeneratorConfig;
import net.minecraft.world.gen.decorator.CountChanceDecoratorConfig;
import net.minecraft.world.gen.decorator.Decorator;

import java.util.Objects;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CountWithChanceSurfaceDoublePlacement extends Decorator<CountChanceDecoratorConfig> {
    private final PlacementLevel placementLevel;

    public CountWithChanceSurfaceDoublePlacement(Function<Dynamic<?>, ? extends CountChanceDecoratorConfig> deserialize, PlacementLevel placementLevel) {
        super(deserialize);
        this.placementLevel = placementLevel;
    }

    @Override
    public Stream<BlockPos> getPositions(IWorld world, ChunkGenerator<? extends ChunkGeneratorConfig> generator, Random random, CountChanceDecoratorConfig config, BlockPos origin) {
        return IntStream.range(0, config.count).filter(i -> random.nextFloat() < config.chance).mapToObj(i -> {
            int x = random.nextInt(16);
            int z = random.nextInt(16);

            int maxY = this.placementLevel.getSurfacePos(world, Heightmap.Type.MOTION_BLOCKING, origin.add(x, 0, z)).getY() * 2;
            if (maxY <= 0) return null;

            int y = random.nextInt(maxY);
            if (!this.placementLevel.containsY(world, y)) return null;

            return origin.add(x, y, z);
        }).filter(Objects::nonNull);
    }
}