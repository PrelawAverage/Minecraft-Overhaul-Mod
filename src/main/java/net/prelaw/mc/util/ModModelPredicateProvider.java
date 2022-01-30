package net.prelaw.mc.util;

import net.fabricmc.fabric.api.object.builder.v1.client.model.FabricModelPredicateProviderRegistry;
import net.minecraft.util.Identifier;
import net.prelaw.mc.MinecraftOverhaul;
import net.prelaw.mc.block.ModBlocks;
import net.prelaw.mc.item.ModItems;

public class ModModelPredicateProvider {
    public static void registerModModels() {

        // This test if the player is in water, whether to make the coral_tool wet or dry. There must be a way to register this feature for all items with one Predicate, but for now it is repeated.
        // Change from Pickaxe to tag
        FabricModelPredicateProviderRegistry.register(ModItems.CORAL_AXE, new Identifier(MinecraftOverhaul.MOD_ID, "alive"),
                ((stack, world, entity, seed) -> {
                    if (entity != null && entity.isSubmergedInWater()) {
                        return 1f;
                    } else {
                        return 0f;
                    }
                }));
        FabricModelPredicateProviderRegistry.register(ModItems.CORAL_PICKAXE, new Identifier(MinecraftOverhaul.MOD_ID, "alive"),
                ((stack, world, entity, seed) -> {
                    if (entity != null && entity.isSubmergedInWater()) {
                        return 1f;
                    } else {
                        return 0f;
                    }
                }));
        FabricModelPredicateProviderRegistry.register(ModItems.CORAL_HOE, new Identifier(MinecraftOverhaul.MOD_ID, "alive"),
                ((stack, world, entity, seed) -> {
                    if (entity != null && entity.isSubmergedInWater()) {
                        return 1f;
                    } else {
                        return 0f;
                    }
                }));
        FabricModelPredicateProviderRegistry.register(ModItems.CORAL_SWORD, new Identifier(MinecraftOverhaul.MOD_ID, "alive"),
                ((stack, world, entity, seed) -> {
                    if (entity != null && entity.isSubmergedInWater()) {
                        return 1f;
                    } else {
                        return 0f;
                    }
                }));
        FabricModelPredicateProviderRegistry.register(ModItems.CORAL_SHOVEL, new Identifier(MinecraftOverhaul.MOD_ID, "alive"),
                ((stack, world, entity, seed) -> {
                    if (entity != null && entity.isSubmergedInWater()) {
                        return 1f;
                    } else {
                        return 0f;
                    }
                }));

        // Registering my bow
        registerBow(ModItems.SHORT_BOW);
    }

    // Bow Method
    private static void registerBow(Item bow) {
        FabricModelPredicateProviderRegistry.register(bow, new Identifier("pull"),
                (stack, world, entity, seed) -> {
                    if (entity == null) {
                        return 0.0f;
                    }
                    if (entity.getActiveItem() != stack) {
                        return 0.0f;
                    }
                    return (float)(stack.getMaxUseTime() - entity.getItemUseTimeLeft()) / 20.0f;
                });

        FabricModelPredicateProviderRegistry.register(bow, new Identifier("pulling"), (stack, world, entity, seed) -> entity != null && entity.isUsingItem() && entity.getActiveItem() == stack ? 1.0f : 0.0f);
    }

}
