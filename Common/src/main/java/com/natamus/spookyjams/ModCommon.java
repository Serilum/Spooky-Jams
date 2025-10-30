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
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;

public class ModCommon {

	public static void init() {
		ConfigHandler.initConfig();
		load();
	}

	private static void load() {

	}

	public static void registerAssets(Object modEventBusObject) {
		// Jar
		Services.REGISTERITEM.registerItem(modEventBusObject, new ResourceLocation(Reference.MOD_ID, "glass_jar"), () -> new JamItem(new Item.Properties()), CreativeModeTabFunctions.getCreativeModeTabResourceKey("ingredients"));

		// Jams
		Services.REGISTERITEM.registerItem(modEventBusObject, new ResourceLocation(Reference.MOD_ID, "creepers_delight_jam"), () -> new CreepersDelightJamItem(new Item.Properties()), CreativeModeTabFunctions.getCreativeModeTabResourceKey("food_and_drinks"));
		Services.REGISTERITEM.registerItem(modEventBusObject, new ResourceLocation(Reference.MOD_ID, "endermans_essence_jam"), () -> new EndermansEssenceJamItem(new Item.Properties()), CreativeModeTabFunctions.getCreativeModeTabResourceKey("food_and_drinks"));
		Services.REGISTERITEM.registerItem(modEventBusObject, new ResourceLocation(Reference.MOD_ID, "ghasts_whisper_jam"), () -> new GhastsWhisperJamItem(new Item.Properties()), CreativeModeTabFunctions.getCreativeModeTabResourceKey("food_and_drinks"));
		Services.REGISTERITEM.registerItem(modEventBusObject, new ResourceLocation(Reference.MOD_ID, "glimmering_gloom_jam"), () -> new GlimmeringGloomJamItem(new Item.Properties()), CreativeModeTabFunctions.getCreativeModeTabResourceKey("food_and_drinks"));
		Services.REGISTERITEM.registerItem(modEventBusObject, new ResourceLocation(Reference.MOD_ID, "guardians_brine_jam"), () -> new GuardiansBrineJamItem(new Item.Properties()), CreativeModeTabFunctions.getCreativeModeTabResourceKey("food_and_drinks"));
		Services.REGISTERITEM.registerItem(modEventBusObject, new ResourceLocation(Reference.MOD_ID, "phantoms_veil_jam"), () -> new PhantomsVeilJamItem(new Item.Properties()), CreativeModeTabFunctions.getCreativeModeTabResourceKey("food_and_drinks"));
		Services.REGISTERITEM.registerItem(modEventBusObject, new ResourceLocation(Reference.MOD_ID, "slimes_squish_jam"), () -> new SlimesSquishJamItem(new Item.Properties()), CreativeModeTabFunctions.getCreativeModeTabResourceKey("food_and_drinks"));
		Services.REGISTERITEM.registerItem(modEventBusObject, new ResourceLocation(Reference.MOD_ID, "spiders_silk_jam"), () -> new SpidersSilkJamItem(new Item.Properties()), CreativeModeTabFunctions.getCreativeModeTabResourceKey("food_and_drinks"));
		Services.REGISTERITEM.registerItem(modEventBusObject, new ResourceLocation(Reference.MOD_ID, "spooky_yam_jam"), () -> new SpookyYamJamItem(new Item.Properties()), CreativeModeTabFunctions.getCreativeModeTabResourceKey("food_and_drinks"));
		Services.REGISTERITEM.registerItem(modEventBusObject, new ResourceLocation(Reference.MOD_ID, "witchs_hex_jam"), () -> new WitchsHexJamItem(new Item.Properties()), CreativeModeTabFunctions.getCreativeModeTabResourceKey("food_and_drinks"));
		Services.REGISTERITEM.registerItem(modEventBusObject, new ResourceLocation(Reference.MOD_ID, "withers_rot_jam"), () -> new WithersRotJamItem(new Item.Properties()), CreativeModeTabFunctions.getCreativeModeTabResourceKey("food_and_drinks"));
		Services.REGISTERITEM.registerItem(modEventBusObject, new ResourceLocation(Reference.MOD_ID, "zombies_hunger_jam"), () -> new ZombiesHungerJamItem(new Item.Properties()), CreativeModeTabFunctions.getCreativeModeTabResourceKey("food_and_drinks"));


		// Seeds
		Services.REGISTERITEM.registerItem(modEventBusObject, new ResourceLocation(Reference.MOD_ID, "spooky_yam_seeds"), () -> new SpookyYamSeedsItem(new Item.Properties()), CreativeModeTabFunctions.getCreativeModeTabResourceKey("natural_blocks"));

		// Items
		Services.REGISTERITEM.registerItem(modEventBusObject, new ResourceLocation(Reference.MOD_ID, "spooky_yam"), () -> new Item(new Item.Properties()), CreativeModeTabFunctions.getCreativeModeTabResourceKey("food_and_drinks"), true);

		// Blocks
		Services.REGISTERBLOCK.registerBlockWithoutItem(modEventBusObject, new ResourceLocation(Reference.MOD_ID, "spooky_yam_crop"), () -> new SpookyYamCropBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.CROP).pushReaction(PushReaction.DESTROY)), true);
	}


	public static void setAssets() {
		// Jar
		SpookyJamsItems.GLASS_JAR = (JamItem) Services.REGISTERITEM.getRegisteredItem(new ResourceLocation(Reference.MOD_ID, "glass_jar"));

		// Jams
		SpookyJamsItems.CREEPERS_DELIGHT_JAM = (CreepersDelightJamItem) Services.REGISTERITEM.getRegisteredItem(new ResourceLocation(Reference.MOD_ID, "creepers_delight_jam"));
		SpookyJamsItems.ENDERMANS_ESSENCE_JAM = (EndermansEssenceJamItem) Services.REGISTERITEM.getRegisteredItem(new ResourceLocation(Reference.MOD_ID, "endermans_essence_jam"));
		SpookyJamsItems.GHASTS_WHISPER_JAM = (GhastsWhisperJamItem) Services.REGISTERITEM.getRegisteredItem(new ResourceLocation(Reference.MOD_ID, "ghasts_whisper_jam"));
		SpookyJamsItems.GLIMMERING_GLOOM_JAM = (GlimmeringGloomJamItem) Services.REGISTERITEM.getRegisteredItem(new ResourceLocation(Reference.MOD_ID, "glimmering_gloom_jam"));
		SpookyJamsItems.GUARDIANS_BRINE_JAM = (GuardiansBrineJamItem) Services.REGISTERITEM.getRegisteredItem(new ResourceLocation(Reference.MOD_ID, "guardians_brine_jam"));
		SpookyJamsItems.PHANTOMS_VEIL_JAM = (PhantomsVeilJamItem) Services.REGISTERITEM.getRegisteredItem(new ResourceLocation(Reference.MOD_ID, "phantoms_veil_jam"));
		SpookyJamsItems.SLIMES_SQUISH_JAM = (SlimesSquishJamItem) Services.REGISTERITEM.getRegisteredItem(new ResourceLocation(Reference.MOD_ID, "slimes_squish_jam"));
		SpookyJamsItems.SPIDERS_SILK_JAM = (SpidersSilkJamItem) Services.REGISTERITEM.getRegisteredItem(new ResourceLocation(Reference.MOD_ID, "spiders_silk_jam"));
		SpookyJamsItems.SPOOKY_YAM_JAM = (SpookyYamJamItem) Services.REGISTERITEM.getRegisteredItem(new ResourceLocation(Reference.MOD_ID, "spooky_yam_jam"));
		SpookyJamsItems.WITCHS_HEX_JAM = (WitchsHexJamItem) Services.REGISTERITEM.getRegisteredItem(new ResourceLocation(Reference.MOD_ID, "witchs_hex_jam"));
		SpookyJamsItems.WITHERS_ROT_JAM = (WithersRotJamItem) Services.REGISTERITEM.getRegisteredItem(new ResourceLocation(Reference.MOD_ID, "withers_rot_jam"));
		SpookyJamsItems.ZOMBIES_HUNGER_JAM = (ZombiesHungerJamItem) Services.REGISTERITEM.getRegisteredItem(new ResourceLocation(Reference.MOD_ID, "zombies_hunger_jam"));


		// Seeds
		SpookyJamsItems.SPOOKY_YAM_SEEDS = (SpookyYamSeedsItem)Services.REGISTERITEM.getRegisteredItem(new ResourceLocation(Reference.MOD_ID, "spooky_yam_seeds"));

		// Items
		SpookyJamsItems.SPOOKY_YAM = Services.REGISTERITEM.getRegisteredItem(new ResourceLocation(Reference.MOD_ID, "spooky_yam"));

		// Blocks
		SpookyJamsBlocks.SPOOKY_YAM_CROP = (SpookyYamCropBlock)Services.REGISTERBLOCK.getRegisteredBlockWithoutItem(new ResourceLocation(Reference.MOD_ID, "spooky_yam_crop"));
	}

	public static void setBlockRender() {
		Services.CLIENTUTILS.blockSetRenderType(SpookyJamsBlocks.SPOOKY_YAM_CROP, RenderType.cutout());
	}
}