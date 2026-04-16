package net.theblindbandi6.lovelybites.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.BlockTags;
import net.theblindbandi6.lovelybites.blocks.ModBlocks;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagsProvider.BlockTagsProvider {
    public ModBlockTagProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider wrapperLookup) {
        valueLookupBuilder(BlockTags.AZALEA_ROOT_REPLACEABLE)
                .add(ModBlocks.STRAWBERRY_BUSH)
                .setReplace(false);

        valueLookupBuilder(BlockTags.BEE_GROWABLES)
                .add(ModBlocks.STRAWBERRY_BUSH)
                .setReplace(false);
    }

    @Override
    public @NotNull String getName() {
        return "ModBlockTagProvider";
    }
}
