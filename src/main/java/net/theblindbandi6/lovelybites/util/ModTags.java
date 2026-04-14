package net.theblindbandi6.lovelybites.util;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.theblindbandi6.lovelybites.LovelyBites;

public class ModTags {
    public static final TagKey<Item> STRAWBERRIES = TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(LovelyBites.MOD_ID, "strawberries"));
}
