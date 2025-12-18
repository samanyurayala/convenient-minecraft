package com.therealsam.convenientminecraft;

import com.therealsam.convenientminecraft.util.ModLootTableModifiers;
import net.fabricmc.api.ModInitializer;

import net.minecraft.component.DataComponentTypes;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConvenientMinecraft implements ModInitializer {
	public static final String MOD_ID = "convenientminecraft";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
        ModLootTableModifiers.modifyLootTables();
        //ItemStack bucket = new ItemStack(Items.BUCKET);
        //bucket.set(DataComponentTypes.MAX_STACK_SIZE, 64);
	}
}