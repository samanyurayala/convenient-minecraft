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
        Item[] stackableItems = {Items.RABBIT_STEW, Items.BEETROOT_SOUP, Items.MUSHROOM_STEW, Items.SUSPICIOUS_STEW, Items.MILK_BUCKET, Items.ENCHANTED_BOOK, Items.SHULKER_BOX};
        ItemStack stack = (ItemStack)(Object)this;
        Item item = stack.getItem();
        if (item instanceof BucketItem || item instanceof PotionItem || item instanceof SplashPotionItem || item instanceof LingeringPotionItem || item instanceof PowderSnowBucketItem || Arrays.asList(stackableItems).contains(item))
            cir.setReturnValue(64);
    }
}
