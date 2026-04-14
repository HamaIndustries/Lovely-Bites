package net.theblindbandi6.lovelybites.datagen;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.client.data.models.blockstates.PropertyDispatch;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.theblindbandi6.lovelybites.blocks.ModBlocks;
import net.theblindbandi6.lovelybites.items.ModItems;

import static net.minecraft.client.data.models.BlockModelGenerators.plainVariant;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricPackOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators blockStateModelGenerator) {

        blockStateModelGenerator.blockStateOutput
                .accept(
                MultiVariantGenerator.dispatch(ModBlocks.STRAWBERRY_BUSH)
                        .with(
                                PropertyDispatch.initial(BlockStateProperties.AGE_3)
                                        .generate(age -> plainVariant(blockStateModelGenerator.createSuffixedVariant(ModBlocks.STRAWBERRY_BUSH, "_stage" + age, ModelTemplates.CROSS, TextureMapping::cross)))
                        )
        );

    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerator) {
        itemModelGenerator.generateFlatItem(ModItems.STRAWBERRY, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.STRAWBERRY_SEEDS, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.CHOCOLATE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.CHOCOLATE_STRAWBERRY, ModelTemplates.FLAT_ITEM);

    }

    @Override
    public String getName() {
        return "ModModelProvider";
    }
}
