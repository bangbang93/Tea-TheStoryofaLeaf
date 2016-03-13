package luoxiaowings.teastory.block;

import java.util.Random;

import luoxiaowings.teastory.creativetab.CreativeTabsLoader;
import luoxiaowings.teastory.item.ItemLoader;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class DustpanDried extends Block
{
	public DustpanDried()
	{
		super(Material.wood);
        this.setTickRandomly(true);	     
        this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.375F, 1.0F);
        this.setHardness(0.5F);
        this.setStepSound(soundTypeWood);
        this.setUnlocalizedName("dustpan_dried");
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
        	worldIn.setBlockState(pos, BlockLoader.dustpan.getDefaultState());
            ItemStack itemstack1 = new ItemStack(ItemLoader.dried_tea, 8);
            worldIn.spawnEntityInWorld(new EntityItem(worldIn, (double)pos.getX() + 0.5D, (double)pos.getY() + 0.5D, (double)pos.getZ() + 0.5D, itemstack1));
            return true;
        }
    }
	
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return Item.getItemFromBlock(BlockLoader.dustpan);
    }
    
    public int quantityDropped(Random random)
    {
        return 1;
    }
    
    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
    {
        super.updateTick(worldIn, pos, state, rand);
        if (worldIn.canLightningStrike(pos.up()))
        {
        	worldIn.setBlockState(pos, BlockLoader.dustpan_wet.getDefaultState(), 2);
        }
    }
}
