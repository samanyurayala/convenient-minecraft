package com.therealsam.convenientminecraft.datagen;

import com.therealsam.convenientminecraft.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.data.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;

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
                        .pattern("ILI")
                        .pattern(" S ")
                        .pattern(" S ")
                        .input('L', Items.LAVA_BUCKET)
                        .input('I', Items.IRON_INGOT)
                        .input('S', Items.STICK)
                        .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
                        .offerTo(exporter, getRecipeName(ModItems.BLAZING_PICKAXE));
                createShaped(RecipeCategory.COMBAT, Items.TRIDENT)
                        .pattern("SSS")
                        .pattern(" B ")
                        .pattern(" B ")
                        .input('S', Items.PRISMARINE_SHARD)
                        .input('B', Items.BREEZE_ROD)
                        .criterion(hasItem(Items.PRISMARINE_SHARD), conditionsFromItem(Items.PRISMARINE_SHARD))
                        .offerTo(exporter);
                final ItemConvertible[] VANILLA_STAIRS = {Items.OAK_STAIRS, Items.SPRUCE_STAIRS, Items.BIRCH_STAIRS, Items.JUNGLE_STAIRS, Items.ACACIA_STAIRS, Items.DARK_OAK_STAIRS, Items.MANGROVE_STAIRS, Items.CHERRY_STAIRS, Items.PALE_OAK_STAIRS, Items.BAMBOO_STAIRS, Items.BAMBOO_MOSAIC_STAIRS, Items.CRIMSON_STAIRS, Items.WARPED_STAIRS, Items.STONE_STAIRS, Items.COBBLESTONE_STAIRS, Items.MOSSY_COBBLESTONE_STAIRS, Items.STONE_BRICK_STAIRS, Items.MOSSY_STONE_BRICK_STAIRS, Items.BRICK_STAIRS, Items.END_STONE_BRICK_STAIRS, Items.PURPUR_STAIRS, Items.MUD_BRICK_STAIRS, Items.RESIN_BRICK_STAIRS, Items.COBBLED_DEEPSLATE_STAIRS, Items.POLISHED_DEEPSLATE_STAIRS, Items.DEEPSLATE_BRICK_STAIRS, Items.DEEPSLATE_TILE_STAIRS, Items.TUFF_STAIRS, Items.POLISHED_TUFF_STAIRS, Items.TUFF_BRICK_STAIRS, Items.QUARTZ_STAIRS, Items.SMOOTH_QUARTZ_STAIRS, Items.SANDSTONE_STAIRS, Items.SMOOTH_SANDSTONE_STAIRS, Items.RED_SANDSTONE_STAIRS, Items.SMOOTH_RED_SANDSTONE_STAIRS, Items.NETHER_BRICK_STAIRS, Items.RED_NETHER_BRICK_STAIRS, Items.BLACKSTONE_STAIRS, Items.POLISHED_BLACKSTONE_STAIRS, Items.POLISHED_BLACKSTONE_BRICK_STAIRS, Items.GRANITE_STAIRS, Items.POLISHED_GRANITE_STAIRS, Items.DIORITE_STAIRS, Items.POLISHED_DIORITE_STAIRS, Items.ANDESITE_STAIRS, Items.POLISHED_ANDESITE_STAIRS, Items.PRISMARINE_STAIRS, Items.PRISMARINE_BRICK_STAIRS, Items.DARK_PRISMARINE_STAIRS, Items.CUT_COPPER_STAIRS, Items.EXPOSED_CUT_COPPER_STAIRS, Items.WEATHERED_CUT_COPPER_STAIRS, Items.OXIDIZED_CUT_COPPER_STAIRS, Items.WAXED_CUT_COPPER_STAIRS, Items.WAXED_EXPOSED_CUT_COPPER_STAIRS, Items.WAXED_WEATHERED_CUT_COPPER_STAIRS, Items.WAXED_OXIDIZED_CUT_COPPER_STAIRS};
                final ItemConvertible[] VANILLA_STAIRS_INGREDIENTS = {Items.OAK_PLANKS, Items.SPRUCE_PLANKS, Items.BIRCH_PLANKS, Items.JUNGLE_PLANKS, Items.ACACIA_PLANKS, Items.DARK_OAK_PLANKS, Items.MANGROVE_PLANKS, Items.CHERRY_PLANKS, Items.PALE_OAK_PLANKS, Items.BAMBOO_BLOCK, Items.BAMBOO_MOSAIC, Items.CRIMSON_PLANKS, Items.WARPED_PLANKS, Items.STONE, Items.COBBLESTONE, Items.MOSSY_COBBLESTONE, Items.STONE_BRICKS, Items.MOSSY_STONE_BRICKS, Items.BRICKS, Items.END_STONE_BRICKS, Items.PURPUR_BLOCK, Items.MUD_BRICKS, Items.RESIN_BRICKS, Items.COBBLED_DEEPSLATE, Items.POLISHED_DEEPSLATE, Items.DEEPSLATE_BRICKS, Items.DEEPSLATE_TILES, Items.TUFF, Items.POLISHED_TUFF, Items.TUFF_BRICKS, Items.QUARTZ_BLOCK, Items.SMOOTH_QUARTZ, Items.SANDSTONE, Items.SMOOTH_SANDSTONE, Items.RED_SANDSTONE, Items.SMOOTH_RED_SANDSTONE, Items.NETHER_BRICKS, Items.RED_NETHER_BRICKS, Items.BLACKSTONE, Items.POLISHED_BLACKSTONE, Items.POLISHED_BLACKSTONE_BRICKS, Items.GRANITE, Items.POLISHED_GRANITE, Items.DIORITE, Items.POLISHED_DIORITE, Items.ANDESITE, Items.POLISHED_ANDESITE, Items.PRISMARINE, Items.PRISMARINE_BRICKS, Items.DARK_PRISMARINE, Items.COPPER_BLOCK, Items.EXPOSED_COPPER, Items.WEATHERED_COPPER, Items.OXIDIZED_COPPER, Items.WAXED_COPPER_BLOCK, Items.WAXED_EXPOSED_COPPER, Items.WAXED_WEATHERED_COPPER, Items.WAXED_OXIDIZED_COPPER};
                for (int i = 0; i < VANILLA_STAIRS.length; i++) {
                    createBetterStairRecipe(VANILLA_STAIRS[i], VANILLA_STAIRS_INGREDIENTS[i], exporter);
                }
                final ItemConvertible[] VANILLA_TRAPDOORS = {Items.OAK_TRAPDOOR, Items.SPRUCE_TRAPDOOR, Items.BIRCH_TRAPDOOR, Items.JUNGLE_TRAPDOOR, Items.ACACIA_TRAPDOOR, Items.DARK_OAK_TRAPDOOR, Items.MANGROVE_TRAPDOOR, Items.CHERRY_TRAPDOOR, Items.PALE_OAK_TRAPDOOR, Items.BAMBOO_TRAPDOOR, Items.CRIMSON_TRAPDOOR, Items.WARPED_TRAPDOOR};
                final ItemConvertible[] VANILLA_METAL_TRAPDOORS = {Items.IRON_TRAPDOOR, Items.COPPER_TRAPDOOR};
                final ItemConvertible[] VANILLA_TRAPDOORS_INGREDIENTS = {Items.OAK_PLANKS, Items.SPRUCE_PLANKS, Items.BIRCH_PLANKS, Items.JUNGLE_PLANKS, Items.ACACIA_PLANKS, Items.DARK_OAK_PLANKS, Items.MANGROVE_PLANKS, Items.CHERRY_PLANKS, Items.PALE_OAK_PLANKS, Items.BAMBOO_PLANKS, Items.CRIMSON_PLANKS, Items.WARPED_PLANKS};
                final ItemConvertible[] VANILLA_METAL_TRAPDOORS_INGREDIENTS = {Items.IRON_INGOT, Items.COPPER_INGOT};
                for (int i = 0; i < VANILLA_TRAPDOORS.length; i++) {
                    createBetterTrapdoorRecipe(VANILLA_TRAPDOORS[i], VANILLA_TRAPDOORS_INGREDIENTS[i], exporter);
                }
                for (int i = 0; i < VANILLA_METAL_TRAPDOORS.length; i++) {
                    createBetterMetalTrapdoorRecipe(VANILLA_METAL_TRAPDOORS[i], VANILLA_METAL_TRAPDOORS_INGREDIENTS[i], exporter);
                }
            }

            private void createBetterStairRecipe(ItemConvertible stair, ItemConvertible ingredient, RecipeExporter exporter) {
                Ingredient useIngredient = Ingredient.ofItem(ingredient);
                ShapedRecipeJsonBuilder.create(registryLookup.getOrThrow(RegistryKeys.ITEM), RecipeCategory.BUILDING_BLOCKS, stair, 4)
                        .pattern("S  ")
                        .pattern("SS ")
                        .pattern("   ")
                        .input('S', useIngredient)
                        .criterion(hasItem(ingredient), conditionsFromItem(ingredient))
                        .offerTo(exporter);
            }

            private void createBetterTrapdoorRecipe(ItemConvertible trapdoor, ItemConvertible ingredient, RecipeExporter exporter) {
                Ingredient useIngredient = Ingredient.ofItem(ingredient);
                ShapedRecipeJsonBuilder.create(registryLookup.getOrThrow(RegistryKeys.ITEM), RecipeCategory.BUILDING_BLOCKS, trapdoor, 6)
                        .pattern("   ")
                        .pattern("SSS")
                        .pattern("SSS")
                        .input('S', useIngredient)
                        .criterion(hasItem(ingredient), conditionsFromItem(ingredient))
                        .offerTo(exporter);
            }

            private void createBetterMetalTrapdoorRecipe(ItemConvertible trapdoor, ItemConvertible ingredient, RecipeExporter exporter) {
                Ingredient useIngredient = Ingredient.ofItem(ingredient);
                RecipeCategory category = (trapdoor == Items.IRON_TRAPDOOR) ? RecipeCategory.REDSTONE : RecipeCategory.BUILDING_BLOCKS;
                ShapedRecipeJsonBuilder.create(registryLookup.getOrThrow(RegistryKeys.ITEM), category, trapdoor, 4)
                        .pattern("   ")
                        .pattern("SS ")
                        .pattern("SS ")
                        .input('S', useIngredient)
                        .criterion(hasItem(ingredient), conditionsFromItem(ingredient))
                        .offerTo(exporter);
            }
        };
    }



    @Override
    public String getName() {
        return "";
    }
}
