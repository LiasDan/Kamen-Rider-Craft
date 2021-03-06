package Kamen_Rider_Craft_4TH.item.zi_o;

import javax.annotation.Nullable;

import Kamen_Rider_Craft_4TH.TokuCraft_core;
import Kamen_Rider_Craft_4TH.item.ghost.item_ghost_armor3;
import Kamen_Rider_Craft_4TH.model.bigBiped;
import Kamen_Rider_Craft_4TH.model.tokuArmorModel;
import Kamen_Rider_Craft_4TH.util.IHasModel;
import Kamen_Rider_Craft_4TH.util.Refercence;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.util.ResourceLocation;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;

public class item_zi_oarmor2 extends ItemArmor implements IHasModel
{
	public static final String[] CoreName= new String[] {"","_decade","_ii","_revive","_trinity","_grand","_bibiru","_ohma"};

	private static final int[] maxDamageArray = new int[] {11, 16, 15, 13};
	public String armorNamePrefix;
	public ArmorMaterial material;

	public item_zi_oarmor2 (String name,ArmorMaterial par2EnumArmorMaterial, int par3, EntityEquipmentSlot par4)
	{
		super(par2EnumArmorMaterial, par3, par4);
		par2EnumArmorMaterial.getDamageReductionAmount(par4);
		this.setMaxDamage(par2EnumArmorMaterial.getDurability(par4));
		this.maxStackSize = 1;

		setTranslationKey(name);
		setRegistryName(name);
		TokuCraft_core.ITEMS.add(this);
	}

	@Override
	public void registerModels() {
		TokuCraft_core.proxy.registerItemRender(this,0,"inventory");
	}

	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, EntityEquipmentSlot slot, String type)
	{
		if (entity instanceof EntityLivingBase){
			EntityLivingBase player = ((EntityLivingBase)entity);


			if (player.getItemStackFromSlot(EntityEquipmentSlot.FEET)!= null){

				if (player.getItemStackFromSlot(EntityEquipmentSlot.FEET).getItem() instanceof item_zikudriver){
					String rider = ((item_zikudriver)player.getItemStackFromSlot(EntityEquipmentSlot.FEET).getItem()).Rider;
				

{
							if ( slot == EntityEquipmentSlot.LEGS)
							{

								if (item_zikudriver.get_core(player.getItemStackFromSlot(EntityEquipmentSlot.FEET), "1")==1){
								return Refercence.MODID+":textures/armor/"+rider+CoreName[item_zikudriver.get_core(player.getItemStackFromSlot(EntityEquipmentSlot.FEET), "1")]+"_"+item_zikudriver.get_lockbase(player.getItemStackFromSlot(EntityEquipmentSlot.FEET))+"_2.png";
								}else{
									return Refercence.MODID+":textures/armor/"+rider+CoreName[item_zikudriver.get_core(player.getItemStackFromSlot(EntityEquipmentSlot.FEET), "1")]+"_2.png";	
								}
							}
							if (slot == EntityEquipmentSlot.HEAD||slot == EntityEquipmentSlot.CHEST )
							{
								if (item_zikudriver.get_core(player.getItemStackFromSlot(EntityEquipmentSlot.FEET), "1")==1){
									return Refercence.MODID+":textures/armor/"+rider+CoreName[item_zikudriver.get_core(player.getItemStackFromSlot(EntityEquipmentSlot.FEET), "1")]+"_"+item_zikudriver.get_lockbase(player.getItemStackFromSlot(EntityEquipmentSlot.FEET))+"_1.png";
									}else{
										return Refercence.MODID+":textures/armor/"+rider+CoreName[item_zikudriver.get_core(player.getItemStackFromSlot(EntityEquipmentSlot.FEET), "1")]+"_1.png";	
									}
						}
					}

				}
				return Refercence.MODID+":textures/armor/blank.png";


			}
		}
		else
		{
			return Refercence.MODID+":textures/armor/blank.png";



		}
		return Refercence.MODID+":textures/armor/blank.png";

	}



	@Override
	@SideOnly(Side.CLIENT)
	@Nullable
	public ModelBiped getArmorModel(EntityLivingBase living, ItemStack stack, EntityEquipmentSlot slot, ModelBiped defaultModel)
	{
		
		if(!stack.isEmpty())
		{
			if(stack.getItem() instanceof item_zi_oarmor2)
			{ tokuArmorModel armorModel = new tokuArmorModel();
	if(armorModel != null){

				armorModel.bipedBody2.showModel = slot == EntityEquipmentSlot.LEGS;
				armorModel.bipedRightArm2.showModel = slot == EntityEquipmentSlot.CHEST;
				armorModel.bipedLeftArm2.showModel = slot == EntityEquipmentSlot.LEGS;

				armorModel.bipedLeftLeg2.showModel = slot == EntityEquipmentSlot.CHEST;
				armorModel.bipedRightLeg2.showModel = slot == EntityEquipmentSlot.LEGS;

				armorModel.bipedBody3.showModel = slot == EntityEquipmentSlot.CHEST;

				armorModel.bipedHead2.showModel = slot == EntityEquipmentSlot.HEAD;
				armorModel.bipedHeadwear2.showModel = slot == EntityEquipmentSlot.HEAD;


				armorModel.isSneak = living.isSneaking();
				armorModel.isRiding = living.isRiding();
				armorModel.isChild = living.isChild();
				armorModel.swingProgress = living.swingProgress;

				return armorModel;
			}

			}
			}
		return null;
	}
}
