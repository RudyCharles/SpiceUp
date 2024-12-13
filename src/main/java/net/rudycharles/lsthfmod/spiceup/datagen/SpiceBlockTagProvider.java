package net.rudycharles.lsthfmod.spiceup.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.rudycharles.lsthfmod.spiceup.Spiceup;
import net.rudycharles.lsthfmod.spiceup.registries.blocks.SpiceBlock;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class SpiceBlockTagProvider extends BlockTagsProvider {
    public SpiceBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, Spiceup.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(BlockTags.INCORRECT_FOR_WOODEN_TOOL)
                .add(SpiceBlock.SALT_BLOCK.get());

        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(SpiceBlock.SALT_BLOCK.get());
    }
}
