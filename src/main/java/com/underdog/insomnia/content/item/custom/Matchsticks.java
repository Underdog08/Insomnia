package com.underdog.insomnia.content.item.custom;

import net.minecraft.block.*;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.FlintAndSteelItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;

import java.util.Random;

public class Matchsticks extends FlintAndSteelItem {
    public Matchsticks(Settings settings) { super(settings); }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        PlayerEntity playerEntity = context.getPlayer();
        World world = context.getWorld();
        BlockPos blockPos = context.getBlockPos();
        Random random = new Random();
        BlockPos blockPos2 = blockPos.offset(context.getSide());
        ItemStack itemStack = context.getStack();
        BlockState blockState2 = AbstractFireBlock.getState(world, blockPos2);

        if (random.nextInt(8) == 0) {

            if (AbstractFireBlock.canPlaceAt(world, blockPos2, context.getHorizontalPlayerFacing())) {

                world.setBlockState(blockPos2, blockState2, 11);
                world.emitGameEvent(playerEntity, GameEvent.BLOCK_PLACE, blockPos);
            }
        }
        if (playerEntity instanceof ServerPlayerEntity) {

            itemStack.damage(1, playerEntity, LivingEntity.getSlotForHand(context.getHand()));
        }
        world.playSound(playerEntity, blockPos2, SoundEvents.ITEM_FLINTANDSTEEL_USE, SoundCategory.BLOCKS, 1.0F, world.getRandom().nextFloat() * 0.4F + 0.8F);
        return ActionResult.success(world.isClient());
    }
}