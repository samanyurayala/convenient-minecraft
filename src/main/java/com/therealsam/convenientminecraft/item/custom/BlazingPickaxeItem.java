package com.therealsam.convenientminecraft.item.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.ToolComponent;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.ExperienceOrbEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class BlazingPickaxeItem extends Item {
    public BlazingPickaxeItem(Settings settings) {
        super(settings);
    }

    public boolean customDrop(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner) {
        if (!world.isClient() && miner instanceof PlayerEntity player && !player.isInCreativeMode()) {
            Item shouldDrop;
            if (state.isIn(BlockTags.IRON_ORES)) {
                shouldDrop = Items.IRON_INGOT;
            } else if (state.isIn(BlockTags.GOLD_ORES)) {
                shouldDrop = Items.GOLD_INGOT;
            } else if (state.isIn(BlockTags.COPPER_ORES)) {
                shouldDrop = Items.COPPER_INGOT;
            } else {
                return true;
            }

            int fortuneDrop = world.random.nextInt(EnchantmentHelper.getLevel(world.getRegistryManager().getEntryOrThrow(Enchantments.FORTUNE), stack) + 1) + 1;

            world.removeBlock(pos, false);
            Block.dropStack(world, pos, new ItemStack(shouldDrop, fortuneDrop));
            stack.damage(1, player, EquipmentSlot.MAINHAND);
            if (world instanceof ServerWorld server) {
                int experienceAmount = world.random.nextInt(3) + 1;
                ExperienceOrbEntity.spawn(server, Vec3d.ofCenter(pos), experienceAmount);
            }
            return false;
        }
        return true;
    }

}
