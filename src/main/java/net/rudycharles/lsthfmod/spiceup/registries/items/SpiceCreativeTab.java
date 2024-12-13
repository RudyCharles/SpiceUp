package net.rudycharles.lsthfmod.spiceup.registries.items;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.rudycharles.lsthfmod.spiceup.Spiceup;

public class SpiceCreativeTab {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Spiceup.MODID);

    public static final Holder<CreativeModeTab> SPICE_TAB =
            CREATIVE_MODE_TAB.register("spice_tab", () -> CreativeModeTab.builder()
                    .displayItems((parameters, output) -> SpiceItem.Set.forEach((item) -> output.accept(item.get())))
                    .title(Component.translatable("itemGroup.spiceup.spice_tab"))
                    .icon(() -> new ItemStack(SpiceItem.SALT.get()))
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
