package com.underdog.insomnia.mixin;

import net.minecraft.block.entity.BarrelBlockEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.GenericContainerScreenHandler;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.collection.DefaultedList;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(BarrelBlockEntity.class)
public class BarrelBlockEntityMixin {

    @Shadow public DefaultedList<ItemStack> inventory;

    /**
     @author me
     @reason idk
     **/
    @Overwrite
    public int size() {
        return 9;
    }

    /**
     @author me
     @reason idk
     **/
    @Overwrite
    public ScreenHandler createScreenHandler(int syncId, PlayerInventory playerInventory) {
        // Cast BarrelBlockEntity to Inventory because it implements Inventory interface
        Inventory inventory = (Inventory) (Object) this;
        return new GenericContainerScreenHandler(ScreenHandlerType.GENERIC_9X1, syncId, playerInventory, inventory, 1);
    }
}