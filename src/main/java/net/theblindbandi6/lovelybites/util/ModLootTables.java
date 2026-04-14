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

    //Loot Table IDs
    public static ResourceKey<LootTable> HARVEST_STRAWBERRY_BUSH = ResourceKey.create(Registries.LOOT_TABLE,Identifier.fromNamespaceAndPath(LovelyBites.MOD_ID, "harvest/strawberry_bush"));
    //public static ResourceKey<LootTable> TEST_CHEST_LOOT = ResourceKey.create(Registries.LOOT_TABLE,Identifier.fromNamespaceAndPath(LovelyBites.MOD_ID, "chests/test_loot"));

    public static void registerLootTables() {
    }
}
