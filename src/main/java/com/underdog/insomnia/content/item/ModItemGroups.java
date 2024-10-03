package com.underdog.insomnia.content.item;

import com.underdog.insomnia.Insomnia;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {

    public static final ItemGroup INSOMNIA_ITEMS = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(Insomnia.MOD_ID, "insomnia_blocks"),
            FabricItemGroup.builder()
                    .icon(() -> new ItemStack(ModItems.MATCHSTICKS))
                    .displayName(Text.translatable("itemgroup.insomnia.items"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.FLINT_AXE);
                        entries.add(ModItems.MATCHSTICKS);
                        entries.add(ModItems.PLANT_FIBERS);
                    })
                    .build());


    public static void registerItemGroups() {}
}