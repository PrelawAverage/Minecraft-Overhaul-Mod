package net.prelaw.mc.status_effects;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.prelaw.mc.MinecraftOverhaul;

public class ModEffects {
    public static StatusEffect FREEZE;

    public static StatusEffect registerStatusEffects(String name, StatusEffect effect) {
        return Registry.register(Registry.STATUS_EFFECT, new Identifier(MinecraftOverhaul.MOD_ID, name), effect);
    }

    public static void registerEffects() {

    }
}
