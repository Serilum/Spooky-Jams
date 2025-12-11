package com.natamus.spookyjams;

import com.natamus.collective.functions.CreativeModeTabFunctions;
import com.natamus.collective.services.Services;
import com.natamus.spookyjams.config.ConfigHandler;
import com.natamus.spookyjams.items.SpookyJamsBlocks;
import com.natamus.spookyjams.items.SpookyJamsItems;
import com.natamus.spookyjams.registry.block.SpookyYamCropBlock;
import com.natamus.spookyjams.registry.item.*;
import com.natamus.spookyjams.registry.item.base.JamItem;
import com.natamus.spookyjams.registry.item.seeds.SpookyYamSeedsItem;
import com.natamus.spookyjams.util.Reference;
import net.minecraft.client.renderer.chunk.ChunkSectionLayer;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;

// NEW imports for data components
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.component.ItemLore;
import net.minecraft.network.chat.Component;

public class ModCommon {

	public static void init() {
		ConfigHandler.initConfig();
		load();
	}

	private static void load() {

	}

	public static void registerAssets(Object modEventBusObject) {
		// Jar
		Services.REGISTERITEM.registerItem(
			modEventBusObject,
			Identifier.fromNamespaceAndPath(Reference.MOD_ID, "glass_jar"),
			(properties) -> new JamItem(properties),
			new Item.Properties(),
			CreativeModeTabFunctions.getCreativeModeTabResourceKey("ingredients")
		);

		Services.REGISTERITEM.registerItem(
			modEventBusObject,
			Identifier.fromNamespaceAndPath(Reference.MOD_ID, "creepers_delight_jam"),
			(properties) -> new CreepersDelightJamItem(properties),
			new Item.Properties()
				.component(DataComponents.CUSTOM_NAME,
					Component.translatable("item.spookyjams.creepers_delight_jam")
						.withStyle(s -> s.withColor(0x80c39a)))
				.component(DataComponents.LORE, new ItemLore(java.util.List.of(
					Component.translatable("item.spookyjams.creepers_delight_jam.desc.1")
						.withStyle(s -> s.withColor(0x4f8e63).withItalic(true)),
					Component.translatable("item.spookyjams.creepers_delight_jam.desc.2")
						.withStyle(s -> s.withColor(0x4f8e63).withItalic(true))
				))),
			CreativeModeTabFunctions.getCreativeModeTabResourceKey("food_and_drinks")
		);

		Services.REGISTERITEM.registerItem(
			modEventBusObject,
			Identifier.fromNamespaceAndPath(Reference.MOD_ID, "endermans_essence_jam"),
			(properties) -> new EndermansEssenceJamItem(properties),
			new Item.Properties()
				.component(DataComponents.CUSTOM_NAME,
					Component.translatable("item.spookyjams.endermans_essence_jam")
						.withStyle(s -> s.withColor(0x7f5ed1)))
				.component(DataComponents.LORE, new ItemLore(java.util.List.of(
					Component.translatable("item.spookyjams.endermans_essence_jam.desc.1")
						.withStyle(s -> s.withColor(0x5a3e9e).withItalic(true)),
					Component.translatable("item.spookyjams.endermans_essence_jam.desc.2")
						.withStyle(s -> s.withColor(0x5a3e9e).withItalic(true))
				))),
			CreativeModeTabFunctions.getCreativeModeTabResourceKey("food_and_drinks")
		);

		Services.REGISTERITEM.registerItem(
			modEventBusObject,
			Identifier.fromNamespaceAndPath(Reference.MOD_ID, "ghasts_whisper_jam"),
			(properties) -> new GhastsWhisperJamItem(properties),
			new Item.Properties()
				.component(DataComponents.CUSTOM_NAME,
					Component.translatable("item.spookyjams.ghasts_whisper_jam")
						.withStyle(s -> s.withColor(0xe5f7ff)))
				.component(DataComponents.LORE, new ItemLore(java.util.List.of(
					Component.translatable("item.spookyjams.ghasts_whisper_jam.desc.1")
						.withStyle(s -> s.withColor(0xa9d1e8).withItalic(true)),
					Component.translatable("item.spookyjams.ghasts_whisper_jam.desc.2")
						.withStyle(s -> s.withColor(0xa9d1e8).withItalic(true))
				))),
			CreativeModeTabFunctions.getCreativeModeTabResourceKey("food_and_drinks")
		);

		Services.REGISTERITEM.registerItem(
			modEventBusObject,
			Identifier.fromNamespaceAndPath(Reference.MOD_ID, "glimmering_gloom_jam"),
			(properties) -> new GlimmeringGloomJamItem(properties),
			new Item.Properties()
				.component(DataComponents.CUSTOM_NAME,
					Component.translatable("item.spookyjams.glimmering_gloom_jam")
						.withStyle(s -> s.withColor(0xb02a86)))
				.component(DataComponents.LORE, new ItemLore(java.util.List.of(
					Component.translatable("item.spookyjams.glimmering_gloom_jam.desc.1")
						.withStyle(s -> s.withColor(0x8b0e6b).withItalic(true)),
					Component.translatable("item.spookyjams.glimmering_gloom_jam.desc.2")
						.withStyle(s -> s.withColor(0x8b0e6b).withItalic(true))
				))),
			CreativeModeTabFunctions.getCreativeModeTabResourceKey("food_and_drinks")
		);

		Services.REGISTERITEM.registerItem(
			modEventBusObject,
			Identifier.fromNamespaceAndPath(Reference.MOD_ID, "guardians_brine_jam"),
			(properties) -> new GuardiansBrineJamItem(properties),
			new Item.Properties()
				.component(DataComponents.CUSTOM_NAME,
					Component.translatable("item.spookyjams.guardians_brine_jam")
						.withStyle(s -> s.withColor(0x8dd5c7)))
				.component(DataComponents.LORE, new ItemLore(java.util.List.of(
					Component.translatable("item.spookyjams.guardians_brine_jam.desc.1")
						.withStyle(s -> s.withColor(0x4e9d93).withItalic(true)),
					Component.translatable("item.spookyjams.guardians_brine_jam.desc.2")
						.withStyle(s -> s.withColor(0x4e9d93).withItalic(true))
				))),
			CreativeModeTabFunctions.getCreativeModeTabResourceKey("food_and_drinks")
		);

		Services.REGISTERITEM.registerItem(
			modEventBusObject,
			Identifier.fromNamespaceAndPath(Reference.MOD_ID, "phantoms_veil_jam"),
			(properties) -> new PhantomsVeilJamItem(properties),
			new Item.Properties()
				.component(DataComponents.CUSTOM_NAME,
					Component.translatable("item.spookyjams.phantoms_veil_jam")
						.withStyle(s -> s.withColor(0xdce7ea)))
				.component(DataComponents.LORE, new ItemLore(java.util.List.of(
					Component.translatable("item.spookyjams.phantoms_veil_jam.desc.1")
						.withStyle(s -> s.withColor(0xa3b9bf).withItalic(true)),
					Component.translatable("item.spookyjams.phantoms_veil_jam.desc.2")
						.withStyle(s -> s.withColor(0xa3b9bf).withItalic(true))
				))),
			CreativeModeTabFunctions.getCreativeModeTabResourceKey("food_and_drinks")
		);

		Services.REGISTERITEM.registerItem(
			modEventBusObject,
			Identifier.fromNamespaceAndPath(Reference.MOD_ID, "slimes_squish_jam"),
			(properties) -> new SlimesSquishJamItem(properties),
			new Item.Properties()
				.component(DataComponents.CUSTOM_NAME,
					Component.translatable("item.spookyjams.slimes_squish_jam")
						.withStyle(s -> s.withColor(0xc9f573)))
				.component(DataComponents.LORE, new ItemLore(java.util.List.of(
					Component.translatable("item.spookyjams.slimes_squish_jam.desc.1")
						.withStyle(s -> s.withColor(0x8ec43a).withItalic(true)),
					Component.translatable("item.spookyjams.slimes_squish_jam.desc.2")
						.withStyle(s -> s.withColor(0x8ec43a).withItalic(true))
				))),
			CreativeModeTabFunctions.getCreativeModeTabResourceKey("food_and_drinks")
		);

		Services.REGISTERITEM.registerItem(
			modEventBusObject,
			Identifier.fromNamespaceAndPath(Reference.MOD_ID, "spiders_silk_jam"),
			(properties) -> new SpidersSilkJamItem(properties),
			new Item.Properties()
				.component(DataComponents.CUSTOM_NAME,
					Component.translatable("item.spookyjams.spiders_silk_jam")
						.withStyle(s -> s.withColor(0xb64d4f)))
				.component(DataComponents.LORE, new ItemLore(java.util.List.of(
					Component.translatable("item.spookyjams.spiders_silk_jam.desc.1")
						.withStyle(s -> s.withColor(0x822c2e).withItalic(true)),
					Component.translatable("item.spookyjams.spiders_silk_jam.desc.2")
						.withStyle(s -> s.withColor(0x822c2e).withItalic(true))
				))),
			CreativeModeTabFunctions.getCreativeModeTabResourceKey("food_and_drinks")
		);

		Services.REGISTERITEM.registerItem(
			modEventBusObject,
			Identifier.fromNamespaceAndPath(Reference.MOD_ID, "spooky_yam_jam"),
			(properties) -> new SpookyYamJamItem(properties),
			new Item.Properties()
				.component(DataComponents.CUSTOM_NAME,
					Component.translatable("item.spookyjams.spooky_yam_jam")
						.withStyle(s -> s.withColor(0xe0a768)))
				.component(DataComponents.LORE, new ItemLore(java.util.List.of(
					Component.translatable("item.spookyjams.spooky_yam_jam.desc.1")
						.withStyle(s -> s.withColor(0xc56a36).withItalic(true)),
					Component.translatable("item.spookyjams.spooky_yam_jam.desc.2")
						.withStyle(s -> s.withColor(0xc56a36).withItalic(true))
				))),
			CreativeModeTabFunctions.getCreativeModeTabResourceKey("food_and_drinks")
		);

		Services.REGISTERITEM.registerItem(
			modEventBusObject,
			Identifier.fromNamespaceAndPath(Reference.MOD_ID, "witchs_hex_jam"),
			(properties) -> new WitchsHexJamItem(properties),
			new Item.Properties()
				.component(DataComponents.CUSTOM_NAME,
					Component.translatable("item.spookyjams.witchs_hex_jam")
						.withStyle(s -> s.withColor(0xb94d7b)))
				.component(DataComponents.LORE, new ItemLore(java.util.List.of(
					Component.translatable("item.spookyjams.witchs_hex_jam.desc.1")
						.withStyle(s -> s.withColor(0x7a2e56).withItalic(true)),
					Component.translatable("item.spookyjams.witchs_hex_jam.desc.2")
						.withStyle(s -> s.withColor(0x7a2e56).withItalic(true))
				))),
			CreativeModeTabFunctions.getCreativeModeTabResourceKey("food_and_drinks")
		);

		Services.REGISTERITEM.registerItem(
			modEventBusObject,
			Identifier.fromNamespaceAndPath(Reference.MOD_ID, "withers_rot_jam"),
			(properties) -> new WithersRotJamItem(properties),
			new Item.Properties()
				.component(DataComponents.CUSTOM_NAME,
					Component.translatable("item.spookyjams.withers_rot_jam")
						.withStyle(s -> s.withColor(0x4d3a53)))
				.component(DataComponents.LORE, new ItemLore(java.util.List.of(
					Component.translatable("item.spookyjams.withers_rot_jam.desc.1")
						.withStyle(s -> s.withColor(0x2c1e2e).withItalic(true)),
					Component.translatable("item.spookyjams.withers_rot_jam.desc.2")
						.withStyle(s -> s.withColor(0x2c1e2e).withItalic(true))
				))),
			CreativeModeTabFunctions.getCreativeModeTabResourceKey("food_and_drinks")
		);

		Services.REGISTERITEM.registerItem(
			modEventBusObject,
			Identifier.fromNamespaceAndPath(Reference.MOD_ID, "zombies_hunger_jam"),
			(properties) -> new ZombiesHungerJamItem(properties),
			new Item.Properties()
				.component(DataComponents.CUSTOM_NAME,
					Component.translatable("item.spookyjams.zombies_hunger_jam")
						.withStyle(s -> s.withColor(0xa45c4e)))
				.component(DataComponents.LORE, new ItemLore(java.util.List.of(
					Component.translatable("item.spookyjams.zombies_hunger_jam.desc.1")
						.withStyle(s -> s.withColor(0x763628).withItalic(true)),
					Component.translatable("item.spookyjams.zombies_hunger_jam.desc.2")
						.withStyle(s -> s.withColor(0x763628).withItalic(true))
				))),
			CreativeModeTabFunctions.getCreativeModeTabResourceKey("food_and_drinks")
		);

		// Seeds
		Services.REGISTERITEM.registerItem(
			modEventBusObject,
			Identifier.fromNamespaceAndPath(Reference.MOD_ID, "spooky_yam_seeds"),
			(properties) -> new SpookyYamSeedsItem(properties),
			new Item.Properties(),
			CreativeModeTabFunctions.getCreativeModeTabResourceKey("natural_blocks")
		);

		// Items
		Services.REGISTERITEM.registerItem(
			modEventBusObject,
			Identifier.fromNamespaceAndPath(Reference.MOD_ID, "spooky_yam"),
			(properties) -> new Item(properties),
			new Item.Properties(),
			CreativeModeTabFunctions.getCreativeModeTabResourceKey("food_and_drinks"),
			true
		);

		// Blocks
		Services.REGISTERBLOCK.registerBlockWithoutItem(
			modEventBusObject,
			Identifier.fromNamespaceAndPath(Reference.MOD_ID, "spooky_yam_crop"),
			(properties) -> new SpookyYamCropBlock(properties),
			BlockBehaviour.Properties.of()
				.mapColor(MapColor.PLANT)
				.noCollision()
				.randomTicks()
				.instabreak()
				.sound(SoundType.CROP)
				.pushReaction(PushReaction.DESTROY),
			true
		);
	}

