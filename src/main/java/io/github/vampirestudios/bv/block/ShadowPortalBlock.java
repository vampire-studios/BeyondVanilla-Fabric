package io.github.vampirestudios.bv.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;

public class ShadowPortalBlock extends Block {

    public BooleanProperty OPEN = BooleanProperty.of("open");

    public ShadowPortalBlock() {
        super(Block.Settings.copy(Blocks.SMOOTH_STONE));
        this.setDefaultState(this.getStateFactory().getDefaultState().with(OPEN, false));
    }

    /*@Override
    public boolean onUse(BlockState blockState_1, World world_1, BlockPos blockPos_1, PlayerEntity playerEntity_1, Hand hand_1, BlockHitResult blockHitResult_1) {

        if (!getDefaultState().get(OPEN)) {
            if(playerEntity_1.getStackInHand(hand_1).getItem() == Items.FLINT_AND_STEEL) {
                this.setDefaultState(this.getDefaultState().with(OPEN, true));
            }
        }

        if(getDefaultState().get(OPEN)) {
            if(playerEntity_1.world.dimension.getType() == BeyondVanilla.THE_SHADOW) {
                // coming from our custom dimension
                playerEntity_1.changeDimension(DimensionType.OVERWORLD);
            } else {
                // going to our custom dimension
                playerEntity_1.changeDimension(BeyondVanilla.THE_SHADOW);
            }
            return true;
        }

        return false;
    }*/

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> stateFactory$Builder_1) {
        stateFactory$Builder_1.add(OPEN);
    }
}
