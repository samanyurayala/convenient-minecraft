package com.therealsam.convenientminecraft.datagen;

import com.therealsam.convenientminecraft.block.ModBlocks;
import com.therealsam.convenientminecraft.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Blocks;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        valueLookupBuilder(ModTags.Blocks.INCORRECT_FOR_BLAZING_TOOL)
                .addOptionalTag(BlockTags.INCORRECT_FOR_IRON_TOOL);
        valueLookupBuilder(ModTags.Blocks.GLASSES)
                .add(Blocks.GLASS,
                        Blocks.GLASS_PANE,
                        Blocks.WHITE_STAINED_GLASS,
                        Blocks.WHITE_STAINED_GLASS_PANE,
                        Blocks.ORANGE_STAINED_GLASS,
                        Blocks.ORANGE_STAINED_GLASS_PANE,
                        Blocks.MAGENTA_STAINED_GLASS,
                        Blocks.MAGENTA_STAINED_GLASS_PANE,
                        Blocks.LIGHT_BLUE_STAINED_GLASS,
                        Blocks.LIGHT_BLUE_STAINED_GLASS_PANE,
                        Blocks.YELLOW_STAINED_GLASS,
                        Blocks.YELLOW_STAINED_GLASS_PANE,
                        Blocks.LIME_STAINED_GLASS,
                        Blocks.LIME_STAINED_GLASS_PANE,
                        Blocks.PINK_STAINED_GLASS,
                        Blocks.PINK_STAINED_GLASS_PANE,
                        Blocks.GRAY_STAINED_GLASS,
                        Blocks.GRAY_STAINED_GLASS_PANE,
                        Blocks.LIGHT_GRAY_STAINED_GLASS,
                        Blocks.LIGHT_GRAY_STAINED_GLASS_PANE,
                        Blocks.CYAN_STAINED_GLASS,
                        Blocks.CYAN_STAINED_GLASS_PANE,
                        Blocks.PURPLE_STAINED_GLASS,
                        Blocks.PURPLE_STAINED_GLASS_PANE,
                        Blocks.BLUE_STAINED_GLASS,
                        Blocks.BLUE_STAINED_GLASS_PANE,
                        Blocks.BROWN_STAINED_GLASS,
                        Blocks.BROWN_STAINED_GLASS_PANE,
                        Blocks.GREEN_STAINED_GLASS,
                        Blocks.GREEN_STAINED_GLASS_PANE,
                        Blocks.RED_STAINED_GLASS,
                        Blocks.RED_STAINED_GLASS_PANE,
                        Blocks.BLACK_STAINED_GLASS,
                        Blocks.BLACK_STAINED_GLASS_PANE);
        valueLookupBuilder(BlockTags.RAILS)
                .add(ModBlocks.COPPER_RAIL);
    }
}
