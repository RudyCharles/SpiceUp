package net.rudycharles.lsthfmod.spiceup.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;
import net.rudycharles.lsthfmod.spiceup.registries.recipe.SpiceAddingRecipe;

import java.util.concurrent.CompletableFuture;


public class SpiceRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public SpiceRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {
        SpecialRecipeBuilder.special(SpiceAddingRecipe::new).save(recipeOutput,"adding_spice_recipe");
    }
}
