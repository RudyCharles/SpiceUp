package net.rudycharles.lsthfmod.spiceup.event;

import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingEntityUseItemEvent;
import net.rudycharles.lsthfmod.spiceup.Spiceup;
import net.rudycharles.lsthfmod.spiceup.data.SpiceDataComponent;
import net.rudycharles.lsthfmod.spiceup.registries.Spice;
import net.rudycharles.lsthfmod.spiceup.registries.Spices;

@EventBusSubscriber(modid = Spiceup.MODID, bus = EventBusSubscriber.Bus.GAME)
public class ModEvent {
    @SubscribeEvent
    public static void addSpiceEffect(LivingEntityUseItemEvent.Finish event) {
        LivingEntity livingEntity = event.getEntity();
        ItemStack usedItem = event.getEntity().getUseItem();
        Spice storedSpice = usedItem.getOrDefault(SpiceDataComponent.STORED_SPICE, Spices.EMPTY);

        if (storedSpice != Spices.EMPTY) {
            if (livingEntity instanceof Player player) {
                if (usedItem.getItem() == Items.POTION) {
                    player.sendSystemMessage(Component.literal("This logic works!"));
                } else {
                    for (MobEffectInstance mobEffectInstance: storedSpice.addEffect()) {
                        player.addEffect(mobEffectInstance);
                    }
                    player.getFoodData().eat(storedSpice.addNut(),storedSpice.addSat());
                    player.sendSystemMessage(Component.literal("This logic works!"));
                }
            }
        }

    }
}