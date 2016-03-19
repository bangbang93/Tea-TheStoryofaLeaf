package luoxiaowings.teastory.item;

import luoxiaowings.teastory.TeaStory;
import luoxiaowings.teastory.creativetab.CreativeTabsLoader;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemEnchantedBook;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemSoup;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemLoader
{
    public static Item tea_leaf = new TSItem("tea_leaf", 64);
    public static Item dried_tea = new TSItem("dried_tea", 64);
    public static Item sieve = new TSItem("sieve", 64);
    public static Item brush = new TSItem("brush", 64);
    public static Item burnt_tea = new TSItem("burnt_tea", 64);
    public static Item wet_tea = new TSItem("wet_tea", 64);
    public static Item broken_tea = new TSItem("broken_tea", 64);
    public static Item matcha = new TSItem("matcha", 64);
    public static Item mortar_and_pestle = new TSItem("mortar_and_pestle", 64);
    public static Item unactivated_enchanted_book = new UnactivatedEnchantedBook();
    public static Item dirty_sieve =new DirtySieve();
    public static ItemFood hot_water = new HotWater();
    public static ItemSoup green_tea = new GreenTea();
    public static ItemSoup burnt_green_tea = new BurntGreenTea();
    public static ItemSoup matcha_drink = new MatchaDrink();

    public ItemLoader(FMLPreInitializationEvent event)
    {
        register(tea_leaf);
        register(dried_tea);
        register(hot_water);
        register(green_tea);
        register(sieve);
        register(dirty_sieve);
        register(brush);
        register(burnt_tea);
        register(wet_tea);
        register(broken_tea);
        register(matcha);
        register(mortar_and_pestle);
        register(unactivated_enchanted_book);
        register(burnt_green_tea);
        register(matcha_drink);
    }
    
    @SideOnly(Side.CLIENT)
    public static void registerRenders()
    {
        registerRender(tea_leaf);
        registerRender(dried_tea);
        registerRender(hot_water);
        registerRender(green_tea);
        registerRender(sieve);
        registerRender(dirty_sieve);
        registerRender(brush);
        registerRender(burnt_tea);
        registerRender(wet_tea);
        registerRender(broken_tea);
        registerRender(matcha);
        registerRender(mortar_and_pestle);
        registerRender(unactivated_enchanted_book);
        registerRender(burnt_green_tea);
        registerRender(matcha_drink);
    }

    private static void register(Item item)
    {
        GameRegistry.registerItem(item, item.getUnlocalizedName().substring(5));
    }
    
    @SideOnly(Side.CLIENT)
    private static void registerRender(Item item)
    {
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0,
                new ModelResourceLocation(TeaStory.MODID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
    }
}

