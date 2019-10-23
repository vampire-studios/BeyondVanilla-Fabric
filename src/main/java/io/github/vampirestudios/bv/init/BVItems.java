package io.github.vampirestudios.bv.init;

import io.github.vampirestudios.bv.BeyondVanilla;
import io.github.vampirestudios.vampirelib.utils.registry.RegistryUtils;
import net.fabricmc.fabric.api.dimension.v1.FabricDimensions;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;

public class BVItems {

    public static final Item TELEPORT_STAFF = RegistryUtils.registerItem(new Item(new Item.Settings().group(ItemGroup.MISC)) {
        @Override
        public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
            if(hand == Hand.MAIN_HAND && !world.isClient) {
                if(player.world.dimension.getType() == BeyondVanilla.THE_SHADOW) {
                    // coming from our custom dimension
                    FabricDimensions.teleport(player, DimensionType.OVERWORLD, null);
                } else {
                    // going to our custom dimension
                    FabricDimensions.teleport(player, BeyondVanilla.THE_SHADOW, null);
                }
            }

            return new TypedActionResult<>(ActionResult.SUCCESS, player.getStackInHand(hand));
        }
    }, new Identifier(BeyondVanilla.MOD_ID, "teleport_staff"));

}
