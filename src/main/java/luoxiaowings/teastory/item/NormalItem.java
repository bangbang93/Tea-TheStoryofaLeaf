package luoxiaowings.teastory.item;

import luoxiaowings.teastory.creativetab.CreativeTabsLoader;
import net.minecraft.item.Item;

public class NormalItem extends Item
{
	public NormalItem(String name, int maxstack)
    {
 	    super();
        this.setUnlocalizedName(name);
        this.setMaxStackSize(maxstack);
        this.setCreativeTab(CreativeTabsLoader.tabteastory);
    }
}
