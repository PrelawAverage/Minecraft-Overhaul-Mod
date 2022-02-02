package net.prelaw.mc.block.entity;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.prelaw.mc.MinecraftOverhaul;
import net.prelaw.mc.block.ModBlocks;

public class ModBlockEntities {

    public static BlockEntityType<SoulForgeEntity> SOUL_FORGE;

    public static void registerAllEntities() {

        SOUL_FORGE = Registry.register(Registry.BLOCK_ENTITY_TYPE,
                new Identifier(MinecraftOverhaul.MOD_ID, "soul_forge"),
                // This makes the chosen block a block entity
                FabricBlockEntityTypeBuilder.create(SoulForgeEntity::new,
                        ModBlocks.SOUL_FORGE).build(null));
    }
}
