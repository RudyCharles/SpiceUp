package net.rudycharles.lsthfmod.spiceup.registries.recipe;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.crafting.CraftingBookCategory;
import net.minecraft.world.item.crafting.RecipeSerializer;

public class SpiceSerializer implements RecipeSerializer<SpiceAddingRecipe> {
    public static final MapCodec<SpiceAddingRecipe> CODEC = RecordCodecBuilder.mapCodec(inst -> inst.group(
            CraftingBookCategory.CODEC.fieldOf("catagory").forGetter(SpiceAddingRecipe::category)
    ).apply(inst, SpiceAddingRecipe::new));

    public static final StreamCodec<RegistryFriendlyByteBuf, SpiceAddingRecipe> STREAM_CODEC =
            StreamCodec.composite(
                    CraftingBookCategory.STREAM_CODEC, SpiceAddingRecipe::category,
                    SpiceAddingRecipe::new
            );

    @Override
    public MapCodec<SpiceAddingRecipe> codec() {
        return CODEC;
    }

    @Override
    public StreamCodec<RegistryFriendlyByteBuf,SpiceAddingRecipe> streamCodec() {
        return STREAM_CODEC;
    }
}
