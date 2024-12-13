package net.rudycharles.lsthfmod.spiceup.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.item.Items;
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
                .add(SpiceItem.SALT.get())
                .add(Items.SUGAR)
                .add(Items.FIRE_CHARGE)
                .add(Items.HONEY_BOTTLE);

        tag(SpiceTag.Items.CONSUMABLE)
                .add(Items.APPLE)
                .add(Items.GOLDEN_APPLE)
                .add(Items.ENCHANTED_GOLDEN_APPLE)
                .add(Items.MELON_SLICE)
                .add(Items.SWEET_BERRIES)
                .add(Items.GLOW_BERRIES)
                .add(Items.GLOW_BERRIES)
                .add(Items.CHORUS_FRUIT)
                .add(Items.CARROT)
                .add(Items.GOLDEN_CARROT)
                .add(Items.POTATO)
                .add(Items.BAKED_POTATO)
                .add(Items.POISONOUS_POTATO)
                .add(Items.BEETROOT)
                .add(Items.DRIED_KELP)
                .add(Items.BEEF)
                .add(Items.COOKED_BEEF)
                .add(Items.PORKCHOP)
                .add(Items.COOKED_PORKCHOP)
                .add(Items.MUTTON)
                .add(Items.COOKED_MUTTON)
                .add(Items.CHICKEN)
                .add(Items.COOKED_CHICKEN)
                .add(Items.RABBIT)
                .add(Items.COOKED_RABBIT)
                .add(Items.COD)
                .add(Items.COOKED_COD)
                .add(Items.SALMON)
                .add(Items.COOKED_SALMON)
                .add(Items.TROPICAL_FISH)
                .add(Items.PUFFERFISH)
                .add(Items.BREAD)
                .add(Items.COOKIE)
                .add(Items.PUMPKIN_PIE)
                .add(Items.ROTTEN_FLESH)
                .add(Items.SPIDER_EYE)
                .add(Items.MUSHROOM_STEW)
                .add(Items.BEETROOT_SOUP)
                .add(Items.RABBIT_STEW)
                .add(Items.MILK_BUCKET)
                .add(Items.HONEY_BOTTLE)
                .add(Items.POTION);

    }
}
