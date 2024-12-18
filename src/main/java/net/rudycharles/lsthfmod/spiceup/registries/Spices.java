package net.rudycharles.lsthfmod.spiceup.registries;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.rudycharles.lsthfmod.spiceup.effects.SpiceEffect;
import net.rudycharles.lsthfmod.spiceup.registries.items.SpiceItem;

import java.util.HashMap;
import java.util.Map;

public class Spices {

    public static Map<Spice, Item> MapOFSpice() {
        HashMap<Spice, Item> map = new HashMap<>();
        map.put(SALT, SpiceItem.SALT.get());
        map.put(SUGAR, Items.SUGAR);
        return map;
    }

    public static final Spice EMPTY = new Spice.Builder().build();
    public static final Spice SALT = new Spice.Builder()
            .addNutrient(1)
            .addSaturation(0)
            .addEffect(SpiceEffect.SALTY)
            .duration(400)
            .amplifier(0)
            .build();

    public static final Spice SUGAR = new Spice.Builder()
            .addNutrient(2)
            .addSaturation(2)
            .addEffect(MobEffects.MOVEMENT_SPEED)
            .addEffect(MobEffects.DIG_SPEED)
            .duration(400)
            .amplifier(0)
            .build();
}
