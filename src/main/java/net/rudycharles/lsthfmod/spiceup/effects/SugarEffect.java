package net.rudycharles.lsthfmod.spiceup.effects;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;

public class SugarEffect extends MobEffect {
    protected SugarEffect(MobEffectCategory category) {
        super(category, 14803445);
    }

    @Override
    public boolean applyEffectTick(LivingEntity livingEntity, int amplifier) {
        return true;
    }
}
