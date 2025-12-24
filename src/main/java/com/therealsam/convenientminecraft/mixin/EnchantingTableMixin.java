package com.therealsam.convenientminecraft.mixin;

import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.EnchantingTableBlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.EnchantmentScreenHandler;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.HashMap;
import java.util.Map;

@Mixin(EnchantmentScreenHandler.class)
public class EnchantingTableMixin {
    @Shadow @Final Inventory inventory;
    @Shadow @Final ScreenHandlerContext context;
    private static final Map<BlockPos, ItemStack> lapis = new HashMap<>();

    @Inject(method = "onClosed", at = @At("HEAD"), cancellable = true)
    private void keepInventory(PlayerEntity player, CallbackInfo ci) {
        context.run((world, blockPos) -> {
            if (!world.isClient()) {
            lapis.put(blockPos, inventory.getStack(1).copy());
        }});
        ci.cancel();

    }

    @Inject(method = "<init>(ILnet/minecraft/entity/player/PlayerInventory;Lnet/minecraft/screen/ScreenHandlerContext;)V", at = @At("RETURN"))
    private void lapisEnchantingTable(int syncId,  PlayerInventory playerInventory, ScreenHandlerContext context, CallbackInfo ci) {
        context.run((world, blockPos) -> {
            ItemStack item = lapis.get(blockPos);
            if (item != null && inventory.getStack(1).isEmpty()) inventory.setStack(1, item.copy());
        });


    }
}
