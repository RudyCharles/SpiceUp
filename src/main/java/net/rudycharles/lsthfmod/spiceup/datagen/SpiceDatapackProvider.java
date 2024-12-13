package net.rudycharles.lsthfmod.spiceup.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import net.rudycharles.lsthfmod.spiceup.Spiceup;
import net.rudycharles.lsthfmod.spiceup.worldgen.SpiceBiomeModifier;
import net.rudycharles.lsthfmod.spiceup.worldgen.SpiceConfiguredFeature;
import net.rudycharles.lsthfmod.spiceup.worldgen.SpicePlacedFeature;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class SpiceDatapackProvider extends DatapackBuiltinEntriesProvider {

    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.CONFIGURED_FEATURE, SpiceConfiguredFeature::bootstrap)
            .add(Registries.PLACED_FEATURE, SpicePlacedFeature::bootstrap)
            .add(NeoForgeRegistries.Keys.BIOME_MODIFIERS, SpiceBiomeModifier::bootstrap);

    public SpiceDatapackProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BUILDER, Set.of(Spiceup.MODID));
    }
}
