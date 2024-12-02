package net.rudycharles.lsthfmod.spiceup.registries;

import com.google.common.collect.ImmutableList;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.netty.buffer.ByteBuf;
import net.minecraft.core.Holder;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.PotionContents;

import java.util.List;
import java.util.Optional;

public record Spice(int addNut, float addSat, List<MobEffectInstance> addEffect) {

    public Spice(int addNut, float addSat, List<MobEffectInstance> addEffect) {
        this.addNut = addNut;
        this.addSat = addSat;
        this.addEffect = addEffect;
    }

    public static final Codec<Spice> DIRECT_CODEC = RecordCodecBuilder.create(
            spiceInstance -> spiceInstance.group(
                    Codec.INT.fieldOf("nutrient").forGetter(Spice::addNut),
                    Codec.FLOAT.fieldOf("saturation").forGetter(Spice::addSat),
                    MobEffectInstance.CODEC.listOf().fieldOf("list").forGetter(Spice::addEffect)
            ).apply(spiceInstance, Spice::new)
    );
    public static final StreamCodec<RegistryFriendlyByteBuf, Spice> DIRECT_STREAM_CODEC =
            StreamCodec.composite(
                    ByteBufCodecs.VAR_INT, Spice::addNut,
                    ByteBufCodecs.FLOAT, Spice::addSat,
                    MobEffectInstance.STREAM_CODEC.apply(ByteBufCodecs.list()), Spice::addEffect,
                    Spice::new
            );

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        } else if (!(obj instanceof Spice)) {
            return false;
        } else {
            Spice other = (Spice) obj;
            if (this.addNut == other.addNut && this.addSat == other.addSat && this.addEffect.equals(other.addEffect)) {
                return true;
            } else {
                return false;
            }
        }
    }

    public static class Builder {
        private int nutrition;
        private float saturation;
        private final ImmutableList.Builder<MobEffectInstance> mobEffect = ImmutableList.builder();

        public Builder() {}

        public Builder addNutrient(int nutrient) {
            this.nutrition = nutrient;
            return this;
        }

        public Builder addSaturation(float addSaturation) {
            this.saturation = addSaturation;
            return this;
        }

        public Builder addEffect (MobEffectInstance addEffect) {
            this.mobEffect.add(addEffect);
            return this;
        }

        public Spice build() {
            return new Spice(this.nutrition,this.saturation,this.mobEffect.build());
        }
    }
}
