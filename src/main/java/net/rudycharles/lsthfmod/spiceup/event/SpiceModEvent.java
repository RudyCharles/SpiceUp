package net.rudycharles.lsthfmod.spiceup.event;

import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.ModifyDefaultComponentsEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeModificationEvent;
import net.neoforged.neoforge.event.entity.player.ItemTooltipEvent;
import net.rudycharles.lsthfmod.spiceup.Spiceup;
import net.rudycharles.lsthfmod.spiceup.data.SpiceDataComponent;
import net.rudycharles.lsthfmod.spiceup.registries.Spices;
import net.rudycharles.lsthfmod.spiceup.registries.attributes.SpiceAttribute;
import net.rudycharles.lsthfmod.spiceup.util.SpiceTag;

@EventBusSubscriber(modid = Spiceup.MODID, bus = EventBusSubscriber.Bus.MOD)
public class SpiceModEvent {
    @SubscribeEvent
    public static void modifyDefaultComponent(ModifyDefaultComponentsEvent event) {
        event.modify(Items.SUGAR, (builder) -> builder.set(SpiceDataComponent.STORED_SPICE.get(), Spices.SUGAR));

        event.modify(Items.HONEY_BOTTLE, (builder) -> builder.set(SpiceDataComponent.STORED_SPICE.get(), Spices.GLAZED));
        event.modify(Items.HONEY_BOTTLE, (builder) -> builder.set(DataComponents.MAX_STACK_SIZE, 64));

        event.modify(Items.FIRE_CHARGE, (builder) -> builder.set(SpiceDataComponent.STORED_SPICE.get(), Spices.FIERY));
    }

    @SubscribeEvent
    public static void attributeEvent(EntityAttributeModificationEvent event) {
        event.add(EntityType.PLAYER, SpiceAttribute.FEROCITY);
    }
}
