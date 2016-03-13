package luoxiaowings.teastory.item;

import java.util.List;

import luoxiaowings.teastory.achievement.AchievementLoader;
import luoxiaowings.teastory.common.ConfigLoader;
import luoxiaowings.teastory.creativetab.CreativeTabsLoader;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.BlockPos;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;

public class HotWater extends ItemFood
{
    public HotWater()
    {
        super(0, false);
        this.setCreativeTab(CreativeTabsLoader.tabteastory);
        this.setAlwaysEdible();
        this.setMaxStackSize(1);
        this.setContainerItem(Items.glass_bottle);
        this.setUnlocalizedName("hot_water");
    }
    
    public void addInformation(ItemStack itemstack, EntityPlayer entityplayer, List list, boolean b)
    {
        list.add(StatCollector.translateToLocal("teastory.tooltip.hot_water"));
    }

    public void onFoodEaten(ItemStack itemstack, World world, EntityPlayer entityplayer)
    {
    	BlockPos pos = new BlockPos(entityplayer.posX, entityplayer.posY, entityplayer.posZ);
    	BiomeGenBase biome = world.getBiomeGenForCoords(pos);
    	float temperature = biome.getFloatTemperature(pos);
        if(!world.isRemote && temperature <= 0.5D)
        {
        	entityplayer.addPotionEffect(new PotionEffect(Potion.regeneration.id, 200, 0));
        }
        else if (temperature > 0.5D)
        {
        	entityplayer.addPotionEffect(new PotionEffect(Potion.harm.id, 1, 0));
        }
    }
  
    public EnumAction getItemUseAction(ItemStack itemStackIn)
    {
        return EnumAction.DRINK;
    }
    
    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, EntityPlayer playerIn)
    {
        super.onItemUseFinish(stack, worldIn, playerIn);
        playerIn.triggerAchievement(AchievementLoader.warmthOrHarm);
        return new ItemStack(Items.glass_bottle);
    }
}
