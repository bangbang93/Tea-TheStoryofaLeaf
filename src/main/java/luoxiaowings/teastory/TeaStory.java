package luoxiaowings.teastory;

import luoxiaowings.teastory.common.CommonProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = TeaStory.MODID, name = TeaStory.NAME, version = TeaStory.VERSION)
public class TeaStory
{
    public static final String MODID = "teastory";
    public static final String NAME = "Tea Story";
    public static final String VERSION = "@version@";

    @Instance(TeaStory.MODID)
    public static TeaStory instance;
    
    @SidedProxy(clientSide = "luoxiaowings.teastory.client.ClientProxy", 
                         serverSide = "luoxiaowings.teastory.common.CommonProxy")
    public static CommonProxy proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
    	proxy.preInit(event);
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    	proxy.init(event);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
    	proxy.postInit(event);
    }
}
