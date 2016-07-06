package luoxiaowings.teastory.block;

import java.util.List;
import java.util.Random;

import luoxiaowings.teastory.block.Teapan.EnumType;
import luoxiaowings.teastory.creativetab.CreativeTabsLoader;
import luoxiaowings.teastory.item.ItemLoader;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class Barrel extends Block implements IMetaBlockName
{
	public Barrel()
	{
		super(Material.wood);     
        this.setHardness(0.5F);
        this.setStepSound(soundTypeWood);
        this.setTickRandomly(true);
        this.setUnlocalizedName("barrel");
        this.setDefaultState(this.blockState.getBaseState().withProperty(TYPE, EnumType.EMPTY));
        this.setCreativeTab(CreativeTabsLoader.tabteastory);
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
        int meta = getMetaFromState(worldIn.getBlockState(pos));
        if (meta == 3)
       	{
            float f = getGrowthChance(this, worldIn, pos);
            if (f == 0.0F)
            { 
              	return;
            }
            else if (rand.nextInt((int)(25.0F / f) + 1) == 0)
            {
                worldIn.setBlockState(pos, BlockLoader.barrel.getStateFromMeta(4), 2);
            }
       	}
    }
	
	protected static float getGrowthChance(Block blockIn, World worldIn, BlockPos pos)
    {
        float f = 1.0F;
        BiomeGenBase biome = worldIn.getBiomeGenForCoords(pos);
        boolean isDaytime = worldIn.getWorldTime() % 24000L < 12000L;
        float humidity = biome.rainfall;
        float temperature = biome.getFloatTemperature(pos);
        f = (float)((double)f * ((double)humidity >= 0.2D ? (double)humidity >= 0.5D ? (double)humidity >= 0.9D ? 0.8D : 1.4D : 0.6D : 0.4D));
        f = (float)((double)f * ((double)temperature >= 0.0D ? (double)temperature >= 0.5D ? (double)temperature >= 1.0D ? 1.2D : 2D : 0.8D : 0D));
        if (!worldIn.canSeeSky(pos)) return f;
        else return f = f * 0.5F;
    }
	
    @SideOnly(Side.CLIENT)
    public EnumWorldBlockLayer getBlockLayer()
    {
        return EnumWorldBlockLayer.CUTOUT;
    }
	
	@Override
	public void getSubBlocks(Item itemIn, CreativeTabs tab, List list) {
	    list.add(new ItemStack(itemIn, 1, 0)); //Meta 0
	}
	
    @Override
    protected BlockState createBlockState()
    {
        return new BlockState(this, new IProperty[] { TYPE });
    }
    
    @Override
    public IBlockState getStateFromMeta(int meta)
    {
        return getDefaultState().withProperty(TYPE, getState(meta));
    }
    
    public Comparable getState(int meta)
    {
    	switch(meta)
    	{
    	case 1:
    		return EnumType.FULL;
    	case 2:
            return EnumType.FULL2;
    	case 3:
        	return EnumType.FERMENTATION;
    	case 4:
            return EnumType.BLACKTEA;
        default:
            return EnumType.EMPTY;
    	}
    }

    @Override
    public int getMetaFromState(IBlockState state)
    {
        EnumType type = (EnumType) state.getValue(TYPE);
        return type.getID();
    }
    
    @Override
    public int damageDropped(IBlockState state)
    {
        return 0;
    }
    
    @Override
    public String getSpecialName(ItemStack stack)
    {
    	switch(stack.getItemDamage())
    	{
    	    case 1:
    		    return "full";
		    case 2:
		    	return "full2";
		    case 3:
		    	return "fermentation";
		    case 4:
		    	return "blacktea";
		    default:
		    	return "empty";
    	}
    }
    
    @Override
    public ItemStack getPickBlock(MovingObjectPosition target, World world, BlockPos pos)
    {
        return new ItemStack(Item.getItemFromBlock(this), 1, 0);
    }
    
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumFacing side, float hitX, float hitY, float hitZ)
    {
        if (worldIn.isRemote)
        {
            return true;
        }
        else
        {
            switch(getMetaFromState(worldIn.getBlockState(pos)))
        	{
        	    case 1:
        	    	if (playerIn.getHeldItem() != null)
                    {
        	    		if (playerIn.getHeldItem().getItem() instanceof ItemSpade)
        	    		{
        	    			worldIn.setBlockState(pos, BlockLoader.barrel.getStateFromMeta(0));
        	                playerIn.worldObj.spawnEntityInWorld(new EntityItem(playerIn.worldObj, playerIn.posX + 0.5D, playerIn.posY + 1.5D, playerIn.posZ + 0.5D, 
        	                        new ItemStack(ItemLoader.matcha_leaf, 8)));
        	    			return true;
        	    		}
        	    		else return false;
                    }
        	    	else if (playerIn.getRNG().nextFloat() < 0.5F)
                	{
        	       		worldIn.setBlockState(pos, BlockLoader.barrel.getStateFromMeta(2));
        	       		return true;
                	}
        	       	else return false;
        	    case 2:
        	    	if (playerIn.getHeldItem() != null)
                    {
        	    		if (playerIn.getHeldItem().getItem() == new ItemStack(Blocks.glass_pane, 1).getItem())
        	    		{
        	    			worldIn.setBlockState(pos, BlockLoader.barrel.getStateFromMeta(3));
        	    			playerIn.getHeldItem().stackSize --;
            	       		return true;
        	    		}
        	    		else if (playerIn.getHeldItem().getItem() instanceof ItemSpade)
        	    		{
        	    			worldIn.setBlockState(pos, BlockLoader.barrel.getStateFromMeta(0));
        	                playerIn.worldObj.spawnEntityInWorld(new EntityItem(playerIn.worldObj, playerIn.posX + 0.5D, playerIn.posY + 1.5D, playerIn.posZ + 0.5D, 
        	                   		new ItemStack(ItemLoader.matcha_leaf, 8)));
        	    			return true;
        	    		}
        	    		else return false;
                    }
        	    	
        	    case 3:
        	    	if (playerIn.getHeldItem() != null)
                    {
            	    	if (playerIn.getHeldItem().getItem() instanceof ItemSpade)
    	        		{
    	        			worldIn.setBlockState(pos, BlockLoader.barrel.getStateFromMeta(0));
        	                playerIn.worldObj.spawnEntityInWorld(new EntityItem(playerIn.worldObj, playerIn.posX + 0.5D, playerIn.posY + 1.5D, playerIn.posZ + 0.5D, 
        	                   		new ItemStack(ItemLoader.matcha_leaf, 8)));
        	                playerIn.worldObj.spawnEntityInWorld(new EntityItem(playerIn.worldObj, playerIn.posX + 0.5D, playerIn.posY + 1.5D, playerIn.posZ + 0.5D, 
        	                   		new ItemStack(Blocks.glass_pane, 1)));
    	    		    	return true;
    	    	    	}
    	    		    else return false;
                    }
        	    	else return false;
        	    case 4:
        	    	if (playerIn.getHeldItem().getItem() instanceof ItemSpade)
    	    		{
    	    			worldIn.setBlockState(pos, BlockLoader.barrel.getStateFromMeta(0));
    	                playerIn.worldObj.spawnEntityInWorld(new EntityItem(playerIn.worldObj, playerIn.posX + 0.5D, playerIn.posY + 1.5D, playerIn.posZ + 0.5D, 
    	                    	new ItemStack(ItemLoader.black_tea_leaf, 8)));
    	                playerIn.worldObj.spawnEntityInWorld(new EntityItem(playerIn.worldObj, playerIn.posX + 0.5D, playerIn.posY + 1.5D, playerIn.posZ + 0.5D, 
    	                    	new ItemStack(Blocks.glass_pane, 1)));
    	    			return true;
    	    		}
    	    		else return false;
                default:
                	if (playerIn.getHeldItem() != null)
                    {
                		if (playerIn.getHeldItem().getItem() == ItemLoader.matcha_leaf && playerIn.getHeldItem().stackSize >=8)
                		{
        	                worldIn.setBlockState(pos, BlockLoader.barrel.getStateFromMeta(1));
            	        	playerIn.getHeldItem().stackSize = playerIn.getHeldItem().stackSize - 8;
                            return true;
                		}
                		else return false;
            	    }
                	else return false;
        	}
        }
    }
	
	public static final PropertyEnum TYPE = PropertyEnum.create("type", Barrel.EnumType.class);
	
	public enum EnumType implements IStringSerializable
    {
		EMPTY(0, "empty"),
	    FULL(1, "full"),
		FULL2(2, "full2"),
		FERMENTATION(3, "fermentation"),
		BLACKTEA(4, "blacktea");

	    private int ID;
	    private String name;
	    
	    private EnumType(int ID, String name)
        {
	        this.ID = ID;
	        this.name = name;
	    }
	    
	    @Override
	    public String getName()
        {
	        return name;
	    }

	    public int getID()
        {
	        return ID;
	    }
	    
	    @Override
	    public String toString()
        {
	        return getName();
	    }
	}
}
