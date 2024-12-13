package net.rudycharles.lsthfmod.spiceup.effects;

import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;

public class FieryEffect extends MobEffect {
    protected FieryEffect(MobEffectCategory category) {
        super(category, 16756600, ParticleTypes.FLAME);
    }

    @Override
    public void onEffectAdded(LivingEntity livingEntity, int amplifier) {
        super.onEffectAdded(livingEntity, amplifier);
        livingEntity.setRemainingFireTicks(600);
    }
}
