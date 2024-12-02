package net.rudycharles.lsthfmod.spiceup.registries.recipe;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.SimpleCraftingRecipeSerializer;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.rudycharles.lsthfmod.spiceup.Spiceup;

import java.util.function.Supplier;

public class SpiceRecipeType {
    public static final DeferredRegister<RecipeType<?>> RECIPE_TYPE =
            DeferredRegister.create(Registries.RECIPE_TYPE, Spiceup.MODID);

    public static final Supplier<RecipeType<SpiceAddingRecipe>> SPICE_ADDING_TYPE =
            RECIPE_TYPE.register("spice_adding", registryName -> new RecipeType<SpiceAddingRecipe>() {
                @Override
                public String toString() {
                    return registryName.toString();
                }
            });

    public static void register(IEventBus eventBus) {
        RECIPE_TYPE.register(eventBus);
    }
}
