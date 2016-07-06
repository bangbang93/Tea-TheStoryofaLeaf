package luoxiaowings.teastory.common;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ConfigLoader
{
	private static Configuration config;
	
	public static int greentea_Time;
	public static int greentea_Tier;
	public static int burntgreentea_Time;
	public static int burntgreentea_Tier;
	public static int matcha_Time;
	public static int matcha_Tier;
	public static int blacktea_Time;
	public static int blacktea_Tier;
	public static int enchantmentLifeDrainId;
	public static boolean info;
	
	public ConfigLoader(FMLPreInitializationEvent event)
	{
		config = new Configuration(event.getSuggestedConfigurationFile());
		config.load();
		
		registerConfig();
		
		config.save();
	}
	
	private static void registerConfig()
	{
		info = config.get(Configuration.CATEGORY_GENERAL, "info", true).getBoolean();
		greentea_Time = config.get(Configuration.CATEGORY_GENERAL, "greentea_Effect_Time", 2000).getInt();
		burntgreentea_Time = config.get(Configuration.CATEGORY_GENERAL, "burntgreentea_Effect_Time", 600).getInt();
		matcha_Time = config.get(Configuration.CATEGORY_GENERAL, "matcha_Effect_Time", 1200).getInt();
		blacktea_Time = config.get(Configuration.CATEGORY_GENERAL, "blacktea_Effect_Time", 2500).getInt();
		enchantmentLifeDrainId = config.get(Configuration.CATEGORY_GENERAL, "enchantmentLifeDrainId", 30).getInt();
	}
}
