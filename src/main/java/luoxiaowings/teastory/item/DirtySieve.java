package luoxiaowings.teastory.item;

import luoxiaowings.teastory.creativetab.CreativeTabsLoader;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class DirtySieve extends TSItem
{
	public DirtySieve()
    {
 	    super("dirty_sieve", 64);
    }
	
	@Override
	public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn)
	{
		int i = itemStackIn.stackSize;
		return new ItemStack(ItemLoader.sieve, i);
	}
}
