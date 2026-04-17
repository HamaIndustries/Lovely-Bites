package net.theblindbandi6.lovelybites.advancement;

import net.minecraft.advancements.CriteriaTriggers;
import net.theblindbandi6.lovelybites.LovelyBites;
import net.theblindbandi6.lovelybites.advancement.custom.FedPlayerCriterion;

public class ModCriteria {
    public static final FedPlayerCriterion FED_PLAYER = CriteriaTriggers.register(LovelyBites.MOD_ID + ":fed_player", new FedPlayerCriterion());

    public static void registerCriterion() {
        //LovelyBites.LOGGER.info("Registering Criterion");
    }
}
