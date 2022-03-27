package net.prelaw.mc.entity.client;

import net.minecraft.util.Identifier;
import net.prelaw.mc.MinecraftOverhaul;
import net.prelaw.mc.entity.custom.JollyLlamaEntity;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class JollyLlamaModel extends AnimatedGeoModel<JollyLlamaEntity> {
    @Override
    public Identifier getModelLocation(JollyLlamaEntity entity) {
        return new Identifier(MinecraftOverhaul.MOD_ID, "geo/jolly_llama.geo.json");
    }

    @Override
    public Identifier getTextureLocation(JollyLlamaEntity entity) {
        return new Identifier(MinecraftOverhaul.MOD_ID, "textures/entity/jolly/jolly_llama.png");
    }

    @Override
    public Identifier getAnimationFileLocation(JollyLlamaEntity entity) {
        return new Identifier(MinecraftOverhaul.MOD_ID, "animations/jolly_llama.animation.json");
    }
}
