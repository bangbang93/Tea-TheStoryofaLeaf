package luoxiaowings.teastory.block;

import luoxiaowings.teastory.TeaStory;
import net.minecraft.block.Block;
import net.minecraft.block.BlockCrops;
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
    public static Block teapan = new Teapan();
    public static Block barrel = new Barrel();
    public static BlockCrops teaplant = new Teaplant();

    public BlockLoader(FMLPreInitializationEvent event)
    {
        GameRegistry.registerBlock(teapan, ItemBlockMeta.class, "teapan");
        GameRegistry.registerBlock(barrel, ItemBlockMeta.class, "barrel");
        register(teaplant, "teaplant");
    }
    
    public static void preInit()
    {
    	ModelBakery.addVariantName(Item.getItemFromBlock(BlockLoader.teapan), "teastory:teapan_empty", "teastory:teapan_full", "teastory:teapan_dried", "teastory:teapan_matcha", "teastory:teapan_wet");
    	ModelBakery.addVariantName(Item.getItemFromBlock(BlockLoader.barrel), "teastory:barrel_empty", "teastory:barrel_full", "teastory:barrel_full2", "teastory:barrel_fermentation", "teastory:barrel_blacktea");
    }

    @SideOnly(Side.CLIENT)
    public static void registerRenders()
    {
    	registerRender(barrel, 0, "barrel_empty");
        registerRender(barrel, 1, "barrel_full");
        registerRender(barrel, 2, "barrel_full2");
        registerRender(barrel, 3, "barrel_fermentation");
        registerRender(barrel, 4, "barrel_blacktea");
        registerRender(teapan, 0, "teapan_empty");
        registerRender(teapan, 1, "teapan_full");
        registerRender(teapan, 2, "teapan_dried");
        registerRender(teapan, 3, "teapan_matcha");
        registerRender(teapan, 4, "teapan_wet");
        registerRender(teaplant, "teaplant");
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
    
    @SideOnly(Side.CLIENT)
    private static void registerRender(Block block, int meta, String name)
    {
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(block), meta, new ModelResourceLocation(TeaStory.MODID + ":" + name, "inventory"));
    }
}