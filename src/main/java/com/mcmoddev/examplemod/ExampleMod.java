package com.mcmoddev.examplemod;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.mcmoddev.examplemod.proxy.CommonProxy;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLFingerprintViolationEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLInterModComms.IMCEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 *
 */
@Mod(
	modid = ExampleMod.MODID,
	name = ExampleMod.NAME,
	version = ExampleMod.VERSION,
	dependencies = "required-after:forge@[14.23.4.2705,)",
	useMetadata = false,
	clientSideOnly = false,
	serverSideOnly = false,
	acceptedMinecraftVersions = "[1.12.2]",
	acceptableRemoteVersions = ExampleMod.VERSION,
	acceptableSaveVersions = "",
	certificateFingerprint = "@FINGERPRINT@",
	modLanguage = "java",
	modLanguageAdapter = "",
	canBeDeactivated = false,
	guiFactory = "",
	updateJSON = "https://github.com/MinecraftModDevelopmentMods/ExampleMod/master/update.json",
	customProperties = {})
public final class ExampleMod {

	/* The Mod's Instance. */
	//@Mod.Instance
	//private static ExampleMod instance = null

	/** ID of this Mod. */
	public static final String MODID = "examplemod";

	/** Display name of this Mod. */
	public static final String NAME = "Example Mod";

	/** Version of this Mod. */
	public static final String VERSION = "1.0.0";
//	public static final String VERSION = "@MOD_VERSION@"

	/**
	 *
	 */
	public static final Logger LOGGER = LogManager.getLogger(ExampleMod.MODID);

	private static final class InstanceHolder {
		private static final ExampleMod INSTANCE = new ExampleMod();
	}

	@Mod.InstanceFactory
	public static ExampleMod instance() {
		return InstanceHolder.INSTANCE;
	}

	/**
	 *
 	 */
	@SidedProxy(
				clientSide = "com.mcmoddev.examplemod.proxy.ClientProxy",
				serverSide = "com.mcmoddev.examplemod.proxy.ServerProxy")
	private static CommonProxy proxy = null;

	/**
	 *
 	 * @param event The Event.
	 */
	@Mod.EventHandler
	public static void onFingerprintViolation(final FMLFingerprintViolationEvent event) {
		// This complains if jar not signed, even if certificateFingerprint is blank
		LOGGER.warn("Invalid Fingerprint");
	}

	/**
	 *
 	 * @param event The Event.
	 */
	@Mod.EventHandler
	public static void preInit(final FMLPreInitializationEvent event) {
		// Instead of setting the logger above, you can set it like this instead.
		// logger = event.getModLog()
		proxy.preInit(event);
	}

	/**
	 *
 	 * @param event The Event.
	 */
	@Mod.EventHandler
	public static void init(final FMLInitializationEvent event) {
		proxy.init(event);
	}

	/**
	 *
 	 * @param event The Event.
	 */
	@Mod.EventHandler
	public static void receiveIMC(final IMCEvent event) {
		proxy.receiveIMC(event);
	}

	/**
	 *
 	 * @param event The Event.
	 */
	@Mod.EventHandler
	public static void postInit(final FMLPostInitializationEvent event) {
		proxy.postInit(event);
	}

	/*
	// Before 1.12
	@Mod.EventHandler
	public static void onRemap(final FMLMissingMappingsEvent event) {
		proxy.onRemap(event);
	}
	*/
}
