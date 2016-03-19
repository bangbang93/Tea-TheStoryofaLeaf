package luoxiaowings.teastory.block;

import java.util.Random;

import luoxiaowings.teastory.common.EventLoader;
import luoxiaowings.teastory.creativetab.CreativeTabsLoader;
import luoxiaowings.teastory.item.ItemLoader;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;

public class Dustpan extends Block
{
	public Dustpan()
    {
		super(Material.wood);     
        this.setCreativeTab(CreativeTabsLoader.tabteastory);
        this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.375F, 1.0F);
        this.setHardness(0.5F);
        this.setStepSound(soundTypeWood);
        this.setUnlocalizedName("dustpan");
	}
	
	public boolean isOpaqueCube()
	{
	    return false;
	}
	
	public boolean isFullCube()
    {
        return false;
    }
	
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumFacing side, float hitX, float hitY, float hitZ)
    {
        if (worldIn.isRemote)
        {
            return true;
        }
        else
        {
        	if (playerIn.getHeldItem().getItem() == ItemLoader.tea_leaf && playerIn.getHeldItem().stackSize >=8)
            	{
        	    	worldIn.setBlockState(pos, BlockLoader.dustpan_full.getDefaultState());
        	    	playerIn.getHeldItem().stackSize = playerIn.getHeldItem().stackSize - 8;
                    return true;
            	}
        	else 
        	{
        		if (playerIn.getHeldItem().getItem() == ItemLoader.wet_tea && playerIn.getHeldItem().stackSize >=8)
            	{
        	    	worldIn.setBlockState(pos, BlockLoader.dustpan_wet.getDefaultState());
        	    	playerIn.getHeldItem().stackSize = playerIn.getHeldItem().stackSize - 8;
                    return true;
            	}
        		else return false;
        	}
        }
    }
}
