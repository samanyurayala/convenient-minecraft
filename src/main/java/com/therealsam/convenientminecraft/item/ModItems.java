package com.therealsam.convenientminecraft.item;

import com.therealsam.convenientminecraft.ConvenientMinecraft;
import com.therealsam.convenientminecraft.item.custom.BlazingPickaxeItem;
import net.fabricmc.fabric.api.item.v1.FabricItem;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class ModItems {
    public static final Item BLAZING_PICKAXE = registerItem("blazing_pickaxe", new BlazingPickaxeItem(new Item.Settings().pickaxe(ModToolMaterials.BLAZING_TOOL_MATERIAL, 1.0F, -2.8F).registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(ConvenientMinecraft.MOD_ID,"blazing_pickaxe")))));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(ConvenientMinecraft.MOD_ID, name), item);
    }

    public static void registerModItems() {
        ConvenientMinecraft.LOGGER.info("Registering Mod Items for " + ConvenientMinecraft.MOD_ID);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(entries -> {
            entries.add(BLAZING_PICKAXE);
        });
    }

}
