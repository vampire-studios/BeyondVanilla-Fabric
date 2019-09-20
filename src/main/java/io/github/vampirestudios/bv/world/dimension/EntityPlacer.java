package io.github.vampirestudios.bv.world.dimension;

import net.minecraft.block.pattern.BlockPattern;
import net.minecraft.entity.Entity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.Direction;
import net.minecraft.world.dimension.DimensionType;

/**
 * Responsible for placing an Entity once they have entered a dimension.
 * Stored by a FabricDimensionType, and used in Entity::changeDimension.
 *
 * @see FabricDimensions
 * @see FabricDimensionType
 */
@FunctionalInterface
public interface EntityPlacer {
	/**
	 * Handles the placement of an entity going to a dimension.
	 * Utilized by {@link FabricDimensions#teleport(Entity, DimensionType, EntityPlacer)} to specify placement logic when needed.
	 *
	 * <p> This method may have side effects such as the creation of a portal in the target dimension,
	 * or the creation of a chunk loading ticket.
	 *
	 * @param portalDir        the direction the portal is facing, meaningless if no portal was used
	 * @param horizontalOffset the horizontal offset of the entity relative to the front top left corner of the portal, meaningless if no portal was used
	 * @param verticalOffset   the vertical offset of the entity relative to the front top left corner of the portal, meaningless if no portal was used
	 * @return a teleportation target, or {@code null} to fall back to further handling
	 * @apiNote When this method is called, the entity's world is its source dimension.
	 */
	/* @Nullable */
	BlockPattern.TeleportTarget placeEntity(Entity teleported, ServerWorld destination, Direction portalDir, double horizontalOffset, double verticalOffset);
}