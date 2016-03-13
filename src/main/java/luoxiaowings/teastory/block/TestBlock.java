package luoxiaowings.teastory.block;

import luoxiaowings.teastory.common.EventLoader;
import luoxiaowings.teastory.creativetab.CreativeTabsLoader;
import luoxiaowings.teastory.item.ItemLoader;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class TestBlock extends Block
{	 
    public TestBlock()
        {
	        super(Material.rock);
	        this.setCreativeTab(CreativeTabsLoader.tabteastory);
	        this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.375F, 1.0F);
	        this.setUnlocalizedName("testblock");          
        }
    
    public boolean isOpaqueCube()
	{
	    return false;
	}
	
	public boolean isFullCube()
    {
        return false;
    }
}
