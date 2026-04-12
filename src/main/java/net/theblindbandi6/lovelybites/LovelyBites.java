package net.theblindbandi6.lovelybites;

import net.fabricmc.api.ModInitializer;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.theblindbandi6.lovelybites.items.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static net.theblindbandi6.lovelybites.items.ModItemGroups.*;

public class LovelyBites implements ModInitializer {

	public static final String MOD_ID = "lovely_bites";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("Initializing a sweet treat for myself");

		ModItems.initialize();

		// Register the group.
		Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, LOVELY_BITES_TAB_KEY, LOVEY_BITES_TAB);
	}
}