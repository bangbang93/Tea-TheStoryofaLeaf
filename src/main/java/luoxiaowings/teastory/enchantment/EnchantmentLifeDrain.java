package luoxiaowings.teastory.enchantment;

import java.util.Random;

import luoxiaowings.teastory.TeaStory;
import luoxiaowings.teastory.common.ConfigLoader;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ResourceLocation;

public class EnchantmentLifeDrain extends Enchantment
{
	protected EnchantmentLifeDrain()
    {
		super(ConfigLoader.enchantmentLifeDrainId, new ResourceLocation(TeaStory.MODID + ":" + "life_drain"), 6, EnumEnchantmentType.WEAPON);
		this.setName("lifeDrain");
	}
	
	@Override
    public int getMinEnchantability(int enchantmentLevel)
    {
        return 30;
    }

    @Override
    public int getMaxEnchantability(int enchantmentLevel)
    {
        return super.getMinEnchantability(enchantmentLevel) + 50;
    }

    @Override
    public int getMaxLevel()
    {
        return 4;
    }
    
    public void onEntityDamaged(EntityLivingBase user, Entity target, int level)
    {
    	float r = user.getRNG().nextFloat();
    	ItemSword item =  (ItemSword) user.getHeldItem().getItem();
    	float attackDamage = item.getDamageVsEntity() + 4.0F;
    	float health = user.getHealth();
        if (health < user.getMaxHealth() && r <= level*0.2F)
        {
        	user.setHealth(health + attackDamage*r*0.5F);
        }
    }
	
}
