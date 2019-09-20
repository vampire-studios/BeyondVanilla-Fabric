package io.github.vampirestudios.bv.init;

import io.github.vampirestudios.bv.BeyondVanilla;
import io.github.vampirestudios.bv.block.FlowerBlock;
import io.github.vampirestudios.bv.block.SaplingBaseBlock;
import io.github.vampirestudios.bv.block.sapling.ShadowSaplingGenerator;
import io.github.vampirestudios.vampirelib.blocks.*;
import io.github.vampirestudios.vampirelib.utils.registry.RegistryUtils;
import net.fabricmc.fabric.api.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class BVBlocks {

    public static Block SHADOW_GRASS;
    public static Block SHADOW_DIRT;
    public static Block SHADOW_STONE;
    public static Block SHADOW_LOG;
    public static Block SHADOW_WOOD;
    public static Block STRIPPED_SHADOW_LOG;
    public static Block STRIPPED_SHADOW_WOOD;
    public static Block SHADOW_PLANKS;
    public static Block SHADOW_LEAVES;
    public static Block SHADOW_SAPLING;
    public static Block SHADOW_DOOR;
    public static Block SHADOW_TRAPDOOR;
    public static Block SHADOW_SLAB;
    public static Block SHADOW_STAIR;
    public static Block SHADOW_FENCE;
    public static Block SHADOW_FENCE_GATE;
    public static Block SHADOW_PLANT;
//    public static Block SHADOW_PORTAL;

    static {
        SHADOW_GRASS = RegistryUtils.register(new Block(Block.Settings.copy(Blocks.GRASS_BLOCK)), new Identifier(BeyondVanilla.MOD_ID, "shadow_grass_block"));
        SHADOW_DIRT = RegistryUtils.register(new Block(Block.Settings.copy(Blocks.DIRT)), new Identifier(BeyondVanilla.MOD_ID, "shadow_dirt"));
        SHADOW_STONE = RegistryUtils.register(new Block(Block.Settings.copy(Blocks.STONE)), new Identifier(BeyondVanilla.MOD_ID, "shadow_stone"));
        SHADOW_LOG = RegistryUtils.register(new LogBlock(MaterialColor.BROWN, Block.Settings.copy(Blocks.OAK_LOG)), new Identifier(BeyondVanilla.MOD_ID, "shadow_log"));
        SHADOW_WOOD = RegistryUtils.register(new Block(Block.Settings.copy(Blocks.OAK_WOOD)), new Identifier(BeyondVanilla.MOD_ID, "shadow_wood"));
        STRIPPED_SHADOW_LOG = RegistryUtils.register(new LogBlock(MaterialColor.BROWN, Block.Settings.copy(Blocks.STRIPPED_OAK_LOG)),
                new Identifier(BeyondVanilla.MOD_ID, "stripped_shadow_log"));
        STRIPPED_SHADOW_WOOD = RegistryUtils.register(new Block(Block.Settings.copy(Blocks.STRIPPED_OAK_WOOD)), new Identifier(BeyondVanilla.MOD_ID, "stripped_shadow_wood"));
        SHADOW_PLANKS = RegistryUtils.register(new Block(Block.Settings.copy(Blocks.OAK_PLANKS)), new Identifier(BeyondVanilla.MOD_ID, "shadow_planks"));
        SHADOW_LEAVES = RegistryUtils.register(new LeavesBaseBlock(), new Identifier(BeyondVanilla.MOD_ID, "shadow_leaves"));
        SHADOW_SAPLING = RegistryUtils.register(new SaplingBaseBlock(new ShadowSaplingGenerator()), new Identifier(BeyondVanilla.MOD_ID, "shadow_sapling"));
        SHADOW_DOOR = RegistryUtils.register(new DoorBaseBlock(Block.Settings.copy(Blocks.OAK_DOOR)), new Identifier(BeyondVanilla.MOD_ID, "shadow_door"));
        SHADOW_TRAPDOOR = RegistryUtils.register(new TrapdoorBaseBlock(Block.Settings.copy(Blocks.OAK_TRAPDOOR)), new Identifier(BeyondVanilla.MOD_ID, "shadow_trapdoor"));

        SHADOW_SLAB = RegistryUtils.register(new SlabBaseBlock(Block.Settings.copy(Blocks.OAK_SLAB)), new Identifier(BeyondVanilla.MOD_ID, "shadow_slab"));
        SHADOW_STAIR = RegistryUtils.register(new StairsBaseBlock(SHADOW_PLANKS.getDefaultState()), new Identifier(BeyondVanilla.MOD_ID, "shadow_stairs"));
        SHADOW_FENCE = RegistryUtils.register(new FenceBaseBlock(Block.Settings.copy(Blocks.OAK_FENCE)), new Identifier(BeyondVanilla.MOD_ID, "shadow_fence"));
        SHADOW_FENCE_GATE = RegistryUtils.register(new FenceGateBaseBlock(Block.Settings.copy(Blocks.OAK_FENCE_GATE)), new Identifier(BeyondVanilla.MOD_ID, "shadow_fence_gate"));

        SHADOW_PLANT = RegistryUtils.register(new FlowerBlock(StatusEffects.GLOWING, 12, FabricBlockSettings.of(Material.PLANT).noCollision().breakInstantly()
                        .sounds(BlockSoundGroup.GRASS).build()), new Identifier(BeyondVanilla.MOD_ID, "shadow_plant"));

//        SHADOW_PORTAL = RegistryUtils.register(new ShadowPortalBlock(), new Identifier(BeyondVanilla.MOD_ID, "shadow_portal"), ItemGroup.DECORATIONS);
    }

}
