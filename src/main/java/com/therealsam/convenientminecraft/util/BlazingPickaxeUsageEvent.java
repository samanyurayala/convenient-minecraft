package com.therealsam.convenientminecraft.util;

import com.therealsam.convenientminecraft.item.custom.BlazingPickaxeItem;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jspecify.annotations.Nullable;

public class BlazingPickaxeUsageEvent implements PlayerBlockBreakEvents.Before{
    @Override
    public boolean beforeBlockBreak(World world, PlayerEntity playerEntity, BlockPos blockPos, BlockState blockState, @Nullable BlockEntity blockEntity) {
        ItemStack stack = playerEntity.getMainHandStack();
        if (stack.getItem() instanceof BlazingPickaxeItem custom) {
            return custom.customDrop(stack, world, blockState, blockPos, playerEntity);
        }
        return true;
    }
}
