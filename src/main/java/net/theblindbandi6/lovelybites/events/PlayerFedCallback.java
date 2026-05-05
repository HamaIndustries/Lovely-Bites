package net.theblindbandi6.lovelybites.events;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
import net.minecraft.world.entity.player.Player;

public interface PlayerFedCallback {
    Event<PlayerFedCallback> EVENT = EventFactory.createArrayBacked(PlayerFedCallback.class,
            (listeners) -> (feeder, targetPlayer) -> {
                for (PlayerFedCallback listener : listeners) {
                    listener.onFed(feeder, targetPlayer);
                }
            }
    );

    void onFed(Player feedingPlayer, Player targetPlayer);
}
