//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package io.github.vampirestudios.bv.world.gen.feature;

import com.mojang.datafixers.Dynamic;
import io.github.vampirestudios.bv.init.BVBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockBox;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockPos.Mutable;
import net.minecraft.world.ModifiableTestableWorld;
import net.minecraft.world.TestableWorld;
import net.minecraft.world.gen.feature.AbstractTreeFeature;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;

import java.util.Random;
import java.util.Set;
import java.util.function.Function;

public class ShadowTreeFeature extends AbstractTreeFeature<DefaultFeatureConfig> {
    private static final BlockState LOG;
    private static final BlockState LEAVES;
    protected final int height;
    private final BlockState log;
    private final BlockState leaves;

    public ShadowTreeFeature(Function<Dynamic<?>, ? extends DefaultFeatureConfig> function_1, boolean boolean_1) {
        this(function_1, boolean_1, 4, LOG, LEAVES);
    }

    public ShadowTreeFeature(Function<Dynamic<?>, ? extends DefaultFeatureConfig> config, boolean neighbourUpdate, int height, BlockState log, BlockState leaves) {
        super(config, neighbourUpdate);
        this.height = height;
        this.log = log;
        this.leaves = leaves;
    }

    public boolean generate(Set<BlockPos> set_1, ModifiableTestableWorld modifiableTestableWorld_1, Random random_1, BlockPos blockPos_1, BlockBox blockBox_1) {
        int int_1 = this.getTreeHeight(random_1);
        boolean boolean_1 = true;
        if (blockPos_1.getY() >= 1 && blockPos_1.getY() + int_1 + 1 <= 256) {
            int int_9;
            int int_18;
            for(int int_2 = blockPos_1.getY(); int_2 <= blockPos_1.getY() + 1 + int_1; ++int_2) {
                int int_3 = 1;
                if (int_2 == blockPos_1.getY()) {
                    int_3 = 0;
                }

                if (int_2 >= blockPos_1.getY() + 1 + int_1 - 2) {
                    int_3 = 2;
                }

                Mutable blockPos$Mutable_1 = new Mutable();

                for(int_9 = blockPos_1.getX() - int_3; int_9 <= blockPos_1.getX() + int_3 && boolean_1; ++int_9) {
                    for(int_18 = blockPos_1.getZ() - int_3; int_18 <= blockPos_1.getZ() + int_3 && boolean_1; ++int_18) {
                        if (int_2 >= 0 && int_2 < 256) {
                            if (!canTreeReplace(modifiableTestableWorld_1, blockPos$Mutable_1.set(int_9, int_2, int_18))) {
                                boolean_1 = false;
                            }
                        } else {
                            boolean_1 = false;
                        }
                    }
                }
            }

            if (!boolean_1) {
                return false;
            } else if (isDirtOrGrass(modifiableTestableWorld_1, blockPos_1.method_10074()) && blockPos_1.getY() < 256 - int_1 - 1) {
                this.setToDirt(modifiableTestableWorld_1, blockPos_1.method_10074());

                int int_19;
                int int_20;
                BlockPos blockPos_4;
                int int_21;
                for(int_21 = blockPos_1.getY() - 3 + int_1; int_21 <= blockPos_1.getY() + int_1; ++int_21) {
                    int_9 = int_21 - (blockPos_1.getY() + int_1);
                    int_18 = 1 - int_9 / 2;

                    for(int int_11 = blockPos_1.getX() - int_18; int_11 <= blockPos_1.getX() + int_18; ++int_11) {
                        int_19 = int_11 - blockPos_1.getX();

                        for(int_20 = blockPos_1.getZ() - int_18; int_20 <= blockPos_1.getZ() + int_18; ++int_20) {
                            int int_14 = int_20 - blockPos_1.getZ();
                            if (Math.abs(int_19) != int_18 || Math.abs(int_14) != int_18 || random_1.nextInt(2) != 0 && int_9 != 0) {
                                blockPos_4 = new BlockPos(int_11, int_21, int_20);
                                if (isAirOrLeaves(modifiableTestableWorld_1, blockPos_4) || isReplaceablePlant(modifiableTestableWorld_1, blockPos_4)) {
                                    this.setBlockState(set_1, modifiableTestableWorld_1, blockPos_4, this.leaves, blockBox_1);
                                }
                            }
                        }
                    }
                }

                for(int_21 = 0; int_21 < int_1; ++int_21) {
                    if (isAirOrLeaves(modifiableTestableWorld_1, blockPos_1.up(int_21)) || isReplaceablePlant(modifiableTestableWorld_1, blockPos_1.up(int_21))) {
                        this.setBlockState(set_1, modifiableTestableWorld_1, blockPos_1.up(int_21), this.log, blockBox_1);
                    }
                }

                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    private int getTreeHeight(Random random_1) {
        return this.height + random_1.nextInt(3);
    }

    /*private void makeCocoa(ModifiableWorld modifiableWorld_1, int int_1, BlockPos blockPos_1, Direction direction_1) {
        this.setBlockState(modifiableWorld_1, blockPos_1, Blocks.COCOA.getDefaultState().with(CocoaBlock.AGE, int_1).with(CocoaBlock.FACING, direction_1));
    }

    private void makeVine(ModifiableWorld modifiableWorld_1, BlockPos blockPos_1, BooleanProperty booleanProperty_1) {
        this.setBlockState(modifiableWorld_1, blockPos_1, Blocks.VINE.getDefaultState().with(booleanProperty_1, true));
    }

    private void makeVineColumn(ModifiableTestableWorld modifiableTestableWorld_1, BlockPos blockPos_1, BooleanProperty booleanProperty_1) {
        this.makeVine(modifiableTestableWorld_1, blockPos_1, booleanProperty_1);
        int int_1 = 4;

        for(blockPos_1 = blockPos_1.method_10074(); isAir(modifiableTestableWorld_1, blockPos_1) && int_1 > 0; --int_1) {
            this.makeVine(modifiableTestableWorld_1, blockPos_1, booleanProperty_1);
            blockPos_1 = blockPos_1.method_10074();
        }

    }*/

    protected static boolean isDirtOrGrass(TestableWorld testableWorld_1, BlockPos blockPos_1) {
        return testableWorld_1.testBlockState(blockPos_1, (blockState_1) -> {
            Block block_1 = blockState_1.getBlock();
            return block_1 == BVBlocks.SHADOW_GRASS_BLOCK || block_1 == BVBlocks.SHADOW_DIRT;
        });
    }

    protected void setToDirt(ModifiableTestableWorld modifiableTestableWorld_1, BlockPos blockPos_1) {
        if (!isNaturalDirt(modifiableTestableWorld_1, blockPos_1)) {
            this.setBlockState(modifiableTestableWorld_1, blockPos_1, BVBlocks.SHADOW_DIRT.getDefaultState());
        }
    }

    static {
        LOG = BVBlocks.SHADOW_LOG.getDefaultState();
        LEAVES = BVBlocks.SHADOW_LEAVES.getDefaultState();
    }
}
