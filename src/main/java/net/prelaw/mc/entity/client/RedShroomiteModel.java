package net.prelaw.mc.entity.client;

import net.minecraft.util.Identifier;
import net.prelaw.mc.MinecraftOverhaul;
import net.prelaw.mc.entity.custom.JumboRabbitEntity;
import net.prelaw.mc.entity.custom.RedShroomiteEntity;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class RedShroomiteModel extends AnimatedGeoModel<RedShroomiteEntity> {
    @Override
    public Identifier getModelLocation(RedShroomiteEntity entity) {
        return new Identifier(MinecraftOverhaul.MOD_ID, "geo/red_shroomite.geo.json");
    }

    @Override
    public Identifier getTextureLocation(RedShroomiteEntity entity) {
        return new Identifier(MinecraftOverhaul.MOD_ID, "textures/entity/shroomites/red_shroomite.png");
    }

    @Override
    public Identifier getAnimationFileLocation(RedShroomiteEntity entity) {
        return new Identifier(MinecraftOverhaul.MOD_ID, "animations/red_shroomite.animation.json");
    }
}
