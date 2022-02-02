package net.prelaw.mc.screen;

import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.prelaw.mc.MinecraftOverhaul;

public class ModScreenHandlers {
    public static ScreenHandlerType<SoulForgeScreenHandler> SOUL_FORGE_SCREEN_HANDLER =
            ScreenHandlerRegistry.registerSimple(new Identifier(MinecraftOverhaul.MOD_ID, "soul_forge"),
                    SoulForgeScreenHandler::new);
}
