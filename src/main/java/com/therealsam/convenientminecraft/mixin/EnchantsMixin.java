package com.therealsam.convenientminecraft.mixin;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.registry.entry.RegistryEntry;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Enchantment.class)
public class EnchantsMixin {
    @Inject(method = "canBeCombined", at = @At("HEAD"), cancellable = true)
    private static void allowBow(RegistryEntry<Enchantment> first, RegistryEntry<Enchantment> second, CallbackInfoReturnable<Boolean> cir) {
        if ((first.matchesKey(Enchantments.INFINITY) && second.matchesKey(Enchantments.MENDING)) || (first.matchesKey(Enchantments.MENDING) && second.matchesKey(Enchantments.INFINITY))) cir.setReturnValue(true);
    }
}
