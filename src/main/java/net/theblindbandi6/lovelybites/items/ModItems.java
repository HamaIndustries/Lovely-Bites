package net.theblindbandi6.lovelybites.items;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.theblindbandi6.lovelybites.LovelyBites;
import net.theblindbandi6.lovelybites.blocks.ModBlocks;

import java.util.function.Function;

public class ModItems {
    //Items
    public static final Item STRAWBERRY = register("strawberry", Item::new, new Item.Properties().food(ModFoods.STRAWBERRY));
    public static final Item CHOCOLATE = register("chocolate", Item::new, new Item.Properties().food(ModFoods.CHOCOLATE));
    public static final Item CHOCOLATE_STRAWBERRY = register("chocolate_strawberry", Item::new, new Item.Properties().food(ModFoods.CHOCOLATE_STRAWBERRY));

    //Block Items
    public static final Item STRAWBERRY_SEEDS = register("strawberry_seeds", settings ->
            new BlockItem(ModBlocks.STRAWBERRY_BUSH, settings));

    //Register Methods
    public static <T extends Item> T register(String name, Function<Item.Properties, T> itemFactory, Item.Properties settings) {
        // Create the item key.
        ResourceKey<Item> itemKey = ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(LovelyBites.MOD_ID, name));

        // Create the item instance.
        T item = itemFactory.apply(settings.setId(itemKey));

        // Register the item.
        Registry.register(BuiltInRegistries.ITEM, itemKey, item);

        return item;
    }

    private static Item register(String name, Function<Item.Properties, Item> function) {
        return Registry.register(BuiltInRegistries.ITEM, Identifier.fromNamespaceAndPath(LovelyBites.MOD_ID, name),
                function.apply(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(LovelyBites.MOD_ID, name)))));
    }

    public static void registerItems() {
    }
}
