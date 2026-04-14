package net.theblindbandi6.lovelybites.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.theblindbandi6.lovelybites.items.ModItems;
import net.theblindbandi6.lovelybites.util.ModTags;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeProvider createRecipeProvider(HolderLookup.Provider registryLookup, RecipeOutput exporter) {
        return new RecipeProvider(registryLookup, exporter) {
            @Override
            public void buildRecipes() {
                HolderLookup.RegistryLookup<Item> itemLookup = registries.lookupOrThrow(Registries.ITEM);

                shapeless(RecipeCategory.FOOD, ModItems.STRAWBERRY_SEEDS, 2)
                        .requires(ModItems.STRAWBERRY)
                        .unlockedBy(getHasName(ModItems.STRAWBERRY), has(ModItems.STRAWBERRY))
                        .save(output);

                shapeless(RecipeCategory.FOOD, ModItems.CHOCOLATE, 4)
                        .requires(Items.MILK_BUCKET)
                        .requires(Items.COCOA_BEANS, 4)
                        .unlockedBy(getHasName(Items.COCOA_BEANS), has(Items.COCOA_BEANS))
                        .save(output);

                shapeless(RecipeCategory.FOOD, ModItems.CHOCOLATE_STRAWBERRY, 1)
                        .requires(ModItems.CHOCOLATE)
                        .requires(ModTags.STRAWBERRIES)
                        .unlockedBy(getHasName(ModItems.CHOCOLATE), has(ModItems.CHOCOLATE))
                        .save(output);

                shapeless(RecipeCategory.FOOD, ModItems.STRAWBERRY_JAM, 1)
                        .requires(Items.GLASS_BOTTLE)
                        .requires(Items.SUGAR, 3)
                        .requires(ModTags.STRAWBERRIES)
                        .requires(ModTags.STRAWBERRIES)
                        .requires(ModTags.STRAWBERRIES)
                        .unlockedBy(getHasName(ModItems.STRAWBERRY), has(ModItems.STRAWBERRY))
                        .save(output);
            }
        };
    }

    @Override
    public String getName() {
        return "ExampleModRecipeProvider";
    }
}
