package com.underdog.insomnia.mixin;

import com.underdog.insomnia.Insomnia;
import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsage;
import net.minecraft.item.Items;
import net.minecraft.item.MilkBucketItem;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.stat.Stats;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

import java.util.ArrayList;
import java.util.List;

@Mixin(MilkBucketItem.class)
public abstract class MilkBucketItemMixin {

    /**
     * @author a
     * @reason a
     */
    @Overwrite
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        if (user instanceof ServerPlayerEntity serverPlayerEntity) {
            // Cast 'this' to MilkBucketItem to avoid the type error
            Criteria.CONSUME_ITEM.trigger(serverPlayerEntity, stack);
            serverPlayerEntity.incrementStat(Stats.USED.getOrCreateStat((MilkBucketItem) (Object) this));
        }

        if (!world.isClient) {
            // Create a list of effects to remove
            List<StatusEffectInstance> effectsToRemove = new ArrayList<>();

            for (StatusEffectInstance effect : user.getStatusEffects()) {
                if (effect.getEffectType() != Insomnia.INFECTED) {
                    effectsToRemove.add(effect);
                }
            }

            // Now remove the effects safely
            for (StatusEffectInstance effect : effectsToRemove) {
                user.removeStatusEffect(effect.getEffectType());
            }
        }

        if (user instanceof PlayerEntity playerEntity) {
            return ItemUsage.exchangeStack(stack, playerEntity, new ItemStack(Items.BUCKET), false);
        } else {
            stack.decrementUnlessCreative(1, user);
            return stack;
        }
    }
}