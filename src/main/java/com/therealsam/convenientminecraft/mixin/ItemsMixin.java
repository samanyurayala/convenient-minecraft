package com.therealsam.convenientminecraft.mixin;

import net.minecraft.component.DataComponentTypes;
import net.minecraft.item.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Arrays;

@Mixin(ItemStack.class)
public class ItemsMixin {
    @Inject(method = "getMaxCount", at = @At("HEAD"), cancellable = true)
    private void customBucket(CallbackInfoReturnable<Integer> cir) {
        Item[] stackableItems = {Items.RABBIT_STEW, Items.BEETROOT_SOUP, Items.MUSHROOM_STEW, Items.SUSPICIOUS_STEW, Items.MILK_BUCKET, Items.ENCHANTED_BOOK};
        ItemStack stack = (ItemStack)(Object)this;
        if (stack.getItem() instanceof BucketItem || stack.getItem() instanceof PotionItem || stack.getItem() instanceof SplashPotionItem || stack.getItem() instanceof LingeringPotionItem || stack.getItem() instanceof PowderSnowBucketItem || Arrays.asList(stackableItems).contains(stack.getItem()))
            cir.setReturnValue(64);
    }
}
