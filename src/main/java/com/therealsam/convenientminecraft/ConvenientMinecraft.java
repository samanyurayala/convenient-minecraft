package com.therealsam.convenientminecraft;

import com.therealsam.convenientminecraft.block.ModBlocks;
import com.therealsam.convenientminecraft.item.ModItemGroups;
import com.therealsam.convenientminecraft.item.ModItems;
import com.therealsam.convenientminecraft.util.BlazingPickaxeUsageEvent;
import com.therealsam.convenientminecraft.util.GlassDropEvent;
import com.therealsam.convenientminecraft.util.ModLootTableModifiers;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.entity.event.v1.ServerLivingEntityEvents;
import net.fabricmc.fabric.api.entity.event.v1.ServerPlayerEvents;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ConvenientMinecraft implements ModInitializer {
	public static final String MOD_ID = "convenientminecraft";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	private final Map<UUID, String> coords = new HashMap<>();

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();
        ModItems.registerModItems();
		ModBlocks.registerModBlocks();
        PlayerBlockBreakEvents.BEFORE.register(new BlazingPickaxeUsageEvent());
        PlayerBlockBreakEvents.BEFORE.register(new GlassDropEvent());
        ModLootTableModifiers.modifyLootTables();
		ServerLivingEntityEvents.AFTER_DEATH.register((entity, server) -> {
			if (entity instanceof PlayerEntity player) {
				coords.put(player.getUuid(), player.getBlockX() + ", " + player.getBlockY() + ", " + player.getBlockZ());
			}
		});
		ServerPlayerEvents.AFTER_RESPAWN.register(((serverPlayerEntity, serverPlayerEntity1, b) -> {
			String playerCoords = coords.remove(serverPlayerEntity.getUuid());
			if (playerCoords != null) {
				serverPlayerEntity.sendMessage(Text.literal("You died at " + playerCoords), false);
			}
		}));
		ServerPlayConnectionEvents.DISCONNECT.register(((serverPlayerEntity, serverPlayerEntity1) -> {
			coords.remove(serverPlayerEntity.player.getUuid());
		}));
	}
}