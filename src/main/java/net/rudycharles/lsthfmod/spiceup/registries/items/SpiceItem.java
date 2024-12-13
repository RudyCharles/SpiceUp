package net.rudycharles.lsthfmod.spiceup.registries.items;

import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.food.Foods;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.alchemy.PotionContents;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.rudycharles.lsthfmod.spiceup.Spiceup;
import net.rudycharles.lsthfmod.spiceup.data.SpiceDataComponent;
import net.rudycharles.lsthfmod.spiceup.registries.Spices;
import net.rudycharles.lsthfmod.spiceup.registries.attributes.SpiceAttribute;
import net.rudycharles.lsthfmod.spiceup.registries.blocks.SpiceBlock;

import java.util.LinkedHashSet;
import java.util.function.Supplier;

import static net.neoforged.neoforge.common.util.AttributeUtil.BASE_ATTACK_DAMAGE_ID;

public class SpiceItem {
    public static LinkedHashSet<Supplier<Item>> Set = new LinkedHashSet<>();

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(Registries.ITEM, Spiceup.MODID);

    public static final Supplier<Item> SALT =
            registerWithTab("salt", () -> new Item(
                    new Item.Properties()
                            .component(SpiceDataComponent.STORED_SPICE, Spices.SALT)
            ));

    public static final Supplier<Item> TEST_SWORD =
            registerWithTab("test_sword", () -> new SwordItem(
                    Tiers.IRON,new Item.Properties()
                    .attributes(ItemAttributeModifiers.builder()
                            .add(SpiceAttribute.FEROCITY, new AttributeModifier(BASE_ATTACK_DAMAGE_ID, 5, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.HAND)
                            .build())
            ));

    public static final Supplier<Item> SALT_BLOCK =
            registerWithTab("salt_block", () -> new BlockItem(
                    SpiceBlock.SALT_BLOCK.get(), new Item.Properties()
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
