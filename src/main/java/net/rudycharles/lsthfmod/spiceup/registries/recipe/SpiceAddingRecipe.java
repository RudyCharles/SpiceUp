package net.rudycharles.lsthfmod.spiceup.registries.recipe;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.component.DataComponents;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.food.Foods;
import net.minecraft.world.item.DyeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionContents;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.rudycharles.lsthfmod.spiceup.data.SpiceDataComponent;
import net.rudycharles.lsthfmod.spiceup.registries.Spices;
import net.rudycharles.lsthfmod.spiceup.registries.items.SpiceItem;
import net.rudycharles.lsthfmod.spiceup.util.SpiceTag;

import static net.rudycharles.lsthfmod.spiceup.registries.recipe.SpiceRecipeSerializer.SPICE_ADDING_SERIALIZER;
import static net.rudycharles.lsthfmod.spiceup.registries.recipe.SpiceRecipeType.SPICE_ADDING_TYPE;

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
                    if (!(itemstack.is(Items.POTION) || itemstack.has(DataComponents.FOOD)) || flag2) {
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
        ItemStack spice = ItemStack.EMPTY;

        for (int i = 0; i < craftingInput.size(); i++) {
            ItemStack itemstack1 = craftingInput.getItem(i);
            if (!itemstack1.isEmpty()) {
                if (itemstack1.is(Items.POTION) || itemstack1.has(DataComponents.FOOD)) {
                    if (!itemstack.isEmpty()) {
                        return ItemStack.EMPTY;
                    }

                    itemstack = itemstack1.copy();
                } else {
                    if (!(itemstack1.is(SpiceTag.Items.SPICE))) {
                        return ItemStack.EMPTY;
                    }

                    spice = itemstack1.copy();
                    break;
                }
            }
        }

        itemstack.set(SpiceDataComponent.STORED_SPICE, spice.getOrDefault(SpiceDataComponent.STORED_SPICE, Spices.EMPTY));
        return itemstack;
    }

    @Override
    public boolean canCraftInDimensions(int width, int height) {
        return width * height >= 2;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return SPICE_ADDING_SERIALIZER.get();
    }

    @Override
    public RecipeType<?> getType() {
        return SPICE_ADDING_TYPE.get();
    }

    @Override
    public boolean isSpecial() {
        return true;
    }
}

