package net.prelaw.mc.recipe;

import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.prelaw.mc.MinecraftOverhaul;

public class ModRecipes {
    public static void register() {
        Registry.register(Registry.RECIPE_SERIALIZER, new Identifier(MinecraftOverhaul.MOD_ID, SoulForgeRecipe.Serializer.ID),
                SoulForgeRecipe.Serializer.INSTANCE);
        Registry.register(Registry.RECIPE_TYPE, new Identifier(MinecraftOverhaul.MOD_ID, SoulForgeRecipe.Type.ID),
                SoulForgeRecipe.Type.INSTANCE);
    }
}