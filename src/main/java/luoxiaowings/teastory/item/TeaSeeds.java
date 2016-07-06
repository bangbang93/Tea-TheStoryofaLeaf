package luoxiaowings.teastory.item;

import luoxiaowings.teastory.block.BlockLoader;
import luoxiaowings.teastory.creativetab.CreativeTabsLoader;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemSeeds;

public class TeaSeeds extends ItemSeeds
{
	public TeaSeeds()
	{
		super((Block)BlockLoader.teaplant, Blocks.farmland);
        this.setUnlocalizedName("tea_seeds");
        this.setMaxStackSize(64);
        this.setCreativeTab(CreativeTabsLoader.tabteastory);
	}
}
