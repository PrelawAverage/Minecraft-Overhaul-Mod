package net.prelaw.mc;

import net.fabricmc.api.ModInitializer;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.prelaw.mc.block.ModBlocks;
import net.prelaw.mc.block.entity.ModBlockEntities;
import net.prelaw.mc.enchantment.ModEnchantments;
import net.prelaw.mc.item.ModItems;
import net.prelaw.mc.painting.ModPaintings;
import net.prelaw.mc.potion.ModPotions;
import net.prelaw.mc.recipe.ModRecipes;
import net.prelaw.mc.status_effects.FreezeStatusEffect;
import net.prelaw.mc.status_effects.KnowledgeStatusEffect;
import net.prelaw.mc.status_effects.ModEffects;
import net.prelaw.mc.status_effects.WellFed;
import net.prelaw.mc.util.ModLootTableModifiers;
import net.prelaw.mc.util.ModRegistries;
import net.prelaw.mc.world.feature.ModConfiguredFeatures;
import net.prelaw.mc.world.gen.ModWorldGen;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MinecraftOverhaul implements ModInitializer {

	public static final String MOD_ID = "minecraft_overhaul";
	public static final Logger LOGGER = LogManager.getLogger(MOD_ID);

	public static final StatusEffect KNOWLEDGE = new KnowledgeStatusEffect(StatusEffectCategory.BENEFICIAL, 0x98D982);
	public static final StatusEffect FREEZE = new FreezeStatusEffect(StatusEffectCategory.HARMFUL, 0x4CD6FF);
	public static final StatusEffect WED_FED = new WellFed(StatusEffectCategory.BENEFICIAL, 0x4CD6FF)
			.addAttributeModifier(EntityAttributes.GENERIC_ATTACK_DAMAGE, "71ec578f-970f-4c1f-8f85-1669e3caf525", 0.05, EntityAttributeModifier.Operation.MULTIPLY_TOTAL)
			.addAttributeModifier(EntityAttributes.GENERIC_MOVEMENT_SPEED, "8a8a01f5-0127-4223-a4f0-e7bb9efe9a35", 0.05, EntityAttributeModifier.Operation.MULTIPLY_TOTAL)
			.addAttributeModifier(EntityAttributes.GENERIC_MAX_HEALTH, "a6bf96c8-37ea-4948-8bd2-47cecfd6d70c", 0.05, EntityAttributeModifier.Operation.MULTIPLY_TOTAL);

	@Override
	public void onInitialize() {

		ModConfiguredFeatures.registerConfiguredFeatures();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModBlockEntities.registerAllEntities();
		ModRecipes.register();
		ModRegistries.registerModStuffs();
		ModEnchantments.registerModEnchantments();
		ModLootTableModifiers.modifyLootTables();
		ModPaintings.registerPaintings();
		ModEffects.registerEffects();
		ModPotions.registerPotions();

		// Must be last
		ModWorldGen.generateModWorldGen();
	}
}
