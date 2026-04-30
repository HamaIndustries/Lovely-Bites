package net.theblindbandi6.lovelybites.util;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.stats.StatFormatter;
import net.minecraft.stats.Stats;
import net.theblindbandi6.lovelybites.LovelyBites;

public class ModStats {
    public static final Identifier FOOD_FED_TO_PLAYERS = makeCustomStat("food_fed_to_players", StatFormatter.DEFAULT);
    public static final Identifier POTIONS_FED_TO_PLAYERS = makeCustomStat("potions_fed_to_players", StatFormatter.DEFAULT);

    private static Identifier makeCustomStat(final String name, final StatFormatter formatter) {
        Identifier location = Identifier.fromNamespaceAndPath(LovelyBites.MOD_ID, name);
        Registry.register(BuiltInRegistries.CUSTOM_STAT, name, location);
        Stats.CUSTOM.get(location, formatter);
        return location;
    }

    public static void registerStats() {
        //LovelyBites.LOGGER.info("Registering Statistics");
    }
}
