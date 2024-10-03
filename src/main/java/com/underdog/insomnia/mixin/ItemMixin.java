package com.underdog.insomnia.mixin;

import com.underdog.insomnia.Insomnia;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Item.class)
public abstract class ItemMixin {

    @Inject(method = "finishUsing", at = @At("HEAD"))
    private void onFinishUsing(ItemStack stack, World world, LivingEntity user, CallbackInfoReturnable<ItemStack> cir) {
        if (stack.getItem() != null && stack.getItem() == Items.GOLDEN_APPLE) {
            if (user.hasStatusEffect(Insomnia.INFECTED)) {
                user.removeStatusEffect(Insomnia.INFECTED);
            }
        }
    }
}