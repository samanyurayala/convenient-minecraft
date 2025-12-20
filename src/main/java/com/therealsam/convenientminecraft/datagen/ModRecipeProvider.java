package com.therealsam.convenientminecraft.datagen;

import com.therealsam.convenientminecraft.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup registryLookup, RecipeExporter exporter) {
        return new RecipeGenerator(registryLookup, exporter) {
            @Override
            public void generate() {
                createShaped(RecipeCategory.TOOLS, ModItems.BLAZING_PICKAXE)
                        .pattern("%#%")
                        .pattern(" & ")
                        .pattern(" & ")
                        .input('#', Items.LAVA_BUCKET)
                        .input('&', Items.STICK)
                        .input('%', Items.IRON_INGOT)
                        .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
                        .offerTo(exporter, getRecipeName(ModItems.BLAZING_PICKAXE));
            }
        };
    }

    @Override
    public String getName() {
        return "";
    }
}
