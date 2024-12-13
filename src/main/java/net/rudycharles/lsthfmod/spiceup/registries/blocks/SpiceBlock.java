package net.rudycharles.lsthfmod.spiceup.registries.blocks;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.rudycharles.lsthfmod.spiceup.Spiceup;

import java.util.function.Supplier;

public class SpiceBlock {
    public static final DeferredRegister<Block> BLOCK =
            DeferredRegister.create(Registries.BLOCK, Spiceup.MODID);

    public static final Supplier<Block> SALT_BLOCK =
            BLOCK.register("salt_block", () -> new Block(
                    BlockBehaviour.Properties.of()
                            .strength(1.5F, 6.0F).sound(SoundType.STONE).requiresCorrectToolForDrops()
            ));

    public static void register(IEventBus eventBus) {
        BLOCK.register(eventBus);
    }
}
