package net.theblindbandi6.lovelybites.util;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.storage.loot.LootTable;
import net.theblindbandi6.lovelybites.LovelyBites;

public class ModLootTables {

    //Loot Table IDs
    public static ResourceKey<LootTable> HARVEST_STRAWBERRY_BUSH = ResourceKey.create(Registries.LOOT_TABLE,Identifier.fromNamespaceAndPath(LovelyBites.MOD_ID, "harvest/strawberry_bush"));

    public static void registerLootTables() {
    }
}
