package net.rudycharles.lsthfmod.spiceup.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.rudycharles.lsthfmod.spiceup.Spiceup;
import net.rudycharles.lsthfmod.spiceup.registries.items.SpiceItem;
import net.rudycharles.lsthfmod.spiceup.util.SpiceTag;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class SpiceItemTagProvider extends ItemTagsProvider {

    public SpiceItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, CompletableFuture<TagLookup<Block>> blockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, blockTags, Spiceup.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(SpiceTag.Items.SPICE)
                .add(SpiceItem.SALT.get());
    }
}
