package luoxiaowings.teastory.block;

import java.util.List;

import luoxiaowings.teastory.block.Teapan.EnumType;
import luoxiaowings.teastory.item.ItemLoader;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class Teaplant extends BlockCrops
{
	public Teaplant()
	{
		this.setUnlocalizedName("teaplant");
	}
	
	protected Item getSeed()
    {
        return ItemLoader.tea_seeds;
    }

    protected Item getCrop()
    {
        return ItemLoader.tea_leaf;
    }
    
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumFacing side, float hitX, float hitY, float hitZ)
    {
        if (worldIn.isRemote)
        {
            return true;
        }
        else
        {
            if (((Integer)state.getValue(AGE)).intValue() == 7)
        	{
    	    	 worldIn.setBlockState(pos, BlockLoader.teaplant.getStateFromMeta(4));
    	    	 worldIn.spawnEntityInWorld(new EntityItem(worldIn, (double)pos.getX() + 0.5D, (double)pos.getY() + 0.5D, (double)pos.getZ() + 0.5D, new ItemStack(ItemLoader.tea_leaf, playerIn.getRNG().nextInt(4) + 1)));
    	         return true;
        	}
            else return false;
        }
    }
}
