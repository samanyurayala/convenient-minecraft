package com.therealsam.convenientminecraft.mixin;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.EnchantingTableBlock;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(EnchantingTableBlock.class)
public class EnchantingTableBlockMixin {
    @Inject(method = "onBroken", at = @At("HEAD"))
    private void dropLapis(WorldAccess world, BlockPos pos, BlockState state, CallbackInfo ci) {
        if (!world.isClient()) {
            ItemStack item = EnchantingTableMixin.lapis.get(pos);
            if (item != null && !item.isEmpty()) {
                Inventory lapisInv = new SimpleInventory(1);
                lapisInv.setStack(0, item.copy());
                ItemScatterer.spawn((World) world, pos, lapisInv);
                EnchantingTableMixin.lapis.remove(pos);
            }
        }
    }
}
