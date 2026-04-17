package net.theblindbandi6.lovelybites.advancement.custom;

import com.mojang.serialization.Codec;
import net.minecraft.advancements.criterion.ContextAwarePredicate;
import net.minecraft.advancements.criterion.SimpleCriterionTrigger;
import net.minecraft.server.level.ServerPlayer;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;

public class FedPlayerCriterion extends SimpleCriterionTrigger<FedPlayerCriterion.@org.jetbrains.annotations.NotNull Conditions> {

	@Override
	public @NotNull Codec<Conditions> codec() {
		return Conditions.CODEC;
	}

	public record Conditions(Optional<ContextAwarePredicate> playerPredicate) implements SimpleCriterionTrigger.SimpleInstance {
		public static Codec<FedPlayerCriterion.Conditions> CODEC = ContextAwarePredicate.CODEC.optionalFieldOf("player")
				.xmap(Conditions::new, Conditions::player).codec();

		@Override
		public @NotNull Optional<ContextAwarePredicate> player() {
			return playerPredicate;
		}

		public boolean requirementsMet() {
			return true; // AbstractCriterion#trigger helpfully checks the playerPredicate for us.
		}
	}

	public void trigger(ServerPlayer player) {
		trigger(player, Conditions::requirementsMet);
	}
}