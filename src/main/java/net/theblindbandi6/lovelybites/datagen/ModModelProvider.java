package net.theblindbandi6.lovelybites.datagen;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.world.item.Item;
import net.theblindbandi6.lovelybites.blocks.ModBlocks;
import net.theblindbandi6.lovelybites.items.ModItems;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricPackOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators blockStateModelGenerator) {
        blockStateModelGenerator.createCrossBlock(ModBlocks.STRAWBERRY_BUSH, BlockModelGenerators.PlantType.TINTED);
    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerator) {
        itemModelGenerator.generateFlatItem(ModItems.STRAWBERRY, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.STRAWBERRY_SEEDS, ModelTemplates.FLAT_ITEM);

    }

    @Override
    public String getName() {
        return "ModModelProvider";
    }
}
