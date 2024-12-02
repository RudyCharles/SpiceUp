package net.rudycharles.lsthfmod.spiceup.registries.items;

import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.food.Foods;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.alchemy.PotionContents;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.rudycharles.lsthfmod.spiceup.Spiceup;
import net.rudycharles.lsthfmod.spiceup.data.SpiceDataComponent;
import net.rudycharles.lsthfmod.spiceup.registries.Spices;

import java.util.LinkedHashSet;
import java.util.function.Supplier;

public class SpiceItem {
    public static LinkedHashSet<Supplier<Item>> Set = new LinkedHashSet<>();

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(Registries.ITEM, Spiceup.MODID);

    public static final Supplier<Item> SALTED_MEAT =
            registerWithTab("salted_meat", () -> new Item(
                    new Item.Properties()
                            .food(Foods.APPLE)
                            .component(SpiceDataComponent.STORED_SPICE, Spices.EMPTY)
                            .component(DataComponents.POTION_CONTENTS, PotionContents.EMPTY)
            ));

    public static final Supplier<Item> SALT =
            registerWithTab("salt", () -> new Item(
                    new Item.Properties()
                            .component(SpiceDataComponent.STORED_SPICE, Spices.SALT)
            ));

    public static Supplier<Item> registerWithTab(String name, Supplier<Item> supplier) {
        Supplier<Item> ModItem = ITEMS.register(name,supplier);
        Set.add(ModItem);
        return ModItem;
    }

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}