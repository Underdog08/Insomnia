package com.underdog.insomnia.content.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.util.Identifier;

public class FatigueEffect extends StatusEffect {
    public FatigueEffect() {
        super(StatusEffectCategory.HARMFUL, 0x000000);
    }
    private static final EntityAttributeModifier MAX_HEALTH_MODIFIER = new EntityAttributeModifier(Identifier.of("e5c9e9c6-d7f1-4f51-8d7d-64b6d3e62666"), -10.0, EntityAttributeModifier.Operation.ADD_VALUE);
    private static final EntityAttributeModifier MINING_SPEED_MODIFIER = new EntityAttributeModifier(Identifier.of("e5c9e9c6-d7f1-4f51-8d7d-64b6d3e66354"), -0.8, EntityAttributeModifier.Operation.ADD_VALUE);
    private static final EntityAttributeModifier ATTACK_SPEED_MODIFIER = new EntityAttributeModifier(Identifier.of("e5c9e9c6-d7f1-4f51-8d7d-64b6d3e28567"), -0.2, EntityAttributeModifier.Operation.ADD_VALUE);

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }

    @Override
    public boolean applyUpdateEffect(LivingEntity entity, int amplifier) {

        return super.applyUpdateEffect(entity, amplifier);
    }

    @Override
    public void onApplied(LivingEntity entity, int amplifier) {
        EntityAttributeInstance maxHealth = entity.getAttributeInstance(EntityAttributes.GENERIC_MAX_HEALTH);
        EntityAttributeInstance miningSpeed = entity.getAttributeInstance(EntityAttributes.PLAYER_BLOCK_BREAK_SPEED);
        EntityAttributeInstance hitSpeed = entity.getAttributeInstance(EntityAttributes.GENERIC_ATTACK_SPEED);
        if (maxHealth != null) {
            maxHealth.removeModifier(Identifier.of("e5c9e9c6-d7f1-4f51-8d7d-64b6d3e62666"));

            maxHealth.addTemporaryModifier(MAX_HEALTH_MODIFIER);
        }
        if (miningSpeed != null) {
            miningSpeed.removeModifier(Identifier.of("e5c9e9c6-d7f1-4f51-8d7d-64b6d3e66354"));

            miningSpeed.addTemporaryModifier(MINING_SPEED_MODIFIER);
        }
        if (hitSpeed != null) {
            hitSpeed.removeModifier(Identifier.of("e5c9e9c6-d7f1-4f51-8d7d-64b6d3e28567"));

            hitSpeed.addTemporaryModifier(ATTACK_SPEED_MODIFIER);
        }
    }

    @Override
    public boolean isInstant() {
        return false;
    }

    @Override
    public void onRemoved(AttributeContainer attributeContainer) {
        super.onRemoved(attributeContainer);
        EntityAttributeInstance maxHealth = attributeContainer.getCustomInstance(EntityAttributes.GENERIC_MAX_HEALTH);
        EntityAttributeInstance miningSpeed = attributeContainer.getCustomInstance(EntityAttributes.PLAYER_BLOCK_BREAK_SPEED);
        EntityAttributeInstance hitSpeed = attributeContainer.getCustomInstance(EntityAttributes.GENERIC_ATTACK_SPEED);
        if (maxHealth != null) {
            maxHealth.removeModifier(Identifier.of("e5c9e9c6-d7f1-4f51-8d7d-64b6d3e62666"));

            //maxHealth.addTemporaryModifier(new EntityAttributeModifier(Identifier.of("e5c9e9c6-d7f1-4f51-8d7d-64b6d3e62667"), 10.0, EntityAttributeModifier.Operation.ADD_VALUE));
        }
        if (miningSpeed != null) {
            miningSpeed.removeModifier(Identifier.of("e5c9e9c6-d7f1-4f51-8d7d-64b6d3e66354"));
        }
        if (hitSpeed != null) {
            hitSpeed.removeModifier(Identifier.of("e5c9e9c6-d7f1-4f51-8d7d-64b6d3e28567"));
        }
    }
}