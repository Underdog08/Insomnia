package com.underdog.insomnia.world;

import com.underdog.insomnia.Insomnia;
import net.minecraft.util.Identifier;
import terrablender.api.Regions;
import terrablender.api.TerraBlenderApi;

public class ModTerrablenderAPI implements TerraBlenderApi {
    @Override
    public void onTerraBlenderInitialized() {
        Regions.register(new ModOverworldRegion(Identifier.of(Insomnia.MOD_ID, "overworld")));
    }
}