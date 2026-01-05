package com.therealsam.convenientminecraft.item;

import com.therealsam.convenientminecraft.ConvenientMinecraft;
import com.therealsam.convenientminecraft.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup CONVENIENT_MINECRAFT_ITEMS_GROUP = Registry.register(Registries.ITEM_GROUP, Identifier.of(ConvenientMinecraft.MOD_ID, "convenient_minecraft_items"), FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.BLAZING_PICKAXE)).displayName(Text.translatable("itemgroup.convenientminecraft.convenient_minecraft_items")).entries((displayContext, entries) -> {entries.add(ModItems.BLAZING_PICKAXE); entries.add(ModBlocks.COPPER_RAIL);}).build());
    public static void registerItemGroups() {
        ConvenientMinecraft.LOGGER.info("Registering ItemGroups for " + ConvenientMinecraft.MOD_ID);
    }
}
