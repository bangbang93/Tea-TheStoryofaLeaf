package luoxiaowings.teastory.common;

import luoxiaowings.teastory.TeaStory;
import luoxiaowings.teastory.achievement.AchievementLoader;
import luoxiaowings.teastory.block.BlockLoader;
import luoxiaowings.teastory.crafting.CraftingLoader;
import luoxiaowings.teastory.creativetab.CreativeTabsLoader;
import luoxiaowings.teastory.enchantment.EnchantmentLoader;
import luoxiaowings.teastory.item.ItemLoader;
import net.minecraft.block.Block;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CommonProxy
{
    public void preInit(FMLPreInitializationEvent event)
    {
    	new ConfigLoader(event);
    	new CreativeTabsLoader(event);
    	new ItemLoader(event);
    	new BlockLoader(event);
    }

    public void init(FMLInitializationEvent event)
    {
    	new CraftingLoader();
    	new EnchantmentLoader();
    	new AchievementLoader();
    	new EventLoader();
    }

    public void postInit(FMLPostInitializationEvent event)
    {
    }
}