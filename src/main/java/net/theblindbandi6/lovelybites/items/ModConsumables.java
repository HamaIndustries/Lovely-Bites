package net.theblindbandi6.lovelybites.items;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ItemUseAnimation;
import net.minecraft.world.item.component.Consumable;

public class ModConsumables {
    public static final Consumable STRAWBERRY_JAM = defaultDrink().consumeSeconds(2.0F).sound(SoundEvents.HONEY_DRINK).build();

    public static Consumable.Builder defaultDrink() {
        return Consumable.builder().consumeSeconds(1.6F).animation(ItemUseAnimation.DRINK).sound(SoundEvents.GENERIC_DRINK).hasConsumeParticles(false);
    }
}
