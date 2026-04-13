package net.theblindbandi6.lovelybites.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.theblindbandi6.lovelybites.blocks.ModBlocks;
import net.theblindbandi6.lovelybites.items.ModItems;
import net.theblindbandi6.lovelybites.util.ModTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagsProvider.ItemTagsProvider {
    public ModItemTagProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider wrapperLookup) {
        valueLookupBuilder(ItemTags.CHICKEN_FOOD)
                .add(ModItems.STRAWBERRY_SEEDS)
                .setReplace(false);
        valueLookupBuilder(ItemTags.PARROT_FOOD)
                .add(ModItems.STRAWBERRY_SEEDS)
                .setReplace(false);


        valueLookupBuilder(ItemTags.PARROT_POISONOUS_FOOD)
                .add(ModItems.CHOCOLATE)
                .setReplace(false);

        valueLookupBuilder(ModTags.FEEDABLE_FOODS)
                .add(ModItems.STRAWBERRY)
                .add(ModItems.CHOCOLATE)
                .add(Items.GOLDEN_APPLE)
                .setReplace(false);
    }

    @Override
    public String getName() {
        return "ModItemTagProvider";
    }
}
