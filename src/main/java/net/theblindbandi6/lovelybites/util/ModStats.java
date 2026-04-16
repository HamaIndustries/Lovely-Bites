package net.theblindbandi6.lovelybites.util;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.stats.StatFormatter;
import net.minecraft.stats.Stats;
import net.theblindbandi6.lovelybites.LovelyBites;

public class ModStats {
    public static final Identifier PLAYERS_FED = makeCustomStat("players_fed", StatFormatter.DEFAULT);

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
