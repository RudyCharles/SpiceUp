package net.rudycharles.lsthfmod.spiceup.util;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.rudycharles.lsthfmod.spiceup.Spiceup;

public class SpiceTag {
    public static class Items {
        public static final TagKey<Item> SPICE = createTag("spice");
        public static final TagKey<Item> CONSUMABLE = createTag("consumable");

        private static TagKey<Item> createTag(String name) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(Spiceup.MODID,name));
        }
    }


}
