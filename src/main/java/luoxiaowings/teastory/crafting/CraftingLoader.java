package luoxiaowings.teastory.crafting;

import luoxiaowings.teastory.block.BlockLoader;
import luoxiaowings.teastory.common.ConfigLoader;
import luoxiaowings.teastory.item.ItemLoader;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.*;
import net.minecraftforge.fml.common.IFuelHandler;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CraftingLoader
{
    public CraftingLoader()
    {
        registerRecipe();
        registerSmelting();
        registerFuel();
    }

    private static void registerRecipe()
    {
    	
    	GameRegistry.addShapelessRecipe(new ItemStack(ItemLoader.green_tea, 1), new Object[] {ItemLoader.dried_tea, ItemLoader.dried_tea, ItemLoader.dried_tea, ItemLoader.hot_water, Items.bowl});
    	GameRegistry.addShapelessRecipe(new ItemStack(ItemLoader.burnt_green_tea, 1), new Object[] {ItemLoader.burnt_tea, ItemLoader.burnt_tea, ItemLoader.burnt_tea, ItemLoader.hot_water, Items.bowl});
    	GameRegistry.addShapelessRecipe(new ItemStack(ItemLoader.matcha_drink, 1), new Object[] {ItemLoader.matcha, ItemLoader.matcha, ItemLoader.matcha, ItemLoader.hot_water, Items.bowl});
    	GameRegistry.addShapelessRecipe(new ItemStack(ItemLoader.sieve, 1), new Object[] {ItemLoader.brush, ItemLoader.dirty_sieve.setContainerItem(ItemLoader.broken_tea)});
    	GameRegistry.addShapelessRecipe(new ItemStack(ItemLoader.matcha, 1), new Object[] {ItemLoader.dried_tea, ItemLoader.mortar_and_pestle});
    	GameRegistry.addShapelessRecipe(new ItemStack(ItemLoader.unactivated_enchanted_book, 1), new Object[] {Items.book, ItemLoader.tea_leaf, ItemLoader.dried_tea, ItemLoader.matcha, ItemLoader.burnt_tea, ItemLoader.wet_tea, ItemLoader.burnt_green_tea, ItemLoader.green_tea, ItemLoader.matcha_drink});
    	GameRegistry.addRecipe(new ItemStack(ItemLoader.tea_leaf, 1), new Object[]
    	        {"###", "###", "###", '#',Blocks.leaves});
    	GameRegistry.addRecipe(new ItemStack(ItemLoader.tea_leaf, 1), new Object[]
    	        {"###", "###", "###", '#',Blocks.leaves2});
    	GameRegistry.addRecipe(new ItemStack(ItemLoader.tea_leaf, 2), new Object[]
    	        {"###", "#*#", "###", '#',Blocks.leaves, '*',ItemLoader.sieve.setContainerItem(ItemLoader.dirty_sieve)});
    	GameRegistry.addRecipe(new ItemStack(ItemLoader.tea_leaf, 2), new Object[]
    	        {"###", "#*#", "###", '#',Blocks.leaves2  , '*',ItemLoader.sieve.setContainerItem(ItemLoader.dirty_sieve)});
    	GameRegistry.addRecipe(new ItemStack(ItemLoader.sieve, 1), new Object[]
    	        {"###", "#*#", "###", '#',Items.stick, '*',Items.string});
    	GameRegistry.addRecipe(new ItemStack(ItemLoader.brush, 4), new Object[]
    	        {"#", "*", '#', Items.string, '*', Items.stick});
    	GameRegistry.addRecipe(new ItemStack(ItemLoader.tea_leaf, 1), new Object[]
    	        {"###", "###", "###", '#',ItemLoader.broken_tea});
    	GameRegistry.addRecipe(new ItemStack(ItemLoader.mortar_and_pestle, 1), new Object[]
    	        {"#", "*", "+", '#',Items.stick, '*',Blocks.planks, '+',Items.bowl});
    	GameRegistry.addRecipe(new ItemStack(BlockLoader.dustpan, 1), new Object[]
    	        {"# #", "#*#", '#',Blocks.planks, '*',Items.stick});
    }

    private static void registerSmelting()
    {
    	GameRegistry.addSmelting(ItemLoader.wet_tea, new ItemStack(ItemLoader.dried_tea), 0.2f);
    	GameRegistry.addSmelting(ItemLoader.tea_leaf, new ItemStack(ItemLoader.burnt_tea), 0.2f);
        GameRegistry.addSmelting(Items.potionitem, new ItemStack(ItemLoader.hot_water), 0.1f);
    }

    private static void registerFuel()
    {
    	GameRegistry.registerFuelHandler(new IFuelHandler()
        {
            @Override
            public int getBurnTime(ItemStack fuel)
            {
                return ItemLoader.sieve != fuel.getItem() ? 0 : 300;
            }
        });
    	GameRegistry.registerFuelHandler(new IFuelHandler()
        {
            @Override
            public int getBurnTime(ItemStack fuel)
            {
                return ItemLoader.dirty_sieve != fuel.getItem() ? 0 : 300;
            }
        });
    }
}