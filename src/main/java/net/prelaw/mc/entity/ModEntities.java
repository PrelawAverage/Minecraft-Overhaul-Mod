package net.prelaw.mc.entity;


import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.prelaw.mc.MinecraftOverhaul;
import net.prelaw.mc.entity.custom.JollyLlamaEntity;
import net.prelaw.mc.entity.custom.JumboRabbitEntity;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.prelaw.mc.entity.custom.RedShroomiteEntity;

public class ModEntities {
    public static final EntityType<JumboRabbitEntity> JUMBO = Registry.register(
            Registry.ENTITY_TYPE, new Identifier(MinecraftOverhaul.MOD_ID, "jumbo"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, JumboRabbitEntity::new)
                    .dimensions(EntityDimensions.fixed(0.6f, 0.5f)).build());
    public static final EntityType<RedShroomiteEntity> RED_SHROOM = Registry.register(
            Registry.ENTITY_TYPE, new Identifier(MinecraftOverhaul.MOD_ID, "red_shroomite"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, RedShroomiteEntity::new)
                    .dimensions(EntityDimensions.fixed(0.4f, 0.3f)).build());
    public static final EntityType<JollyLlamaEntity> JOLLY_LLAMA = Registry.register(
            Registry.ENTITY_TYPE, new Identifier(MinecraftOverhaul.MOD_ID, "jolly_llama"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, JollyLlamaEntity::new)
                    .dimensions(EntityDimensions.fixed(1f, 1f)).build());
}
