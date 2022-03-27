package net.prelaw.mc.entity.client;




import com.google.common.collect.Maps;
import net.prelaw.mc.MinecraftOverhaul;
import net.prelaw.mc.entity.custom.JumboRabbitEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import net.prelaw.mc.entity.variants.JumboVariant;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

import java.util.Map;


public class JumboRabbitRenderer extends GeoEntityRenderer<JumboRabbitEntity> {

    // This just handles the mob variants we gave it. We "map" JumboVariant to Identifier (find the texture).
    public static final Map<JumboVariant, Identifier> LOCATION_BY_VARIANT =
            Util.make(Maps.newEnumMap(JumboVariant.class), (map) -> {
                map.put(JumboVariant.DEFAULT,
                        new Identifier(MinecraftOverhaul.MOD_ID, "textures/entity/jumbo/jumbo_rabbit.png"));
                map.put(JumboVariant.YELLOW,
                        new Identifier(MinecraftOverhaul.MOD_ID, "textures/entity/jumbo/yellow_jumbo_rabbit.png"));
                map.put(JumboVariant.BLUE,
                        new Identifier(MinecraftOverhaul.MOD_ID, "textures/entity/jumbo/blue_jumbo_rabbit.png"));
            });

    public JumboRabbitRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new JumboRabbitModel());
    }

    @Override
    public Identifier getTextureLocation(JumboRabbitEntity entity) {
        return LOCATION_BY_VARIANT.get(entity.getVariant());
    }
}
