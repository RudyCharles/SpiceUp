package net.rudycharles.lsthfmod.spiceup.event;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.ModifyDefaultComponentsEvent;
import net.neoforged.neoforge.event.entity.player.ItemTooltipEvent;
import net.rudycharles.lsthfmod.spiceup.Spiceup;
import net.rudycharles.lsthfmod.spiceup.data.SpiceDataComponent;
import net.rudycharles.lsthfmod.spiceup.registries.Spices;
import net.rudycharles.lsthfmod.spiceup.util.SpiceTag;

@EventBusSubscriber(modid = Spiceup.MODID, bus = EventBusSubscriber.Bus.MOD)
public class SpiceModEvent {
    @SubscribeEvent
    public static void modifyDefaultComponent(ModifyDefaultComponentsEvent event) {
        event.modify(Items.SUGAR, (builder) -> builder.set(SpiceDataComponent.STORED_SPICE.get(), Spices.SUGAR));
    }
}
