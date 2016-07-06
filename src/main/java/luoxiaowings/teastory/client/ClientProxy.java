package luoxiaowings.teastory.client;

import luoxiaowings.teastory.block.BlockLoader;
import luoxiaowings.teastory.common.CommonProxy;
import luoxiaowings.teastory.item.ItemLoader;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;


public class ClientProxy extends CommonProxy
{
    @Override
    public void preInit(FMLPreInitializationEvent event)
    {
        super.preInit(event);
        BlockLoader.preInit();
        ItemLoader.preInit();
    }

    @Override
    public void init(FMLInitializationEvent event)
    {
        super.init(event);
        new ItemRenderLoader();
    }

    @Override
    public void postInit(FMLPostInitializationEvent event)
    {
        super.postInit(event);
    }
}
