package com.underdog.insomnia.content.item;

import com.underdog.insomnia.Insomnia;
import com.underdog.insomnia.content.item.custom.Matchsticks;
import net.minecraft.item.AxeItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item FLINT_AXE = registerItem("flint_axe", new AxeItem(ModToolMaterial.FLINT, new Item.Settings()
            .attributeModifiers(AxeItem.createAttributeModifiers(ModToolMaterial.FLINT, 1.0F, -3.2F))));

    public static final Item MATCHSTICKS = registerItem("matchsticks", new Matchsticks(new Item.Settings()
            .maxDamage(5)
            .maxCount(1)));

    public static final Item PLANT_FIBERS = registerItem("plant_fibers", new Item(new Item.Settings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(Insomnia.MOD_ID, name), item);
    }

    public static void registerModItems() {}
}
