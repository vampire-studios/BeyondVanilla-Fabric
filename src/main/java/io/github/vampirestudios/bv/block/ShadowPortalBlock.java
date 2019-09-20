package io.github.vampirestudios.bv.block;

import io.github.vampirestudios.bv.BeyondVanilla;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Items;
import net.minecraft.state.StateFactory;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;

public class ShadowPortalBlock extends Block {

    public BooleanProperty OPEN = BooleanProperty.of("open");

    public ShadowPortalBlock() {
        super(Block.Settings.copy(Blocks.SMOOTH_STONE));
        this.setDefaultState(this.getStateFactory().getDefaultState().with(OPEN, false));
    }

    @Override
    public boolean activate(BlockState blockState_1, World world_1, BlockPos blockPos_1, PlayerEntity playerEntity_1, Hand hand_1, BlockHitResult blockHitResult_1) {

        if (!getDefaultState().get(OPEN)) {
            if(playerEntity_1.getStackInHand(hand_1).getItem() == Items.FLINT_AND_STEEL) {
                this.setDefaultState(this.getDefaultState().with(OPEN, true));
            }
        }

        if(getDefaultState().get(OPEN)) {
            if(playerEntity_1.world.dimension.getType() == BeyondVanilla.THE_SHADOW) {
                // coming from our custom dimension
                playerEntity_1.changeDimension(DimensionType.OVERWORLD);
                return true;
            } else {
                // going to our custom dimension
                playerEntity_1.changeDimension(BeyondVanilla.THE_SHADOW);
                return true;
            }
        }

        return false;
    }

    @Override
    protected void appendProperties(StateFactory.Builder<Block, BlockState> stateFactory$Builder_1) {
        stateFactory$Builder_1.add(OPEN);
    }
}
