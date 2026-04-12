package net.theblindbandi6.lovelybites.util;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.Util;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.storage.loot.LootTable;
import net.theblindbandi6.lovelybites.LovelyBites;

import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ModLootTables {
    private static final Set<ResourceKey<LootTable>> LOCATIONS = new HashSet();
    private static final Set<ResourceKey<LootTable>> IMMUTABLE_LOCATIONS = Collections.unmodifiableSet(LOCATIONS);

    //Loot Table IDs
    public static final ResourceKey<LootTable> HARVEST_STRAWBERRY_BUSH = register("harvest/strawberry_bush");

    //Register Methods
    private static Map<DyeColor, ResourceKey<LootTable>> makeDyeKeyMap(final String prefix) {
        return Util.makeEnumMap(DyeColor.class, dye -> register(prefix + "/" + dye.getName()));
    }
    private static ResourceKey<LootTable> register(final String location) {
        return register(ResourceKey.create(Registries.LOOT_TABLE, Identifier.fromNamespaceAndPath(LovelyBites.MOD_ID, location)));
    }
    private static ResourceKey<LootTable> register(final ResourceKey<LootTable> location) {
        if (LOCATIONS.add(location)) {
            return location;
        } else {
            throw new IllegalArgumentException(location.identifier() + " is already a registered built-in loot table");
        }
    }
    public static Set<ResourceKey<LootTable>> all() {
        return IMMUTABLE_LOCATIONS;
    }

    public static void registerLootTables() {
    }
}
