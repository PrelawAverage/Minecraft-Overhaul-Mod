package net.prelaw.mc.util;

import net.fabricmc.fabric.api.object.builder.v1.client.model.FabricModelPredicateProviderRegistry;
import net.minecraft.util.Identifier;
import net.prelaw.mc.MinecraftOverhaul;
import net.prelaw.mc.block.ModBlocks;
import net.prelaw.mc.item.ModItems;

public class ModModelPredicateProvider {
    public static void registerModModels() {

        // This test if the player is in water, whether to make the coral_tool wet or dry. There must be a way to register this feature for all items with one Predicate, but for now it is repeated.
        FabricModelPredicateProviderRegistry.register(ModItems.CORAL_PICKAXE, new Identifier(MinecraftOverhaul.MOD_ID, "alive"),
                ((stack, world, entity, seed) -> {
                    if (entity != null && entity.isSubmergedInWater()) {
                        return 1f;
                    } else {
                        return 0f;
                    }
                }));
    }
}
