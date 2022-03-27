package net.prelaw.mc.event;

import net.fabricmc.fabric.api.client.screen.v1.ScreenEvents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.TitleScreen;
import net.prelaw.mc.util.OverhaulMenuScreen;

public class ReplaceTitleScreenEvent implements ScreenEvents.BeforeInit{
    @Override
    // Show our title screen if it isn't already showing
    public void beforeInit(MinecraftClient client, Screen screen, int scaledWidth, int scaledHeight) {
        if(screen instanceof TitleScreen && !(screen instanceof OverhaulMenuScreen)) {
            client.setScreen(new OverhaulMenuScreen());
        }
    }
}
