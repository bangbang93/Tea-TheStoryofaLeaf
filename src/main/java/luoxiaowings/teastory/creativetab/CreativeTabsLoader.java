package luoxiaowings.teastory.creativetab;

import luoxiaowings.teastory.item.ItemLoader;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CreativeTabsLoader
{
    public static CreativeTabs tabteastory;

    public CreativeTabsLoader(FMLPreInitializationEvent event)
    {
        tabteastory = new CreativeTabs("tabteastory")
        {
            @Override
            public Item getTabIconItem()
            {
                return ItemLoader.tea_leaf;
            }
        };
    }
}
