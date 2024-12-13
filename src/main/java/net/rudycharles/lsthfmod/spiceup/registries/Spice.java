package net.rudycharles.lsthfmod.spiceup.registries;

import com.google.common.collect.ImmutableList;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.netty.buffer.ByteBuf;
import net.minecraft.core.Holder;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.util.Mth;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.PotionContents;

import java.util.List;
import java.util.Optional;

public record Spice(int addNut, float addSat, List<Holder<MobEffect>> addEffect, int duration, int amplifier) {

    public Spice(int addNut, float addSat, List<Holder<MobEffect>> addEffect, int duration, int amplifier) {
        this.addNut = addNut;
        this.addSat = addSat;
        this.addEffect = addEffect;
        this.duration = duration;
        this.amplifier = Mth.clamp(amplifier, 0, 255);
    }

    public static final Codec<Spice> DIRECT_CODEC = RecordCodecBuilder.create(
            spiceInstance -> spiceInstance.group(
                    Codec.INT.fieldOf("nutrient").forGetter(Spice::addNut),
                    Codec.FLOAT.fieldOf("saturation").forGetter(Spice::addSat),
                    MobEffect.CODEC.listOf().fieldOf("list").forGetter(Spice::addEffect),
                    Codec.INT.fieldOf("duration").forGetter(Spice::duration),
                    Codec.INT.fieldOf("amplifier").forGetter(Spice::amplifier)
            ).apply(spiceInstance, Spice::new)
    );
    public static final StreamCodec<RegistryFriendlyByteBuf, Spice> DIRECT_STREAM_CODEC =
            StreamCodec.composite(
                    ByteBufCodecs.VAR_INT, Spice::addNut,
                    ByteBufCodecs.FLOAT, Spice::addSat,
                    MobEffect.STREAM_CODEC.apply(ByteBufCodecs.list()), Spice::addEffect,
                    ByteBufCodecs.VAR_INT, Spice::duration,
                    ByteBufCodecs.VAR_INT, Spice::amplifier,
                    Spice::new
            );

    @Override
    public String toString() {
        return "";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        } else if (!(obj instanceof Spice)) {
            return false;
        } else {
            Spice other = (Spice) obj;
            if (this.addNut == other.addNut &&
                    this.addSat == other.addSat &&
                    this.addEffect.equals(other.addEffect) &&
                    this.duration == other.duration &&
                    this.amplifier == other.amplifier) {
                return true;
            } else {
                return false;
            }
        }
    }

    public static class Builder {
        private int nutrition;
        private float saturation;
        private int duration;
        private int amplifier;
        private final ImmutableList.Builder<Holder<MobEffect>> mobEffect = ImmutableList.builder();

        public Builder() {}

        public Builder addNutrient(int nutrient) {
            this.nutrition = nutrient;
            return this;
        }

        public Builder addSaturation(float addSaturation) {
            this.saturation = addSaturation;
            return this;
        }

        public Builder duration(int duration) {
            this.duration = duration;
            return this;
        }

        public Builder amplifier(int amplifier) {
            this.amplifier = amplifier;
            return this;
        }

        public Builder addEffect (Holder<MobEffect> addEffect) {
            this.mobEffect.add(addEffect);
            return this;
        }

        public Spice build() {
            return new Spice(this.nutrition,this.saturation,this.mobEffect.build(),this.duration,this.amplifier);
        }
    }
}
