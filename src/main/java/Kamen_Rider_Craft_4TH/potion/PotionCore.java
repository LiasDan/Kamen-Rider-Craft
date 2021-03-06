package Kamen_Rider_Craft_4TH.potion;

import net.minecraft.client.Minecraft;
import net.minecraft.potion.Potion;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class PotionCore {

	private static final Potion FLY= new PotionFly();
	public static final Potion FLY_POTION = FLY_POTION();
	
	public static final Potion FIRE_PUNCH_POTION = new PotionFirePunch();
	public static final Potion PUNCH_BOOST_POTION = new PotionPunchBoost();
	public static final Potion BIG_POTION = new PotionBig();
	
	private static Potion FLY_POTION(){
		if (Potion.getPotionFromResourceLocation("tokuPotions"+ ":" + "fly")!=null){
			return Potion.getPotionFromResourceLocation("tokuPotions"+ ":" + "fly");
		}else{
		return FLY;
		}
	}
	
	
	public static void init(FMLInitializationEvent event) {
		ForgeRegistries.POTIONS.register(FLY);
		ForgeRegistries.POTIONS.register(FIRE_PUNCH_POTION);
		ForgeRegistries.POTIONS.register(PUNCH_BOOST_POTION);
		ForgeRegistries.POTIONS.register(BIG_POTION);
	}
	
}