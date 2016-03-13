package luoxiaowings.teastory.block;

import luoxiaowings.teastory.TeaStory;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BlockModelShapes;
import net.minecraft.client.renderer.block.statemap.StateMap;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockLoader
{
    public static Block dustpan = new Dustpan();
    public static Block dustpan_full = new DustpanFull();
    public static Block dustpan_dried = new DustpanDried();
    public static Block dustpan_wet = new DustpanWet();

    public BlockLoader(FMLPreInitializationEvent event)
    {
        register(dustpan, "dustpan");
        register(dustpan_full, "dustpan_full");
        register(dustpan_dried, "dustpan_dried");
        register(dustpan_wet, "dustpan_wet");
    }

    @SideOnly(Side.CLIENT)
    public static void registerRenders()
    {
        registerRender(dustpan, "dustpan");
        registerRender(dustpan_full, "dustpan_full");
        registerRender(dustpan_dried, "dustpan_dried");
        registerRender(dustpan_wet, "dustpan_wet");
	}
    
    private static void register(Block block, String name)
    {
        GameRegistry.registerBlock(block, name);
    }

    @SideOnly(Side.CLIENT)
    private static void registerRender(Block block, String name)
    {
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(block), 0, new ModelResourceLocation(TeaStory.MODID + ":" + name, "inventory"));
    }
}