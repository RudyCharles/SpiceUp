package net.rudycharles.lsthfmod.spiceup.registries;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;

public class Spices {
    public static final Spice EMPTY = new Spice.Builder().build();
    public static final Spice SALT = new Spice.Builder()
            .addNutrient(3)
            .addSaturation(0)
            .addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED,300,4))
            .build();
}
