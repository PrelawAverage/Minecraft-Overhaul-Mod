package net.prelaw.mc.painting;

import net.minecraft.entity.decoration.painting.PaintingMotive;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.prelaw.mc.MinecraftOverhaul;

public class ModPaintings {

    public static final PaintingMotive NOT_ALONE = registerPainting("not_alone", new PaintingMotive(32, 16));
    public static final PaintingMotive LIFE_ABOVE_THE_SAND = registerPainting("life_above_the_sand", new PaintingMotive(48, 32));

    private static PaintingMotive registerPainting(String name, PaintingMotive paintingMotive) {
        return Registry.register(Registry.PAINTING_MOTIVE, new Identifier(MinecraftOverhaul.MOD_ID, name), paintingMotive);
    }

    public static void registerPaintings() {
        System.out.println("Registering paintings for " + MinecraftOverhaul.MOD_ID);
    }
}
