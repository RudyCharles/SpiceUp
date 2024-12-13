package net.rudycharles.lsthfmod.spiceup.event;

import net.minecraft.ChatFormatting;
import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RenderTooltipEvent;
import net.neoforged.neoforge.event.entity.living.LivingEntityUseItemEvent;
import net.neoforged.neoforge.event.entity.player.ItemTooltipEvent;
import net.rudycharles.lsthfmod.spiceup.Spiceup;
import net.rudycharles.lsthfmod.spiceup.data.SpiceDataComponent;
import net.rudycharles.lsthfmod.spiceup.registries.Spice;
import net.rudycharles.lsthfmod.spiceup.registries.Spices;
import net.rudycharles.lsthfmod.spiceup.util.SpiceTag;

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
                    for (Holder<MobEffect> mobEffectHolder: storedSpice.addEffect()) {
                        livingEntity.addEffect(new MobEffectInstance(mobEffectHolder,storedSpice.duration(),storedSpice.amplifier()));
                    }
                } else {
                    for (Holder<MobEffect> mobEffectHolder: storedSpice.addEffect()) {
                        livingEntity.addEffect(new MobEffectInstance(mobEffectHolder,storedSpice.duration(),storedSpice.amplifier()));
                    }
                    player.getFoodData().eat(storedSpice.addNut(),storedSpice.addSat());
                }
            }
        }

    }

    @SubscribeEvent
    public static void modifyTooltip(ItemTooltipEvent event) {
        ItemStack stack = event.getItemStack();
        if (stack.is(SpiceTag.Items.CONSUMABLE) && stack.has(SpiceDataComponent.STORED_SPICE)) {
            Spice spice = stack.get(SpiceDataComponent.STORED_SPICE);
            event.getToolTip().add(Component.translatable("tooltip.seasoned").withStyle(ChatFormatting.GRAY));
            event.getToolTip().add(Component.translatable(Spices.MapOFSpice().get(spice).getDescriptionId()).withStyle(ChatFormatting.GRAY));
        }
    }
}