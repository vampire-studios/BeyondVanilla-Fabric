package io.github.vampirestudios.bv.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

public class FlowerBlock extends PlantBlock {
    private static final VoxelShape SHAPE = Block.createCuboidShape(5.0D, 0.0D, 5.0D, 11.0D, 10.0D, 11.0D);
    private final StatusEffect effectInStew;
    private final int effectInStewDuration;

    public FlowerBlock(StatusEffect statusEffect_1, int int_1, Settings block$Settings_1) {
        super(block$Settings_1);
        this.effectInStew = statusEffect_1;
        if (statusEffect_1.isInstant()) {
            this.effectInStewDuration = int_1;
        } else {
            this.effectInStewDuration = int_1 * 20;
        }

    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        Vec3d vec3d_1 = state.getModelOffset(world, pos);
        return SHAPE.offset(vec3d_1.x, vec3d_1.y, vec3d_1.z);
    }

    public OffsetType getOffsetType() {
        return OffsetType.XZ;
    }

    public StatusEffect getEffectInStew() {
        return this.effectInStew;
    }

    public int getEffectInStewDuration() {
        return this.effectInStewDuration;
    }
}
