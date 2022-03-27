package net.prelaw.mc.entity.client;


import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import net.prelaw.mc.MinecraftOverhaul;
import net.prelaw.mc.entity.custom.JumboRabbitEntity;
import net.prelaw.mc.entity.custom.RedShroomiteEntity;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;


public class RedShroomiteRenderer extends GeoEntityRenderer<RedShroomiteEntity> {

    public RedShroomiteRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new RedShroomiteModel());
    }

    @Override
    public Identifier getTextureLocation(RedShroomiteEntity instance) {
        return new Identifier(MinecraftOverhaul.MOD_ID, "textures/entity/shroomites/red_shroomite.png");
    }
}
