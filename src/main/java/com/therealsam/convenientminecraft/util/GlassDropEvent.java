package com.therealsam.convenientminecraft.util;

import com.therealsam.convenientminecraft.item.custom.BlazingPickaxeItem;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jspecify.annotations.Nullable;

public class GlassDropEvent implements PlayerBlockBreakEvents.Before{
    @Override
    public boolean beforeBlockBreak(World world, PlayerEntity playerEntity, BlockPos blockPos, BlockState blockState, @Nullable BlockEntity blockEntity) {
        if (!world.isClient() && blockState.isIn(ModTags.Blocks.GLASSES)) {
            ItemStack shouldDrop = new ItemStack(blockState.getBlock().asItem(), 1);
            if (!shouldDrop.isEmpty()) {
                Block.dropStack(world, blockPos, shouldDrop);
                world.removeBlock(blockPos, false);
                return false;
            }
        }
        return true;
    }
}
