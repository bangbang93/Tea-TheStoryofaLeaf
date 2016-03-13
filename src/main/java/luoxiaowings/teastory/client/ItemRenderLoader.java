package luoxiaowings.teastory.client;

import luoxiaowings.teastory.block.BlockLoader;
import luoxiaowings.teastory.item.ItemLoader;

public class ItemRenderLoader
{

	public ItemRenderLoader()
    {
		ItemLoader.registerRenders();
		BlockLoader.registerRenders();
    }
}
