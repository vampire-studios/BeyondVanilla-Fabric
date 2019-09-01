package io.github.vampirestudios.bv.world.gen.feature.placement;

import com.mojang.datafixers.Dynamic;
import io.github.vampirestudios.bv.world.PlacementLevel;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Heightmap;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.chunk.ChunkGeneratorConfig;
import net.minecraft.world.gen.decorator.ChanceDecoratorConfig;
import net.minecraft.world.gen.decorator.Decorator;

import java.util.Random;
import java.util.function.Function;
import java.util.stream.Stream;

public class ChanceSurfaceDoublePlacement extends Decorator<ChanceDecoratorConfig> {
    private final PlacementLevel placementLevel;

    public ChanceSurfaceDoublePlacement(Function<Dynamic<?>, ? extends ChanceDecoratorConfig> deserialize, PlacementLevel placementLevel) {
        super(deserialize);
        this.placementLevel = placementLevel;
    }

    @Override
    public Stream<BlockPos> getPositions(IWorld world, ChunkGenerator<? extends ChunkGeneratorConfig> generator, Random random, ChanceDecoratorConfig config, BlockPos origin) {
        if (random.nextFloat() < 1.0F / config.chance) {
            int x = random.nextInt(16);
            int z = random.nextInt(16);

            int maxY = this.placementLevel.getSurfacePos(world, Heightmap.Type.MOTION_BLOCKING, origin.add(x, 0, z)).getY() * 2;
            if (maxY <= 0) return Stream.empty();

            int y = random.nextInt(maxY);
            if (!this.placementLevel.containsY(world, y)) return Stream.empty();

            return Stream.of(origin.add(x, y, z));
        }

        return Stream.empty();
    }
}