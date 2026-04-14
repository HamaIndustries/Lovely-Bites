package net.theblindbandi6.lovelybites.items;

import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties STRAWBERRY = new FoodProperties.Builder().nutrition(3).saturationModifier(0.3F).build();
    public static final FoodProperties CHOCOLATE = new FoodProperties.Builder().nutrition(3).saturationModifier(0.1F).build();
    public static final FoodProperties CHOCOLATE_STRAWBERRY = new FoodProperties.Builder().nutrition(6).saturationModifier(0.4F).build();
}
