package net.theblindbandi6.lovelybites.advancement;

import net.minecraft.advancements.CriteriaTriggers;
import net.theblindbandi6.lovelybites.LovelyBites;
import net.theblindbandi6.lovelybites.advancement.custom.FedPlayerCriterion;

public class ModCriteria {
    public static final FedPlayerCriterion FOOD_FED_TO_PLAYER = CriteriaTriggers.register(LovelyBites.MOD_ID + ":food_fed_to_player", new FedPlayerCriterion());
    public static final FedPlayerCriterion POTION_FED_TO_PLAYER = CriteriaTriggers.register(LovelyBites.MOD_ID + ":potion_fed_to_player", new FedPlayerCriterion());
    public static final FedPlayerCriterion MILK_FED_TO_PLAYER = CriteriaTriggers.register(LovelyBites.MOD_ID + ":milk_fed_to_player", new FedPlayerCriterion());

    public static void registerCriterion() {
        //LovelyBites.LOGGER.info("Registering Criterion");
    }
}
