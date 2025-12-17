package com.therealsam.convenientminecraft.item;

import net.fabricmc.fabric.api.item.v1.FabricItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class ModItems {
    public static void registerModItems() {

    }

    public static <T extends Item>T modifyItem(Item currentItem, Function<Item.Settings, Item.Settings> changedSetting) {
        int rawId = Registries.ITEM.getRawId(currentItem);
        Identifier id = Registries.ITEM.getId(currentItem);
        return (T)currentItem;
    }
}
