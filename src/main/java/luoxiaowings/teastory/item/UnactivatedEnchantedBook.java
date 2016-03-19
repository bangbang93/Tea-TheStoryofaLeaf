package luoxiaowings.teastory.item;

import luoxiaowings.teastory.common.ConfigLoader;
import luoxiaowings.teastory.creativetab.CreativeTabsLoader;
import luoxiaowings.teastory.enchantment.EnchantmentLoader;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentData;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class UnactivatedEnchantedBook extends TSItem
{
	public UnactivatedEnchantedBook()
    {
 	    super("unactivated_enchanted_book", 1);
    }
	
	@Override
	public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn)
	{
		Enchantment enchantment = EnchantmentLoader.lifeDrain;
        ItemStack itemstack = Items.enchanted_book.getEnchantedItemStack(new EnchantmentData(enchantment, 1));
		return itemstack;
	}
}
