package luoxiaowings.teastory.item;

import java.util.Iterator;
import java.util.List;

import luoxiaowings.teastory.common.ConfigLoader;
import luoxiaowings.teastory.creativetab.CreativeTabsLoader;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.*;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class GreenTea extends ItemSoup
{
    public GreenTea()
    {
        super(1);
        this.setCreativeTab(CreativeTabsLoader.tabteastory);
        this.setAlwaysEdible();
        this.setMaxStackSize(1);
        this.setUnlocalizedName("green_tea");
    }

    protected void onFoodEaten(ItemStack itemstack, World world, EntityPlayer entityplayer)
    {
        if(!world.isRemote)
        {
        	entityplayer.addPotionEffect(new PotionEffect(Potion.absorption.id, Math.max(0, ConfigLoader.greentea_absorptionTime), Math.max(0, ConfigLoader.greentea_absorptionTier) - 1)); 
            entityplayer.addPotionEffect(new PotionEffect(Potion.hunger.id, Math.max(0, ConfigLoader.greentea_hungerTime), Math.max(0, ConfigLoader.greentea_hungerTier) - 1)); 
            entityplayer.addPotionEffect(new PotionEffect(Potion.resistance.id, Math.max(0, ConfigLoader.greentea_resistanceTime), Math.max(0, ConfigLoader.greentea_resistanceTier) - 1)); 
        }
    }
    
    public EnumAction getItemUseAction(ItemStack itemStackIn)
    {
        return EnumAction.DRINK;
    }
}