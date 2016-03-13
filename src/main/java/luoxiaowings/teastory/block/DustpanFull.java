package luoxiaowings.teastory.block;

import java.util.Random;

import luoxiaowings.teastory.creativetab.CreativeTabsLoader;
import luoxiaowings.teastory.item.ItemLoader;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;

public class DustpanFull extends Block
{
	public DustpanFull()
    {
		super(Material.wood);
        this.setTickRandomly(true);	     
        this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.375F, 1.0F);
        this.setHardness(0.5F);
        this.setStepSound(soundTypeWood);
        this.setUnlocalizedName("dustpan_full");
	}
	
	public boolean isOpaqueCube()
	{
	    return false;
	}
	
	public boolean isFullCube()
    {
        return false;
    }
	
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
    {
        super.updateTick(worldIn, pos, state, rand);
        if (worldIn.canLightningStrike(pos.up()))
        {
        	worldIn.setBlockState(pos, BlockLoader.dustpan_wet.getDefaultState(), 2);
        }
        else
        {
            float f = getGrowthChance(this, worldIn, pos);
            if (f == 0.0F)
            {
             	return;
            }
            else
            {
                if (rand.nextInt((int)(25.0F / f) + 1) == 0)
                {
                    worldIn.setBlockState(pos, BlockLoader.dustpan_dried.getDefaultState(), 2);
                }
            }
        }
    }
	
	protected static float getGrowthChance(Block blockIn, World worldIn, BlockPos pos)
    {
        float f;
        BiomeGenBase biome = worldIn.getBiomeGenForCoords(pos);
        boolean isUnderTheSun = worldIn.canBlockSeeSky(pos);
        boolean isRaining = worldIn.isRaining();
        boolean isDaytime = worldIn.getWorldTime() % 24000L < 12000L;
        float humidity = biome.rainfall;
        float temperature = biome.getFloatTemperature(pos);      
        if(!isUnderTheSun || isRaining)
        {
            f = 0.0F;
        } else
        {
        	if (isDaytime)
        	{
        		f = worldIn.getLightFromNeighbors(pos.up()) * 0.05F;
        	}
        	else
        	{
        		f = worldIn.getLightFromNeighbors(pos.up()) * 0.025F;
        	}
            f = (float)((double)f * ((double)humidity >= 0.2D ? (double)humidity >= 0.7D ? (double)humidity >= 0.9D ? 0.3D : 0.5D : 0.8D : 1.2D));
            f = (float)((double)f * ((double)temperature >= 0.0D ? (double)temperature >= 0.6D ? (double)temperature >= 1.0D ? 1.7D : 1.1D : 0.6D : 0.2D));
        }
        return f;
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
            ItemStack itemstack1 = new ItemStack(ItemLoader.tea_leaf, 8);
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
}
