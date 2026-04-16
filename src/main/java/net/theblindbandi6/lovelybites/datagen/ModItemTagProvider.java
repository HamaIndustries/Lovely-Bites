package net.theblindbandi6.lovelybites.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.ItemTags;
import net.theblindbandi6.lovelybites.items.ModItems;
import net.theblindbandi6.lovelybites.util.ModTags;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagsProvider.ItemTagsProvider {
    public ModItemTagProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider wrapperLookup) {
        valueLookupBuilder(ItemTags.CHICKEN_FOOD)
                .add(ModItems.STRAWBERRY_SEEDS)
                .setReplace(false);
        valueLookupBuilder(ItemTags.PARROT_FOOD)
                .add(ModItems.STRAWBERRY_SEEDS)
                .setReplace(false);
        valueLookupBuilder(ItemTags.PARROT_POISONOUS_FOOD)
                .add(ModItems.CHOCOLATE)
                .add(ModItems.CHOCOLATE_STRAWBERRY)
                .setReplace(false);

        valueLookupBuilder(ModTags.STRAWBERRIES)
                .add(ModItems.STRAWBERRY)
                .setReplace(false);

    }

    @Override
    public @NotNull String getName() {
        return "ModItemTagProvider";
    }
}
