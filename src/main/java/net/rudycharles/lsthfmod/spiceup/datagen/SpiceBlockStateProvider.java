package net.rudycharles.lsthfmod.spiceup.datagen;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.rudycharles.lsthfmod.spiceup.Spiceup;
import net.rudycharles.lsthfmod.spiceup.registries.blocks.SpiceBlock;

public class SpiceBlockStateProvider extends BlockStateProvider {

    public SpiceBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, Spiceup.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        simpleBlockWithItem(SpiceBlock.SALT_BLOCK.get(),cubeAll(SpiceBlock.SALT_BLOCK.get()));
    }
}
