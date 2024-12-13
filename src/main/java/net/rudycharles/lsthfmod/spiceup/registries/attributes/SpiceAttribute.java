package net.rudycharles.lsthfmod.spiceup.registries.attributes;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.RangedAttribute;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.rudycharles.lsthfmod.spiceup.Spiceup;

public class SpiceAttribute {
    public static final DeferredRegister<Attribute> ATTRIBUTE =
            DeferredRegister.create(Registries.ATTRIBUTE, Spiceup.MODID);

    public static final Holder<Attribute> FEROCITY =
            ATTRIBUTE.register("ferocity", () ->
                    new RangedAttribute("generic.ferocity",1,0,Double.MAX_VALUE));

    public static void register(IEventBus eventBus) {
        ATTRIBUTE.register(eventBus);
    }
}
