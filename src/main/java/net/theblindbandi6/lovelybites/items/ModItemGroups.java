package net.theblindbandi6.lovelybites.items;

import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.component.ItemLore;
import net.theblindbandi6.lovelybites.LovelyBites;

import java.util.List;

public class ModItemGroups {

    public static final ResourceKey<CreativeModeTab> LOVELY_BITES_TAB_KEY = ResourceKey.create(
            BuiltInRegistries.CREATIVE_MODE_TAB.key(), Identifier.fromNamespaceAndPath(LovelyBites.MOD_ID, "creative_tab")
    );

    public static final CreativeModeTab LOVEY_BITES_TAB = FabricCreativeModeTab.builder()
            .icon(() -> new ItemStack(ModItems.SUSPICIOUS_SUBSTANCE))
            .title(Component.translatable("creativeTab.lovely_bites"))
            .displayItems((params, output) -> {

                output.accept(ModItems.SUSPICIOUS_SUBSTANCE);

                // And custom ItemStacks
                ItemStack stack = new ItemStack(Items.SEA_PICKLE);
                stack.set(DataComponents.ITEM_NAME, Component.literal("Pickle Rick"));
                stack.set(DataComponents.LORE, new ItemLore(List.of(Component.literal("I'm pickle riiick!!"))));
                output.accept(stack);
            })
            .build();
}
