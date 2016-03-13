package luoxiaowings.teastory.item;

import luoxiaowings.teastory.common.ConfigLoader;
import luoxiaowings.teastory.creativetab.CreativeTabsLoader;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemSoup;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class MatchaDrink extends ItemSoup
{
	public MatchaDrink()
	{
        super(1);
        this.setCreativeTab(CreativeTabsLoader.tabteastory);
        this.setAlwaysEdible();
        this.setMaxStackSize(1);
        this.setUnlocalizedName("matcha_drink");
    }

    protected void onFoodEaten(ItemStack itemstack, World world, EntityPlayer entityplayer)
    {
        if(!world.isRemote)
        {
        	entityplayer.addPotionEffect(new PotionEffect(Potion.absorption.id, Math.max(0, ConfigLoader.greentea_absorptionTime), Math.max(0, ConfigLoader.greentea_absorptionTier))); 
            entityplayer.addPotionEffect(new PotionEffect(Potion.resistance.id, Math.max(0, ConfigLoader.greentea_resistanceTime), Math.max(0, ConfigLoader.greentea_resistanceTier))); 
        }
    }
    
    public EnumAction getItemUseAction(ItemStack itemStackIn)
    {
        return EnumAction.DRINK;
    }
}
