package net.prelaw.mc.entity.client;


import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import net.prelaw.mc.MinecraftOverhaul;
import net.prelaw.mc.entity.custom.JollyLlamaEntity;
import net.prelaw.mc.entity.custom.JumboRabbitEntity;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;


public class JollyLlamaRenderer extends GeoEntityRenderer<JollyLlamaEntity> {

    public JollyLlamaRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new JollyLlamaModel());
    }

    @Override
    public Identifier getTextureLocation(JollyLlamaEntity instance) {
        return new Identifier(MinecraftOverhaul.MOD_ID, "textures/entity/jolly/jolly_llama.png");
    }
}
