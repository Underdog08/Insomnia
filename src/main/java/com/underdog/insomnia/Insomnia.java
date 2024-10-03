package com.underdog.insomnia;

import com.underdog.insomnia.content.block.ModBlocks;
import com.underdog.insomnia.content.effect.FatigueEffect;
import com.underdog.insomnia.content.effect.InfectedEffect;
import com.underdog.insomnia.content.item.ModItemGroups;
import com.underdog.insomnia.content.item.ModItems;
import net.fabricmc.api.ModInitializer;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Insomnia implements ModInitializer {
	public static final String MOD_ID = "insomnia";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public static final RegistryKey<DamageType> INFECTION_DAMAGE = RegistryKey.of(RegistryKeys.DAMAGE_TYPE, Identifier.of(MOD_ID, "infection"));
	public static final RegistryEntry<StatusEffect> INFECTED;
	public static final RegistryEntry<StatusEffect> FATIGUE;

	static {
		INFECTED = Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(MOD_ID, "infected"), new InfectedEffect());
		FATIGUE = Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(MOD_ID, "fatigue"), new FatigueEffect());
	}

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModItemGroups.registerItemGroups();
		ModBlocks.registerModBlocks();
		Registry.register(Registries.SOUND_EVENT, Identifier.of(MOD_ID, "ambient"),
				SoundEvent.of(Identifier.of(MOD_ID, "ambient")));
		Registry.register(Registries.SOUND_EVENT, Identifier.of(MOD_ID, "music_forest"),
				SoundEvent.of(Identifier.of(MOD_ID, "music_forest")));
	}
}