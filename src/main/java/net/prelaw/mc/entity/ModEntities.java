package net.prelaw.mc.entity;


import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.prelaw.mc.MinecraftOverhaul;
import net.prelaw.mc.entity.custom.JumboRabbitEntity;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModEntities {
    public static final EntityType<JumboRabbitEntity> JUMBO = Registry.register(
            Registry.ENTITY_TYPE, new Identifier(MinecraftOverhaul.MOD_ID, "raccoon"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, JumboRabbitEntity::new)
                    .dimensions(EntityDimensions.fixed(0.4f, 0.3f)).build());
}