	public static void setAssets() {
		// Jar
		SpookyJamsItems.GLASS_JAR = (JamItem) Services.REGISTERITEM.getRegisteredItem(Identifier.fromNamespaceAndPath(Reference.MOD_ID, "glass_jar"));

		// Jams
		SpookyJamsItems.CREEPERS_DELIGHT_JAM = (CreepersDelightJamItem) Services.REGISTERITEM.getRegisteredItem(Identifier.fromNamespaceAndPath(Reference.MOD_ID, "creepers_delight_jam"));
		SpookyJamsItems.ENDERMANS_ESSENCE_JAM = (EndermansEssenceJamItem) Services.REGISTERITEM.getRegisteredItem(Identifier.fromNamespaceAndPath(Reference.MOD_ID, "endermans_essence_jam"));
		SpookyJamsItems.GHASTS_WHISPER_JAM = (GhastsWhisperJamItem) Services.REGISTERITEM.getRegisteredItem(Identifier.fromNamespaceAndPath(Reference.MOD_ID, "ghasts_whisper_jam"));
		SpookyJamsItems.GLIMMERING_GLOOM_JAM = (GlimmeringGloomJamItem) Services.REGISTERITEM.getRegisteredItem(Identifier.fromNamespaceAndPath(Reference.MOD_ID, "glimmering_gloom_jam"));
		SpookyJamsItems.GUARDIANS_BRINE_JAM = (GuardiansBrineJamItem) Services.REGISTERITEM.getRegisteredItem(Identifier.fromNamespaceAndPath(Reference.MOD_ID, "guardians_brine_jam"));
		SpookyJamsItems.PHANTOMS_VEIL_JAM = (PhantomsVeilJamItem) Services.REGISTERITEM.getRegisteredItem(Identifier.fromNamespaceAndPath(Reference.MOD_ID, "phantoms_veil_jam"));
		SpookyJamsItems.SLIMES_SQUISH_JAM = (SlimesSquishJamItem) Services.REGISTERITEM.getRegisteredItem(Identifier.fromNamespaceAndPath(Reference.MOD_ID, "slimes_squish_jam"));
		SpookyJamsItems.SPIDERS_SILK_JAM = (SpidersSilkJamItem) Services.REGISTERITEM.getRegisteredItem(Identifier.fromNamespaceAndPath(Reference.MOD_ID, "spiders_silk_jam"));
		SpookyJamsItems.SPOOKY_YAM_JAM = (SpookyYamJamItem) Services.REGISTERITEM.getRegisteredItem(Identifier.fromNamespaceAndPath(Reference.MOD_ID, "spooky_yam_jam"));
		SpookyJamsItems.WITCHS_HEX_JAM = (WitchsHexJamItem) Services.REGISTERITEM.getRegisteredItem(Identifier.fromNamespaceAndPath(Reference.MOD_ID, "witchs_hex_jam"));
		SpookyJamsItems.WITHERS_ROT_JAM = (WithersRotJamItem) Services.REGISTERITEM.getRegisteredItem(Identifier.fromNamespaceAndPath(Reference.MOD_ID, "withers_rot_jam"));
		SpookyJamsItems.ZOMBIES_HUNGER_JAM = (ZombiesHungerJamItem) Services.REGISTERITEM.getRegisteredItem(Identifier.fromNamespaceAndPath(Reference.MOD_ID, "zombies_hunger_jam"));

		// Seeds
		SpookyJamsItems.SPOOKY_YAM_SEEDS = (SpookyYamSeedsItem)Services.REGISTERITEM.getRegisteredItem(Identifier.fromNamespaceAndPath(Reference.MOD_ID, "spooky_yam_seeds"));

		// Items
		SpookyJamsItems.SPOOKY_YAM = Services.REGISTERITEM.getRegisteredItem(Identifier.fromNamespaceAndPath(Reference.MOD_ID, "spooky_yam"));

		// Blocks
		SpookyJamsBlocks.SPOOKY_YAM_CROP = (SpookyYamCropBlock)Services.REGISTERBLOCK.getRegisteredBlockWithoutItem(Identifier.fromNamespaceAndPath(Reference.MOD_ID, "spooky_yam_crop"));
	}

	public static void setBlockRender() {
		Services.CLIENTUTILS.blockSetChunkSectionLayer(SpookyJamsBlocks.SPOOKY_YAM_CROP, ChunkSectionLayer.CUTOUT);
	}
}