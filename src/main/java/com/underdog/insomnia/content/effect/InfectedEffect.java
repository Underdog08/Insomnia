package com.underdog.insomnia.content.effect;

import com.underdog.insomnia.Insomnia;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.world.World;

public class InfectedEffect extends StatusEffect {
    public InfectedEffect() {
        super(StatusEffectCategory.HARMFUL, 0x000000);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }

    @Override
    public boolean isInstant() {
        return false;
    }

    @Override
    public boolean applyUpdateEffect(LivingEntity entity, int amplifier) {
        RegistryEntry<StatusEffect> registryEntry = Registries.STATUS_EFFECT.getEntry(this);
        StatusEffectInstance effectInstance = entity.getStatusEffect(registryEntry);

        if (effectInstance != null && effectInstance.getDuration() <= 1) {
            World world = entity.getWorld();
            DamageSource damageSource = new DamageSource(
                    world.getRegistryManager()
                            .get(RegistryKeys.DAMAGE_TYPE)
                            .entryOf(Insomnia.INFECTION_DAMAGE));
            entity.damage(damageSource, 2147483647);
        }

        return super.applyUpdateEffect(entity, amplifier);
    }
}