package com.underdog.insomnia.world;

import com.mojang.datafixers.util.Pair;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.biome.source.util.MultiNoiseUtil;
import terrablender.api.Region;
import terrablender.api.RegionType;

import java.util.function.Consumer;

public class ModOverworldRegion extends Region {
    public ModOverworldRegion(Identifier name) {
        super(name, RegionType.OVERWORLD, 99999999);
    }

    @Override
    public void addBiomes(Registry<Biome> registry, Consumer<Pair<MultiNoiseUtil.NoiseHypercube, RegistryKey<Biome>>> mapper) {
        this.addModifiedVanillaOverworldBiomes(mapper, modifiedVanillaOverworldBuilder -> {
            modifiedVanillaOverworldBuilder.replaceBiome(BiomeKeys.BADLANDS, BiomeKeys.FOREST);
            modifiedVanillaOverworldBuilder.replaceBiome(BiomeKeys.BAMBOO_JUNGLE, BiomeKeys.FOREST);
            modifiedVanillaOverworldBuilder.replaceBiome(BiomeKeys.BIRCH_FOREST, BiomeKeys.FOREST);
            modifiedVanillaOverworldBuilder.replaceBiome(BiomeKeys.BEACH, BiomeKeys.FOREST);
            modifiedVanillaOverworldBuilder.replaceBiome(BiomeKeys.CHERRY_GROVE, BiomeKeys.FOREST);
            modifiedVanillaOverworldBuilder.replaceBiome(BiomeKeys.COLD_OCEAN, BiomeKeys.OCEAN);
            modifiedVanillaOverworldBuilder.replaceBiome(BiomeKeys.DARK_FOREST, BiomeKeys.FOREST);
            modifiedVanillaOverworldBuilder.replaceBiome(BiomeKeys.DEEP_COLD_OCEAN, BiomeKeys.OCEAN);
            modifiedVanillaOverworldBuilder.replaceBiome(BiomeKeys.DEEP_DARK, BiomeKeys.FOREST);
            modifiedVanillaOverworldBuilder.replaceBiome(BiomeKeys.DEEP_FROZEN_OCEAN, BiomeKeys.OCEAN);
            modifiedVanillaOverworldBuilder.replaceBiome(BiomeKeys.DEEP_LUKEWARM_OCEAN, BiomeKeys.OCEAN);
            modifiedVanillaOverworldBuilder.replaceBiome(BiomeKeys.DEEP_OCEAN, BiomeKeys.OCEAN);
            modifiedVanillaOverworldBuilder.replaceBiome(BiomeKeys.DESERT, BiomeKeys.FOREST);
            modifiedVanillaOverworldBuilder.replaceBiome(BiomeKeys.DRIPSTONE_CAVES, BiomeKeys.FOREST);
            modifiedVanillaOverworldBuilder.replaceBiome(BiomeKeys.ERODED_BADLANDS, BiomeKeys.FOREST);
            modifiedVanillaOverworldBuilder.replaceBiome(BiomeKeys.FLOWER_FOREST, BiomeKeys.FOREST);
            modifiedVanillaOverworldBuilder.replaceBiome(BiomeKeys.FROZEN_OCEAN, BiomeKeys.OCEAN);
            modifiedVanillaOverworldBuilder.replaceBiome(BiomeKeys.FROZEN_PEAKS, BiomeKeys.FOREST);
            modifiedVanillaOverworldBuilder.replaceBiome(BiomeKeys.FROZEN_RIVER, BiomeKeys.RIVER);
            modifiedVanillaOverworldBuilder.replaceBiome(BiomeKeys.GROVE, BiomeKeys.FOREST);
            modifiedVanillaOverworldBuilder.replaceBiome(BiomeKeys.ICE_SPIKES, BiomeKeys.OCEAN);
            modifiedVanillaOverworldBuilder.replaceBiome(BiomeKeys.JUNGLE, BiomeKeys.FOREST);
            modifiedVanillaOverworldBuilder.replaceBiome(BiomeKeys.JAGGED_PEAKS, BiomeKeys.FOREST);
            modifiedVanillaOverworldBuilder.replaceBiome(BiomeKeys.LUKEWARM_OCEAN, BiomeKeys.OCEAN);
            modifiedVanillaOverworldBuilder.replaceBiome(BiomeKeys.LUSH_CAVES, BiomeKeys.FOREST);
            modifiedVanillaOverworldBuilder.replaceBiome(BiomeKeys.MANGROVE_SWAMP, BiomeKeys.FOREST);
            modifiedVanillaOverworldBuilder.replaceBiome(BiomeKeys.MEADOW, BiomeKeys.FOREST);
            modifiedVanillaOverworldBuilder.replaceBiome(BiomeKeys.MUSHROOM_FIELDS, BiomeKeys.FOREST);
            modifiedVanillaOverworldBuilder.replaceBiome(BiomeKeys.OLD_GROWTH_BIRCH_FOREST, BiomeKeys.FOREST);
            modifiedVanillaOverworldBuilder.replaceBiome(BiomeKeys.OLD_GROWTH_PINE_TAIGA, BiomeKeys.FOREST);
            modifiedVanillaOverworldBuilder.replaceBiome(BiomeKeys.OLD_GROWTH_SPRUCE_TAIGA, BiomeKeys.FOREST);
            modifiedVanillaOverworldBuilder.replaceBiome(BiomeKeys.PLAINS, BiomeKeys.FOREST);
            modifiedVanillaOverworldBuilder.replaceBiome(BiomeKeys.SAVANNA, BiomeKeys.FOREST);
            modifiedVanillaOverworldBuilder.replaceBiome(BiomeKeys.SAVANNA_PLATEAU, BiomeKeys.FOREST);
            modifiedVanillaOverworldBuilder.replaceBiome(BiomeKeys.SNOWY_BEACH, BiomeKeys.FOREST);
            modifiedVanillaOverworldBuilder.replaceBiome(BiomeKeys.SNOWY_PLAINS, BiomeKeys.FOREST);
            modifiedVanillaOverworldBuilder.replaceBiome(BiomeKeys.SNOWY_SLOPES, BiomeKeys.FOREST);
            modifiedVanillaOverworldBuilder.replaceBiome(BiomeKeys.SNOWY_TAIGA, BiomeKeys.FOREST);
            modifiedVanillaOverworldBuilder.replaceBiome(BiomeKeys.SPARSE_JUNGLE, BiomeKeys.FOREST);
            modifiedVanillaOverworldBuilder.replaceBiome(BiomeKeys.STONY_PEAKS, BiomeKeys.FOREST);
            modifiedVanillaOverworldBuilder.replaceBiome(BiomeKeys.STONY_SHORE, BiomeKeys.FOREST);
            modifiedVanillaOverworldBuilder.replaceBiome(BiomeKeys.SUNFLOWER_PLAINS, BiomeKeys.FOREST);
            modifiedVanillaOverworldBuilder.replaceBiome(BiomeKeys.SWAMP, BiomeKeys.FOREST);
            modifiedVanillaOverworldBuilder.replaceBiome(BiomeKeys.TAIGA, BiomeKeys.FOREST);
            modifiedVanillaOverworldBuilder.replaceBiome(BiomeKeys.WARM_OCEAN, BiomeKeys.OCEAN);
            modifiedVanillaOverworldBuilder.replaceBiome(BiomeKeys.WINDSWEPT_FOREST, BiomeKeys.FOREST);
            modifiedVanillaOverworldBuilder.replaceBiome(BiomeKeys.WINDSWEPT_SAVANNA, BiomeKeys.FOREST);
            modifiedVanillaOverworldBuilder.replaceBiome(BiomeKeys.WINDSWEPT_HILLS, BiomeKeys.FOREST);
            modifiedVanillaOverworldBuilder.replaceBiome(BiomeKeys.WINDSWEPT_GRAVELLY_HILLS, BiomeKeys.FOREST);
            modifiedVanillaOverworldBuilder.replaceBiome(BiomeKeys.WOODED_BADLANDS, BiomeKeys.FOREST);
        });
    }
}