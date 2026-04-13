package net.theblindbandi6.lovelybites.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.component.Consumable;
import net.minecraft.world.item.component.UseCooldown;
import net.minecraft.world.item.component.UseRemainder;
import net.minecraft.world.item.consume_effects.ConsumeEffect;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;


@Mixin(Player.class)
public abstract class PlayerMixin extends Avatar implements ContainerUser{
    protected PlayerMixin(EntityType<? extends LivingEntity> type, Level level) {
        super(type, level);
    }

    //Injects into the "interactOn method within the Player class"
    @Inject(method = "interactOn", at = @At("HEAD"), cancellable = true)
    public InteractionResult interactOn(final Entity entity, final InteractionHand hand, final Vec3 location, CallbackInfoReturnable<InteractionResult> cir) {
        //Checks the hand is the offhand
        if(hand == InteractionHand.OFF_HAND && entity instanceof Player targetPlayer){
            // Gets the player using food on the other player
            Player feeder = (Player) (Object) this;
            //Gets the item in the feeder's main interaction hand (Only done for offhand)
            ItemStack stack = feeder.getItemInHand(hand);
                //Checks for the food data component on the item
                FoodProperties food = stack.get(DataComponents.FOOD);
                //Stops if the item doesn't have a food component
                if (food != null) {
                    //Gets the foods hunger and saturation
                    int hunger = food.nutrition();
                    float saturation = food.saturation();
                    //Checks if the targeted player is hungry and food item isn't currently on cooldown
                    int playerHunger = targetPlayer.getFoodData().getFoodLevel();
                    if(playerHunger < 20 && !feeder.getCooldowns().isOnCooldown(stack)) {
                        //Gets the pos and level of targeted player for particles and sounds
                        BlockPos pos = targetPlayer.blockPosition();
                        Level level = targetPlayer.level();
                        //Applies hunger and saturation to targeted player
                        targetPlayer.getFoodData().eat(hunger, saturation);
                        //Checks if the item has a consumable component for status effects
                        Consumable consumable = stack.get(DataComponents.CONSUMABLE);
                        if (consumable != null) {
                            //Applies the effects in the component
                            List<ConsumeEffect> effects = consumable.onConsumeEffects();
                            ItemStack finalStack = stack;
                            effects.forEach(action -> action.apply(level, finalStack, targetPlayer));
                        }
                        //Plays an eating sound
                        level.playSound(targetPlayer, pos, SoundEvents.FOX_EAT, SoundSource.PLAYERS, 1.0F, 1.0F);
                        //Displays heart particles
                        if (targetPlayer.level() instanceof ServerLevel serverLevel) {
                            serverLevel.sendParticles(
                                    ParticleTypes.HEART,
                                    targetPlayer.getX(),
                                    targetPlayer.getY() + targetPlayer.getBbHeight() * 0.9,
                                    targetPlayer.getZ(),
                                    3,
                                    0.3, 0.2, 0.3,
                                    0.02
                            );
                        }
                        //Consumes an item in the stack and add a cooldown to prevent spamming in survival
                        if (!feeder.isCreative()) {
                            //Checks for a remainder e.g. Mushroom stew into bowl
                            int beforeUseCount = stack.getCount();
                            UseRemainder useRemainder = stack.get(DataComponents.USE_REMAINDER);
                            stack.consume(1, feeder);
                            if (useRemainder != null) {
                                ItemStack newHandStack = useRemainder.convertIntoRemainder(stack, beforeUseCount, feeder.hasInfiniteMaterials(), feeder::handleExtraItemsCreatedOnUse);
                                feeder.setItemInHand(hand, newHandStack);
                            }
                            feeder.getCooldowns().addCooldown(stack, 32);
                        }
                        cir.setReturnValue(InteractionResult.SUCCESS);
                    }else{
                        //Fails if player isn't hungry
                        //LovelyBites.LOGGER.info("Target Player isn't hungry");
                        cir.setReturnValue(InteractionResult.PASS);
                    }
                } else {
                    //Fails if item has no food properties
                    //LovelyBites.LOGGER.info("Item is feedable but has no food properties");
                    cir.setReturnValue(InteractionResult.PASS);
                }
            }
        return InteractionResult.PASS;
    }
}
