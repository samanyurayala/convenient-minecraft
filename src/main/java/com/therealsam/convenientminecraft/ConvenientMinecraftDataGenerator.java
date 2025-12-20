package com.therealsam.convenientminecraft;

import com.therealsam.convenientminecraft.datagen.ModBlockTagProvider;
import com.therealsam.convenientminecraft.datagen.ModItemTagProvider;
import com.therealsam.convenientminecraft.datagen.ModModelProvider;
import com.therealsam.convenientminecraft.datagen.ModRecipeProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class ConvenientMinecraftDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
        pack.addProvider(ModModelProvider::new);
        pack.addProvider(ModBlockTagProvider::new);
        pack.addProvider(ModItemTagProvider::new);
        pack.addProvider(ModRecipeProvider::new);
	}
}
