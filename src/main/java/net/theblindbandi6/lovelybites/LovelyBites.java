package net.theblindbandi6.lovelybites;

import net.fabricmc.api.ModInitializer;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.theblindbandi6.lovelybites.advancement.ModCriteria;
import net.theblindbandi6.lovelybites.blocks.ModBlocks;
import net.theblindbandi6.lovelybites.items.ModItems;
import net.theblindbandi6.lovelybites.blocks.ModBuiltInLootTables;
import net.theblindbandi6.lovelybites.util.ModStats;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static net.theblindbandi6.lovelybites.items.ModItemGroups.*;

public class LovelyBites implements ModInitializer {

	public static final String MOD_ID = "lovely_bites";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Initializing a sweet treat for myself");

		ModStats.registerStats();
		ModCriteria.registerCriterion();

		ModItems.registerItems();
		ModBlocks.registerBlocks();
		ModBuiltInLootTables.registerLootTables();

		Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, LOVELY_BITES_TAB_KEY, LOVEY_BITES_TAB);

	}
}