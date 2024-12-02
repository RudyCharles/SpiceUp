package net.rudycharles.lsthfmod.spiceup.datagen;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.rudycharles.lsthfmod.spiceup.Spiceup;
import net.rudycharles.lsthfmod.spiceup.registries.items.SpiceItem;

public class SpiceItemModelProvider extends ItemModelProvider {

    public SpiceItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Spiceup.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(SpiceItem.SALTED_MEAT.get());
        basicItem(SpiceItem.SALT.get());
    }
}
