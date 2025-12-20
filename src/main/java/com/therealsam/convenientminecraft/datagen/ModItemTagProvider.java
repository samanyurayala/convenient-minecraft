package com.therealsam.convenientminecraft.datagen;

import com.therealsam.convenientminecraft.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        valueLookupBuilder(ItemTags.MINING_ENCHANTABLE)
                .add(ModItems.BLAZING_PICKAXE);
        valueLookupBuilder(ItemTags.DURABILITY_ENCHANTABLE)
                .add(ModItems.BLAZING_PICKAXE);
        valueLookupBuilder(ItemTags.PICKAXES)
                .add(ModItems.BLAZING_PICKAXE);
    }
}
