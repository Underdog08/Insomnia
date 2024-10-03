package com.underdog.insomnia.mixin;

import com.underdog.insomnia.Insomnia;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.Difficulty;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ZombieEntity.class)
public abstract class ZombieEntityMixin extends LivingEntity {

    protected ZombieEntityMixin(EntityType<? extends LivingEntity> entityType, World world) {
        super(entityType, world);
    }

    @Inject(method = "initEquipment", at = @At("TAIL"))
    private void initEquipment(Random random, LocalDifficulty localDifficulty, CallbackInfo ci) {
        if (random.nextFloat() < (this.getWorld().getDifficulty() == Difficulty.HARD ? 0.05F : 0.01F)) {
            int i = random.nextInt(5);
            if (i == 0) {
                this.equipStack(EquipmentSlot.MAINHAND, new ItemStack(Items.WOODEN_SWORD));
            } else if (i == 1) {
                this.equipStack(EquipmentSlot.MAINHAND, new ItemStack(Items.WOODEN_SHOVEL));
            } else if (i == 2) {
                this.equipStack(EquipmentSlot.MAINHAND, new ItemStack(Items.WOODEN_PICKAXE));
            } else if (i == 3) {
                this.equipStack(EquipmentSlot.MAINHAND, new ItemStack(Items.ROTTEN_FLESH));
            } else {
                this.equipStack(EquipmentSlot.MAINHAND, new ItemStack(Items.BONE));
            }
        }
    }

    @Inject(method = "tryAttack", at = @At("RETURN"))
    private void onTryAttack(Entity target, CallbackInfoReturnable<Boolean> cir) {
        if (cir.getReturnValue()) {
            int a = random.nextInt(8);
            int b = random.nextBetween(12000, 24000);
            if (target instanceof PlayerEntity player && a == 1 && !player.hasStatusEffect(Insomnia.INFECTED)) {
                player.addStatusEffect(new StatusEffectInstance(Insomnia.INFECTED, b, 0));
            }
        }
    }
}