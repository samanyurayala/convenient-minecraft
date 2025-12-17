package com.therealsam.convenientminecraft;

import com.therealsam.convenientminecraft.util.ModLootTableModifiers;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConvenientMinecraft implements ModInitializer {
	public static final String MOD_ID = "convenientminecraft";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
        ModLootTableModifiers.modifyLootTables();
	}
}