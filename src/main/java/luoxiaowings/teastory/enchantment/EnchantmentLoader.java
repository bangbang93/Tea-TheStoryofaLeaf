package luoxiaowings.teastory.enchantment;

import org.apache.logging.log4j.LogManager;

import luoxiaowings.teastory.TeaStory;
import luoxiaowings.teastory.common.ConfigLoader;
import net.minecraft.enchantment.Enchantment;

public class EnchantmentLoader
{
	public static Enchantment lifeDrain;

    public EnchantmentLoader()
    {
        try
        {
            EnchantmentLoader.lifeDrain = new EnchantmentLifeDrain();
        }
        catch (Exception e)
        {
            LogManager.getLogger(TeaStory.MODID).error(
                    "Duplicate or illegal enchantment id: {}, the registry of class '{}' will be skipped. ",
                    ConfigLoader.enchantmentLifeDrainId, EnchantmentLifeDrain.class.getName());
        }
    }
}
