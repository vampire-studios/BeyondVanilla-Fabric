package io.github.vampirestudios.bv.utils.math;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

import java.util.Arrays;

public final class Vector2f {
   private final float[] components;

   @Environment(EnvType.CLIENT)
   public Vector2f(Vector2f vector2F_1) {
      this.components = Arrays.copyOf(vector2F_1.components, 3);
   }

   public Vector2f() {
      this.components = new float[3];
   }

   @Environment(EnvType.CLIENT)
   public Vector2f(float x, float y) {
      this.components = new float[]{x, y};
   }

   public boolean equals(Object object_1) {
      if (this == object_1) {
         return true;
      } else if (object_1 != null && this.getClass() == object_1.getClass()) {
         Vector2f vector2F_1 = (Vector2f)object_1;
         return Arrays.equals(this.components, vector2F_1.components);
      } else {
         return false;
      }
   }

   public int hashCode() {
      return Arrays.hashCode(this.components);
   }

   public float getX() {
      return this.components[0];
   }

   public float getY() {
      return this.components[1];
   }

   @Environment(EnvType.CLIENT)
   public void scale(float float_1) {
      for(int int_1 = 0; int_1 < 3; ++int_1) {
         float[] var10000 = this.components;
         var10000[int_1] *= float_1;
      }

   }

   @Environment(EnvType.CLIENT)
   private static float clampFloat(float float_1, float float_2, float float_3) {
      if (float_1 < float_2) {
         return float_2;
      } else {
         return float_1 > float_3 ? float_3 : float_1;
      }
   }

   @Environment(EnvType.CLIENT)
   public void clamp(float float_1, float float_2) {
      this.components[0] = clampFloat(this.components[0], float_1, float_2);
      this.components[1] = clampFloat(this.components[1], float_1, float_2);
      this.components[2] = clampFloat(this.components[2], float_1, float_2);
   }

   public void set(float float_1, float float_2) {
      this.components[0] = float_1;
      this.components[1] = float_2;
   }

   @Environment(EnvType.CLIENT)
   public void add(float float_1, float float_2) {
      float[] var10000 = this.components;
      var10000[0] += float_1;
      var10000 = this.components;
      var10000[1] += float_2;
   }

   @Environment(EnvType.CLIENT)
   public void subtract(Vector2f vector2F_1) {
      for(int int_1 = 0; int_1 < 3; ++int_1) {
         float[] var10000 = this.components;
         var10000[int_1] -= vector2F_1.components[int_1];
      }

   }

   @Environment(EnvType.CLIENT)
   public float dot(Vector2f vector2F_1) {
      float float_1 = 0.0F;

      for(int int_1 = 0; int_1 < 3; ++int_1) {
         float_1 += this.components[int_1] * vector2F_1.components[int_1];
      }

      return float_1;
   }

   @Environment(EnvType.CLIENT)
   public void reciprocal() {
      float float_1 = 0.0F;

      int int_2;
      for(int_2 = 0; int_2 < 3; ++int_2) {
         float_1 += this.components[int_2] * this.components[int_2];
      }

      for(int_2 = 0; int_2 < 3; ++int_2) {
         float[] var10000 = this.components;
         var10000[int_2] /= float_1;
      }

   }

}
