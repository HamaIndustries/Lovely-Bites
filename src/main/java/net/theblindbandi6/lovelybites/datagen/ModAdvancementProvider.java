package net.theblindbandi6.lovelybites.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.core.HolderLookup;
/*
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementType;
import net.minecraft.data.advancements.packs.VanillaHusbandryAdvancements;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Items;
import net.theblindbandi6.lovelybites.LovelyBites;
import net.theblindbandi6.lovelybites.advancements.ModCriteria;
import net.theblindbandi6.lovelybites.advancements.custom.FedPlayerCriterion;
import net.theblindbandi6.lovelybites.items.ModItems;
import java.util.Optional;
 */
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class ModAdvancementProvider extends FabricAdvancementProvider {
    protected ModAdvancementProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(output, registryLookup);
    }

    @Override
    public void generateAdvancement(HolderLookup.@NotNull Provider wrapperLookup, @NotNull Consumer<AdvancementHolder> consumer) {
        /*
        AdvancementHolder fedPlayer = Advancement.Builder.advancement()
                .display(
                        ModItems.STRAWBERRY,
                        Component.translatable("advancements.lovely_bites.fed_player.title"),
                        Component.translatable("advancements.lovely_bites.fed_player.description"),
                        null,
                        AdvancementType.GOAL,
                        true,
                        true,
                        false
                )
                .addCriterion("fed_player", ModCriteria.FED_PLAYER.createCriterion(new FedPlayerCriterion.Conditions(Optional.empty())))
                .save(consumer, LovelyBites.MOD_ID + ":fed_player");
                */
    }
}
