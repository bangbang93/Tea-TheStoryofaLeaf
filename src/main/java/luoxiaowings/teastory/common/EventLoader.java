package luoxiaowings.teastory.common;

import luoxiaowings.teastory.achievement.AchievementLoader;
import luoxiaowings.teastory.block.BlockLoader;
import luoxiaowings.teastory.item.ItemLoader;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
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
        FMLCommonHandler.instance().bus().register(this);
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
}
