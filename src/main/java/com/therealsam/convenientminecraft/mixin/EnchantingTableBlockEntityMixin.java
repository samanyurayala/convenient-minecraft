package com.therealsam.convenientminecraft.mixin;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.entity.EnchantingTableBlockEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.math.BlockPos;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(EnchantingTableBlockEntity.class)
public class EnchantingTableBlockEntityMixin extends BlockEntity {

    public EnchantingTableBlockEntityMixin(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    private ItemStack lapis = ItemStack.EMPTY;

    public ItemStack getLapis() {
        return lapis;
    }

    public void setLapis(ItemStack lapis) {
        this.lapis = lapis.copy();
        markDirty();
    }

    @Inject(method = "readNbt", at = @At("RETURN"))
    private void readNBT(NbtCompound nbt, CallbackInfo ci) {
        if (nbt.contains("lapis")) {
            this.lapis = ItemStack.of(
        }
    }

}
