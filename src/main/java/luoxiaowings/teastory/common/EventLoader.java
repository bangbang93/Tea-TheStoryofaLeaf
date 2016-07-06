package luoxiaowings.teastory.common;

import luoxiaowings.teastory.achievement.AchievementLoader;
import luoxiaowings.teastory.block.BlockLoader;
import luoxiaowings.teastory.item.ItemLoader;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.eventhandler.Cancelable;
import net.minecraftforge.fml.common.eventhandler.EventBus;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;

public class EventLoader
{
    public static final EventBus EVENT_BUS = new EventBus();

    public EventLoader()
    {
        MinecraftForge.EVENT_BUS.register(this);
        EventLoader.EVENT_BUS.register(this);
    }
    
    @SubscribeEvent
    public void onPlayerItemCrafted(PlayerEvent.ItemCraftedEvent event)
    {
        if (event.crafting.getItem() == ItemLoader.tea_leaf)
        {
            event.player.triggerAchievement(AchievementLoader.teaAStoryOfLeaves);
        }
        if (event.crafting.getItem() == ItemLoader.burnt_green_tea)
        {
            event.player.triggerAchievement(AchievementLoader.isItEdible);
        }
        if (event.crafting.getItem() == ItemLoader.green_tea)
        {
            event.player.triggerAchievement(AchievementLoader.popularDrink);
        }
        if (event.crafting.getItem() == ItemLoader.matcha_drink)
        {
            event.player.triggerAchievement(AchievementLoader.anotherDrink);
        }
        if (event.crafting.getItem() == ItemLoader.black_tea)
        {
            event.player.triggerAchievement(AchievementLoader.blackTea);
        }
        if (event.crafting.getItem() == ItemLoader.broken_tea)
        {
        	if (event.player.getRNG().nextFloat() < 0.05F)
        	{
        		if (!event.player.inventory.addItemStackToInventory(new ItemStack(ItemLoader.tea_seeds, 1)))
                {
                    event.player.getEntityWorld().spawnEntityInWorld(new EntityItem(event.player.getEntityWorld(), event.player.posX + 0.5D, event.player.posY + 1.5D, event.player.posZ + 0.5D, 
                    		new ItemStack(ItemLoader.tea_seeds, 1)));
                }
        		else if (event.player instanceof EntityPlayerMP)
                {
                    ((EntityPlayerMP)event.player).sendContainerToPlayer(event.player.inventoryContainer);
                }
        	}
        }
    }
    
    @SubscribeEvent
    public void onPlayerItemSmelted(PlayerEvent.ItemSmeltedEvent event)
    {
        if (event.smelting.getItem() == ItemLoader.burnt_tea)
        {
            event.player.triggerAchievement(AchievementLoader.whatsThis);
        }
    }
    
    @SubscribeEvent
    public void onPlayerItemPickedup(PlayerEvent.ItemPickupEvent event)
    {
        if (event.pickedUp.getEntityItem().getItem() == ItemLoader.dried_tea)
        {
            event.player.triggerAchievement(AchievementLoader.dryingTea);
        }
        if (event.pickedUp.getEntityItem().getItem() == ItemLoader.wet_tea)
        {
            event.player.triggerAchievement(AchievementLoader.wet);
        }
    }
    
    @SubscribeEvent
    public void onPlayerLogged(PlayerEvent.PlayerLoggedInEvent event)
    {
    	if (ConfigLoader.info)
    	{
    	    event.player.addChatMessage(new ChatComponentText(StatCollector.translateToLocal("teastory.welcome.1")));
        	event.player.addChatMessage(new ChatComponentText(StatCollector.translateToLocal("teastory.welcome.2")));
    	}
    }
}
