package net.rudycharles.lsthfmod.spiceup.registries.recipe;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.SimpleCraftingRecipeSerializer;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.rudycharles.lsthfmod.spiceup.Spiceup;

import java.util.function.Supplier;

public class SpiceRecipeSerializer {
    public static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZERS =
            DeferredRegister.create(Registries.RECIPE_SERIALIZER, Spiceup.MODID);

    public static final Supplier<RecipeSerializer<SpiceAddingRecipe>> SPICE_ADDING_SERIALIZER =
            RECIPE_SERIALIZERS.register("spice_adding_recipe", () -> new SimpleCraftingRecipeSerializer<>(SpiceAddingRecipe::new));

    public static void register(IEventBus eventBus) {
        RECIPE_SERIALIZERS.register(eventBus);
    }
}
