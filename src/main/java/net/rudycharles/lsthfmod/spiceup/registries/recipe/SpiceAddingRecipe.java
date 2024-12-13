package net.rudycharles.lsthfmod.spiceup.registries.recipe;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.alchemy.PotionContents;
import net.minecraft.world.item.component.SuspiciousStewEffects;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import net.rudycharles.lsthfmod.spiceup.data.SpiceDataComponent;
import net.rudycharles.lsthfmod.spiceup.registries.Spices;
import net.rudycharles.lsthfmod.spiceup.util.SpiceTag;

import static net.rudycharles.lsthfmod.spiceup.registries.recipe.SpiceRecipeSerializer.SPICE_ADDING_SERIALIZER;

public class SpiceAddingRecipe extends CustomRecipe {

    public SpiceAddingRecipe(CraftingBookCategory category) {
        super(category);
    }

    @Override
    public boolean matches(CraftingInput craftingInput, Level level) {
        boolean flag1 = false;
        boolean flag2 = false;

        for (int i = 0; i < craftingInput.size(); i++) {
            ItemStack itemstack = craftingInput.getItem(i);
            if (itemstack != ItemStack.EMPTY) {
                if (itemstack.is(SpiceTag.Items.SPICE) && !flag1) {
                    flag1 = true;
                } else {
                    if (!itemstack.is(SpiceTag.Items.CONSUMABLE) || flag2) {
                        return false;
                    }

                    flag2 = true;
                }
            }
        }
        return flag1 && flag2;
    }

    @Override
    public ItemStack assemble(CraftingInput craftingInput, HolderLookup.Provider provider) {
        ItemStack itemstack = ItemStack.EMPTY;
        ItemStack spice;

        for (int i = 0; i < craftingInput.size(); i++) {
            ItemStack itemstack1 = craftingInput.getItem(i);
            if (!itemstack1.isEmpty()) {
                if (itemstack1.is(SpiceTag.Items.CONSUMABLE)) {
                    itemstack = new ItemStack(itemstack1.getItem());
                    itemstack.set(DataComponents.POTION_CONTENTS,itemstack1.getOrDefault(DataComponents.POTION_CONTENTS,PotionContents.EMPTY));
                    itemstack.set(DataComponents.SUSPICIOUS_STEW_EFFECTS,itemstack1.getOrDefault(DataComponents.SUSPICIOUS_STEW_EFFECTS, SuspiciousStewEffects.EMPTY));
                }
            }
        }

        for (int i = 0; i < craftingInput.size(); i++) {
            ItemStack itemstack1 = craftingInput.getItem(i);
            if (!itemstack1.isEmpty()) {
                if (itemstack1.is(SpiceTag.Items.SPICE)) {
                    spice = itemstack1.copy();
                    if (!(itemstack.get(SpiceDataComponent.STORED_SPICE) == itemstack1.get(SpiceDataComponent.STORED_SPICE))) {
                        itemstack.set(SpiceDataComponent.APPLIED_SPICE, spice.getOrDefault(SpiceDataComponent.STORED_SPICE, Spices.EMPTY));
                        break;
                    } else {
                        return ItemStack.EMPTY;
                    }
                }
            }
        }

        return itemstack;
    }

    @Override
    public boolean canCraftInDimensions(int width, int height) {
        return width*height >= 2;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return SPICE_ADDING_SERIALIZER.get();
    }

    @Override
    public RecipeType<?> getType() {
        return RecipeType.CRAFTING;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }
}

