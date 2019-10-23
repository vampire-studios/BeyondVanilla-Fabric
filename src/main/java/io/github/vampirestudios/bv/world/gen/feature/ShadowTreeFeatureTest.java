//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package io.github.vampirestudios.bv.world.gen.feature;

import com.mojang.datafixers.Dynamic;
import io.github.vampirestudios.bv.init.BVBlocks;
import net.minecraft.block.Block;
import net.minecraft.class_4626;
import net.minecraft.class_4640;
import net.minecraft.util.math.BlockBox;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.ModifiableTestableWorld;
import net.minecraft.world.TestableWorld;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.chunk.ChunkGeneratorConfig;

import java.util.Optional;
import java.util.Random;
import java.util.Set;
import java.util.function.Function;

public class ShadowTreeFeatureTest extends class_4626<class_4640> {

    public ShadowTreeFeatureTest(Function<Dynamic<?>, ? extends class_4640> config) {
        super(config);
    }

    public boolean generate(ModifiableTestableWorld modifiableTestableWorld_1, Random random_1, BlockPos blockPos_1, Set<BlockPos> set_1, Set<BlockPos> set_2, BlockBox blockBox_1, class_4640 class_4640_1) {
        int int_1 = class_4640_1.field_21291 + random_1.nextInt(class_4640_1.field_21260 + 1) + random_1.nextInt(class_4640_1.field_21261 + 1);
        int int_2 = class_4640_1.field_21262 >= 0 ? class_4640_1.field_21262 + random_1.nextInt(class_4640_1.field_21263 + 1) : int_1 - (class_4640_1.field_21266 + random_1.nextInt(class_4640_1.field_21267 + 1));
        int int_3 = class_4640_1.field_21259.method_23452(random_1, int_2, int_1, class_4640_1);
        Optional<BlockPos> optional_1 = this.method_23378(modifiableTestableWorld_1, int_1, int_2, int_3, blockPos_1, class_4640_1);
        if (!optional_1.isPresent()) {
            return false;
        } else {
            BlockPos blockPos_2 = optional_1.get();
            this.setToDirt(modifiableTestableWorld_1, blockPos_2.method_10074());
            class_4640_1.field_21259.method_23448(modifiableTestableWorld_1, random_1, class_4640_1, int_1, int_2, int_3, blockPos_2, set_2);
            this.method_23379(modifiableTestableWorld_1, random_1, int_1, blockPos_2, class_4640_1.field_21264 + random_1.nextInt(class_4640_1.field_21265 + 1), set_1, blockBox_1, class_4640_1);
            return true;
        }
    }

    @Override
    public boolean generate(IWorld var1, ChunkGenerator<? extends ChunkGeneratorConfig> var2, Random var3, BlockPos var4, class_4640 var5) {
        return false;
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

}
