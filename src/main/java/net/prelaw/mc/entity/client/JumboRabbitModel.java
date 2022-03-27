package net.prelaw.mc.entity.client;

import net.minecraft.util.Identifier;
import net.prelaw.mc.MinecraftOverhaul;
import net.prelaw.mc.entity.custom.JumboRabbitEntity;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class JumboRabbitModel extends AnimatedGeoModel<JumboRabbitEntity> {
    @Override
    public Identifier getModelLocation(JumboRabbitEntity entity) {
        return new Identifier(MinecraftOverhaul.MOD_ID, "geo/jumbo.geo.json");
    }

    @Override
    public Identifier getTextureLocation(JumboRabbitEntity entity) {
        return JumboRabbitRenderer.LOCATION_BY_VARIANT.get(entity.getVariant());
    }

    @Override
    public Identifier getAnimationFileLocation(JumboRabbitEntity entity) {
        return new Identifier(MinecraftOverhaul.MOD_ID, "animations/jumbo.animation.json");
    }
}
