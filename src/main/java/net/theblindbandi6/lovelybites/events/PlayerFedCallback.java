package net.theblindbandi6.lovelybites.events;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

public interface PlayerFedCallback {
    Event<PlayerFedCallback> EVENT = EventFactory.createArrayBacked(PlayerFedCallback.class,
            (listeners) -> (feeder, targetPlayer, itemStack) -> {

                boolean fed = true;

                for (PlayerFedCallback listener : listeners) {
                    fed &= listener.onFed(feeder, targetPlayer, itemStack);
                }

                return fed;
            }
    );

    boolean onFed(Player feedingPlayer, Player targetPlayer, ItemStack itemStack);
}
