package net.rudycharles.lsthfmod.spiceup.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.CraftingBookCategory;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.SuspiciousStewRecipe;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;
import net.rudycharles.lsthfmod.spiceup.registries.items.SpiceItem;
import net.rudycharles.lsthfmod.spiceup.registries.recipe.SpiceAddingRecipe;
import net.rudycharles.lsthfmod.spiceup.registries.recipe.SpiceRecipeSerializer;
import net.rudycharles.lsthfmod.spiceup.util.SpiceTag;

import java.util.concurrent.CompletableFuture;

import static net.rudycharles.lsthfmod.spiceup.registries.recipe.SpiceRecipeSerializer.SPICE_ADDING_SERIALIZER;

public class SpiceRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public SpiceRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, Items.MUSHROOM_STEW)
                .requires(Ingredient.of(SpiceTag.Items.SPICE),1)
                .requires(Items.MUSHROOM_STEW)
                .unlockedBy("has_salt", has(SpiceItem.SALT.get()))
                .save(recipeOutput);
        SpecialRecipeBuilder.special(SpiceAddingRecipe::new).save(recipeOutput,"adding_spice_recipe");
    }
}
