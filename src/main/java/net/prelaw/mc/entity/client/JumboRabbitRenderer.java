package net.prelaw.mc.entity.client;


import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import net.prelaw.mc.MinecraftOverhaul;
import net.prelaw.mc.entity.custom.JumboRabbitEntity;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;


public class JumboRabbitRenderer extends GeoEntityRenderer<JumboRabbitEntity> {

    public JumboRabbitRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new JumboRabbitModel());
    }

    @Override
    public Identifier getTextureLocation(JumboRabbitEntity instance) {
        return new Identifier(MinecraftOverhaul.MOD_ID, "textures/entity/jumbo/jumbo_rabbit.png");
    }
}
