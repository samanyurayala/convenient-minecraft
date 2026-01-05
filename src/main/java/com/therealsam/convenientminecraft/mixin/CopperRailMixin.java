package com.therealsam.convenientminecraft.mixin;

import com.therealsam.convenientminecraft.ConvenientMinecraft;
import com.therealsam.convenientminecraft.block.CopperRailBlock;
import com.therealsam.convenientminecraft.block.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.PoweredRailBlock;
import net.minecraft.block.enums.RailShape;
import net.minecraft.entity.vehicle.AbstractMinecartEntity;
import net.minecraft.entity.vehicle.DefaultMinecartController;
import net.minecraft.entity.vehicle.MinecartController;
import net.minecraft.entity.vehicle.MinecartEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

@Mixin(DefaultMinecartController.class)
public abstract class CopperRailMixin {

    @Inject(method = "moveOnRail", at = @At("TAIL"))
    public void copperRail(ServerWorld world, CallbackInfo ci) {
        AbstractMinecartEntity minecart = ((MinecartAccessorMixin) this).getMinecart();
        BlockPos blockPos = minecart.getBlockPos();
        BlockState blockState = world.getBlockState(blockPos);
        if (blockState.isOf(ModBlocks.COPPER_RAIL) && blockState.get(CopperRailBlock.POWERED)) {
            ConvenientMinecraft.LOGGER.info(minecart.getVelocity().toString());
            Vec3d vec3d = minecart.getVelocity();
            double v = vec3d.horizontalLength();
            if (v > 0.01) {
                minecart.setVelocity(vec3d.add(vec3d.x / v * 2.0, 0.0, vec3d.z / v * 2.0));
                ConvenientMinecraft.LOGGER.info("Afte: " + minecart.getVelocity().toString());
            }
        }
    }

    @Inject(method = "getMaxSpeed", at = @At("HEAD"), cancellable = true)
    public void getMaxSpeed(ServerWorld world, CallbackInfoReturnable<Double> cir) {
        AbstractMinecartEntity minecart = ((MinecartAccessorMixin) this).getMinecart();
        BlockPos blockPos = minecart.getBlockPos();
        BlockState blockState = world.getBlockState(blockPos);
        if (blockState.isOf(ModBlocks.COPPER_RAIL) && blockState.get(CopperRailBlock.POWERED)) {
            cir.setReturnValue(minecart.isTouchingWater() ? 1.0 : 2.0);
        }
    }

    @Inject(method = "limitSpeed", at = @At("HEAD"), cancellable = true)
    public void limitSpeed(Vec3d velocity, CallbackInfoReturnable<Vec3d> cir) {
        AbstractMinecartEntity minecart = ((MinecartAccessorMixin) this).getMinecart();
        BlockPos blockPos = minecart.getBlockPos();
        BlockState blockState = minecart.getEntityWorld().getBlockState(blockPos);
        if (blockState.isOf(ModBlocks.COPPER_RAIL) && blockState.get(CopperRailBlock.POWERED)) {
            cir.setReturnValue(!Double.isNaN(velocity.x) && !Double.isNaN(velocity.y) && !Double.isNaN(velocity.z)
                    ? new Vec3d(MathHelper.clamp(velocity.x, -2.0, 2.0), velocity.y, MathHelper.clamp(velocity.z, -2.0, 2.0))
                    : Vec3d.ZERO);
        }
    }
}
