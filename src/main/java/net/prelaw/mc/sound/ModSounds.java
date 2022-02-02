package net.prelaw.mc.sound;

import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.prelaw.mc.MinecraftOverhaul;

public class ModSounds {

    // Sounds
    public static SoundEvent BALLOON_POPPING = registerSoundEvent("balloon_popping");
    public static SoundEvent BALLOON_INFLATING = registerSoundEvent("balloon_inflating");

    public static SoundEvent MUSIC_EXCUSE = registerSoundEvent("music_excuse");
    public static SoundEvent MUSIC_CHRIS = registerSoundEvent("music_chris");
    public static SoundEvent MUSIC_AVIVA = registerSoundEvent("music_aviva");
    public static SoundEvent MUSIC_FLAKE = registerSoundEvent("music_flake");

    public static SoundEvent SUNRISE_TUNE = registerSoundEvent("sunrise_tune");

    // This is the sound registry
    private static SoundEvent registerSoundEvent(String name) {
        Identifier id = new Identifier(MinecraftOverhaul.MOD_ID, name);
        return Registry.register(Registry.SOUND_EVENT, id, new SoundEvent(id));
    }
}
