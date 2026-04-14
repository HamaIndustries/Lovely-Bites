package net.theblindbandi6.lovelybites.items;

import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.theblindbandi6.lovelybites.LovelyBites;
import net.theblindbandi6.lovelybites.blocks.ModBlocks;

public class ModItemGroups {

    public static final ResourceKey<CreativeModeTab> LOVELY_BITES_TAB_KEY = ResourceKey.create(
            BuiltInRegistries.CREATIVE_MODE_TAB.key(), Identifier.fromNamespaceAndPath(LovelyBites.MOD_ID, "creative_tab")
    );

    public static final CreativeModeTab LOVEY_BITES_TAB = FabricCreativeModeTab.builder()
            .icon(() -> new ItemStack(ModItems.STRAWBERRY))
            .title(Component.translatable("creativeTab.lovely_bites"))
            .displayItems((params, output) -> {

                output.accept(ModItems.STRAWBERRY);
                output.accept(ModItems.STRAWBERRY_SEEDS);

                output.accept(ModItems.CHOCOLATE);
                output.accept(ModItems.CHOCOLATE_STRAWBERRY);

            })
            .build();
}
