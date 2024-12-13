package net.rudycharles.lsthfmod.spiceup.effects;

import net.minecraft.core.Holder;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.rudycharles.lsthfmod.spiceup.Spiceup;
import net.rudycharles.lsthfmod.spiceup.registries.attributes.SpiceAttribute;

import java.util.function.Supplier;

public class SpiceEffect {
    public static final DeferredRegister<MobEffect> MOB_EFFECT =
            DeferredRegister.create(Registries.MOB_EFFECT, Spiceup.MODID);

    public static final Holder<MobEffect> SALTY =
            MOB_EFFECT.register("salty_effect", () -> new SaltyEffect(MobEffectCategory.BENEFICIAL,ParticleTypes.EFFECT)
                    .addAttributeModifier(Attributes.ATTACK_SPEED, ResourceLocation.fromNamespaceAndPath(Spiceup.MODID,"salty_spd"), -0.10f, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
            );

    public static final Holder<MobEffect> SUGAR_RUSH =
            MOB_EFFECT.register("sugar_effect", () -> new SugarEffect(MobEffectCategory.BENEFICIAL)
                    .addAttributeModifier(Attributes.MOVEMENT_SPEED, ResourceLocation.fromNamespaceAndPath(Spiceup.MODID,"sweet_mov"), 0.35f, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
                    .addAttributeModifier(Attributes.BLOCK_BREAK_SPEED, ResourceLocation.fromNamespaceAndPath(Spiceup.MODID,"sweet_haste"), 0.15f, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
            );

    public static final Holder<MobEffect> FIERY_SPIRIT =
            MOB_EFFECT.register("fiery_effect", () -> new FieryEffect(MobEffectCategory.BENEFICIAL)
                    .addAttributeModifier(SpiceAttribute.FEROCITY, ResourceLocation.fromNamespaceAndPath(Spiceup.MODID,"spicy_fero"), 0.7f, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
            );

    public static void register(IEventBus eventBus) {
        MOB_EFFECT.register(eventBus);
    }
}
