package luoxiaowings.teastory.achievement;

import luoxiaowings.teastory.TeaStory;
import luoxiaowings.teastory.block.BlockLoader;
import luoxiaowings.teastory.item.ItemLoader;
import net.minecraft.stats.Achievement;
import net.minecraft.stats.AchievementList;
import net.minecraftforge.common.AchievementPage;

public class AchievementLoader
{
	public static Achievement teaAStoryOfLeaves = new Achievement("achievement.teastory.teaAStoryOfLeaves", "teastory.teaAStoryOfLeaves", 0, 0, ItemLoader.tea_leaf, null);
	public static Achievement whatsThis = new Achievement("achievement.teastory.whatsThis", "teastory.whatsThis", 3, -2, ItemLoader.burnt_tea, teaAStoryOfLeaves);
	public static Achievement isItEdible = new Achievement("achievement.teastory.isItEdible", "teastory.isItEdible", 3, -5, ItemLoader.burnt_green_tea, whatsThis);
	public static Achievement dryingTea = new Achievement("achievement.teastory.dryingTea", "teastory.dryingTea", 3, 2, BlockLoader.dustpan, teaAStoryOfLeaves);
	public static Achievement wet = new Achievement("achievement.teastory.wet", "teastory.wet", 0, 4, ItemLoader.wet_tea, teaAStoryOfLeaves);
	public static Achievement popularDrink = new Achievement("achievement.teastory.popularDrink", "teastory.popularDrink", 3, 5, ItemLoader.green_tea, dryingTea);
	public static Achievement anotherDrink = new Achievement("achievement.teastory.anotherDrink", "teastory.anotherDrink", 6, 3, ItemLoader.matcha, dryingTea);
	public static Achievement warmthOrHarm = new Achievement("achievement.teastory.warmthOrHarm", "teastory.warmthOrHarm", -2, 0, ItemLoader.hot_water, null);
	public static AchievementPage pageTeaStory = new AchievementPage(TeaStory.NAME, teaAStoryOfLeaves, whatsThis, isItEdible, dryingTea, wet, popularDrink, anotherDrink, warmthOrHarm);
	public AchievementLoader()
    {
		teaAStoryOfLeaves.registerStat();
		whatsThis.registerStat();
		isItEdible.registerStat();
		dryingTea.registerStat();
		wet.registerStat();
		popularDrink.registerStat();
		anotherDrink.registerStat();
		warmthOrHarm.registerStat();
		AchievementPage.registerAchievementPage(pageTeaStory);
    }
}
