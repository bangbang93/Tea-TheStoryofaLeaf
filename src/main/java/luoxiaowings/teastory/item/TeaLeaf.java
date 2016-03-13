package luoxiaowings.teastory.item;

import luoxiaowings.teastory.block.BlockLoader;
import luoxiaowings.teastory.creativetab.CreativeTabsLoader;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class TeaLeaf extends NormalItem
{
	public TeaLeaf(String name, int maxstack)
    {
 	    super(name, maxstack);
    }
	
	public boolean onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ)
	{
		if (worldIn.getBlockState(pos).getBlock() == BlockLoader.dustpan && stack.stackSize >= 8)
		{
			worldIn.setBlockState(pos, BlockLoader.dustpan_full.getDefaultState());
            stack.stackSize = stack.stackSize - 8;
            return true;
        }
        else
        {
            return false;
        }
	}
}
