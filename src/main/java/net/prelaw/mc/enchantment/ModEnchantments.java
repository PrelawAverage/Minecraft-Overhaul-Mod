package net.prelaw.mc.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.prelaw.mc.MinecraftOverhaul;

public class ModEnchantments {

    public static Enchantment LIGHTNING_STRIKER = register("lightning_striker", new LightningStrikerEnchantment(Enchantment.Rarity.VERY_RARE, EnchantmentTarget.WEAPON, EquipmentSlot.MAINHAND));

    public  static Enchantment register(String name, Enchantment enchantment) {
        return Registry.register(Registry.ENCHANTMENT, new Identifier(MinecraftOverhaul.MOD_ID, name), enchantment);
    }

    public static void registerModEnchantments() {
        System.out.println("Registering ModEnchantment for " + MinecraftOverhaul.MOD_ID);
    }
}
