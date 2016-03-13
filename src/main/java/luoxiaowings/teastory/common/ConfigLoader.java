package luoxiaowings.teastory.common;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ConfigLoader
{
	private static Configuration config;
	
	public static int greentea_absorptionTime;
	public static int greentea_absorptionTier;
	public static int greentea_hungerTime;
	public static int greentea_hungerTier;
	public static int greentea_resistanceTime;
	public static int greentea_resistanceTier;
	public static int enchantmentLifeDrainId;
	
	public ConfigLoader(FMLPreInitializationEvent event)
	{
		config = new Configuration(event.getSuggestedConfigurationFile());
		config.load();
		
		registerConfig();
		
		config.save();
	}
	
	private static void registerConfig()
	{
		greentea_absorptionTime = config.get(Configuration.CATEGORY_GENERAL, "greentea_absorptionTime", 1500).getInt();
		greentea_absorptionTier = config.get(Configuration.CATEGORY_GENERAL, "greentea_absorptionTier", 1).getInt();
		greentea_hungerTime = config.get(Configuration.CATEGORY_GENERAL, "greentea_hungerTime", 600).getInt();
		greentea_hungerTier = config.get(Configuration.CATEGORY_GENERAL, "greentea_hungerTier", 2).getInt();
		greentea_resistanceTime = config.get(Configuration.CATEGORY_GENERAL, "greentea_resistanceTime", 3000).getInt();
		greentea_resistanceTier= config.get(Configuration.CATEGORY_GENERAL, "greentea_resistanceTier", 2).getInt();
		enchantmentLifeDrainId = config.get(Configuration.CATEGORY_GENERAL, "enchantmentLifeDrainId", 30).getInt();
	}
}
