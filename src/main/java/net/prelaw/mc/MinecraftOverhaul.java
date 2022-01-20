package net.prelaw.mc;

import net.fabricmc.api.ModInitializer;
import net.prelaw.mc.block.ModBlocks;
import net.prelaw.mc.item.ModItems;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MinecraftOverhaul implements ModInitializer {

	public static final String MOD_ID = "minecraft_overhaul";
	public static final Logger LOGGER = LogManager.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

	}
}
