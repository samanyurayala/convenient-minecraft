package com.therealsam.convenientminecraft.mixin;

import net.minecraft.block.AnvilBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.screen.AnvilScreenHandler;
import net.minecraft.screen.Property;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(AnvilScreenHandler.class)
public class AnvilMixin {
    @ModifyConstant(method = "updateResult", constant = @Constant(intValue = 40))
    private int removeExpensive(int og) {
        return Integer.MAX_VALUE;
    }

}
