package luoxiaowings.teastory.item;

import java.util.Iterator;
import java.util.List;

import luoxiaowings.teastory.common.ConfigLoader;
import luoxiaowings.teastory.creativetab.CreativeTabsLoader;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.*;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.StatCollector;
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
        	entityplayer.addPotionEffect(new PotionEffect(Potion.absorption.id, Math.max(0, ConfigLoader.greentea_Time), 1)); 
            entityplayer.addPotionEffect(new PotionEffect(Potion.resistance.id, Math.max(0, ConfigLoader.greentea_Time), 2)); 
        }
        
        if (!entityplayer.inventory.addItemStackToInventory(new ItemStack(ItemLoader.tea_residue, 1, 0)))
        {
            world.spawnEntityInWorld(new EntityItem(world, entityplayer.posX + 0.5D, entityplayer.posY + 1.5D, entityplayer.posZ + 0.5D, 
            		new ItemStack(ItemLoader.tea_residue, 1, 0)));
        }
    }
    
    public EnumAction getItemUseAction(ItemStack itemStackIn)
    {
        return EnumAction.DRINK;
    }
}