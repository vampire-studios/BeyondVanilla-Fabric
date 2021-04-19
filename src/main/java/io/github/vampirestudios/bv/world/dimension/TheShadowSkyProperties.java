package io.github.vampirestudios.bv.world.dimension;

import net.minecraft.client.render.SkyProperties;
import net.minecraft.util.math.Vec3d;

public class TheShadowSkyProperties extends SkyProperties {

	public TheShadowSkyProperties() {
		super(0.5F, false, SkyType.NORMAL, false, true);
	}

	@Override
	public float[] getFogColorOverride(float skyAngle, float tickDelta) {
		return null;
	}

	@Override
	public Vec3d adjustFogColor(Vec3d color, float sunHeight) {
		return new Vec3d(0.1, 0.1, 0.2);
	}

	@Override
	public boolean useThickFog(int camX, int camY) {
		return true;
	}
}
