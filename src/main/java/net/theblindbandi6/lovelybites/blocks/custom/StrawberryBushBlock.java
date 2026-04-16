package net.theblindbandi6.lovelybites.blocks.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.InsideBlockEffectApplier;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SweetBerryBushBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.theblindbandi6.lovelybites.items.ModItems;
import net.theblindbandi6.lovelybites.blocks.ModBuiltInLootTables;
import org.jetbrains.annotations.NotNull;

public class StrawberryBushBlock extends SweetBerryBushBlock {
    public StrawberryBushBlock(Properties properties) {
        super(properties);
    }

    //Change Creative block picking to Strawberry Seeds
    @Override
    protected @NotNull ItemStack getCloneItemStack(final @NotNull LevelReader level, final @NotNull BlockPos pos, final @NotNull BlockState state, final boolean includeData){
        return new ItemStack(ModItems.STRAWBERRY_SEEDS);
    }

    //Remove damage from entities stuck inside
    @Override
    protected void entityInside(final @NotNull BlockState state, final @NotNull Level level, final @NotNull BlockPos pos, final @NotNull Entity entity, final @NotNull InsideBlockEffectApplier effectApplier, final boolean isPrecise){
        if (entity instanceof LivingEntity && !entity.is(EntityType.FOX) && !entity.is(EntityType.BEE)) {
            entity.makeStuckInBlock(state, new Vec3(0.8F, 0.75, 0.8F));
        }
    }

    //Change loot table to drop strawberries instead of sweet berries
    @Override
    protected @NotNull InteractionResult useWithoutItem(final BlockState state, final @NotNull Level level, final @NotNull BlockPos pos, final @NotNull Player player, final @NotNull BlockHitResult hitResult) {
        if (state.getValue(AGE) > 1) {
            if (level instanceof ServerLevel serverLevel) {
                Block.dropFromBlockInteractLootTable(
                        serverLevel,
                        ModBuiltInLootTables.HARVEST_STRAWBERRY_BUSH,
                        state,
                        level.getBlockEntity(pos),
                        null,
                        player,
                        (serverlvl, itemStack) -> Block.popResource(serverlvl, pos, itemStack)
                );
                serverLevel.playSound(null, pos, SoundEvents.SWEET_BERRY_BUSH_PICK_BERRIES, SoundSource.BLOCKS, 1.0F, 0.8F + serverLevel.getRandom().nextFloat() * 0.4F);
                BlockState newState = state.setValue(AGE, 1);
                serverLevel.setBlock(pos, newState, 2);
                serverLevel.gameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Context.of(player, newState));
            }

            return InteractionResult.SUCCESS;
        } else {
            return super.useWithoutItem(state, level, pos, player, hitResult);
        }
    }
}
