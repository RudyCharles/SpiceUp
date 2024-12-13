package net.rudycharles.lsthfmod.spiceup.event;

import net.minecraft.ChatFormatting;
import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageSources;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.effects.DamageEntity;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RenderTooltipEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeModificationEvent;
import net.neoforged.neoforge.event.entity.EntityEvent;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;
import net.neoforged.neoforge.event.entity.living.LivingEntityUseItemEvent;
import net.neoforged.neoforge.event.entity.living.LivingEvent;
import net.neoforged.neoforge.event.entity.player.ItemTooltipEvent;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.rudycharles.lsthfmod.spiceup.Spiceup;
import net.rudycharles.lsthfmod.spiceup.data.SpiceDataComponent;
import net.rudycharles.lsthfmod.spiceup.registries.Spice;
import net.rudycharles.lsthfmod.spiceup.registries.Spices;
import net.rudycharles.lsthfmod.spiceup.registries.attributes.SpiceAttribute;
import net.rudycharles.lsthfmod.spiceup.util.SpiceTag;

import java.util.Objects;

@EventBusSubscriber(modid = Spiceup.MODID, bus = EventBusSubscriber.Bus.GAME)
public class ModEvent {
    @SubscribeEvent
    public static void addSpiceEffect(LivingEntityUseItemEvent.Finish event) {
        LivingEntity livingEntity = event.getEntity();
        ItemStack usedItem = event.getEntity().getUseItem();
        Spice storedSpice = usedItem.getOrDefault(SpiceDataComponent.APPLIED_SPICE, Spices.EMPTY);

        if (storedSpice != Spices.EMPTY) {
            if (livingEntity instanceof Player player) {
                storedSpice.eating(storedSpice,player);
            }
        }
    }

    @SubscribeEvent
    public static void modifyTooltip(ItemTooltipEvent event) {
        ItemStack stack = event.getItemStack();
        if (stack.is(SpiceTag.Items.CONSUMABLE) && stack.has(SpiceDataComponent.APPLIED_SPICE)) {
            Spice spice = stack.get(SpiceDataComponent.APPLIED_SPICE);
            event.getToolTip().add(Component.translatable("tooltip.seasoned").withStyle(ChatFormatting.GRAY));
            event.getToolTip().add(Component.translatable(Spices.MapOFSpice().get(spice).getDescriptionId()).withStyle(ChatFormatting.DARK_GRAY));
        }
    }

    @SubscribeEvent
    public static void ferocityEvent(LivingDamageEvent.Post event) {
        Entity target = event.getEntity();
        Entity source = event.getEntity().getLastAttacker();
        if (source instanceof Player livingSource) {
            double chance = livingSource.getAttribute(SpiceAttribute.FEROCITY).getValue();
            double i = Math.random();
            if (i < (chance - Math.floor(chance))) {
                for (int j=0;j<Math.ceil(chance);j++) {
                    target.hurt(target.damageSources().indirectMagic(livingSource,target),event.getOriginalDamage());
                }
            }
        }

    }
}
