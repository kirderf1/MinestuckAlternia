package main.java.com.apocfarce.minestuck_alternia.Item;

import main.java.com.apocfarce.minestuck_alternia.Minestuck_alternia;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class BloodBottle extends Item  {
	public ENUM_BLOOD_COLOR color;
	public BloodBottle(Item.Properties properties,ENUM_BLOOD_COLOR bloodColor) {
		super(properties);
		color=bloodColor;
	}
	public ENUM_BLOOD_COLOR GetBloodColor() {
		return color;
	}
	
	
	@Override
	 public ItemStack onItemUseFinish(ItemStack stack, World worldIn, EntityLivingBase entityLiving)
	 {
		 EntityPlayer entityplayer = entityLiving instanceof EntityPlayer ? (EntityPlayer)entityLiving : null;
		 //destroy this potion(as it has been drank)
		 if (entityplayer == null || !entityplayer.isCreative());
		 {
			 stack.shrink(1);
		 }
		 //???? it seems to break when i remove this set of code, so i keep it in
		 if (entityplayer instanceof EntityPlayerMP)
		 {
			 CriteriaTriggers.CONSUME_ITEM.trigger((EntityPlayerMP)entityplayer, stack);
		 }
		 //give the player nausia
		 if (!worldIn.isRemote)
		 {
			 entityLiving.addPotionEffect(new PotionEffect(new PotionEffect(MobEffects.NAUSEA, 600, 0)));
		 }
		 //let the player keep the glass bottle
		 if (entityplayer == null)
		 {
			 if (stack.isEmpty())
			 {
				 return new ItemStack(Items.GLASS_BOTTLE);
			 }
		 }else {
			 if (entityplayer != null)
			 {
				 if(entityplayer.isCreative()){
					 entityplayer.inventory.addItemStackToInventory(new ItemStack(this));
				 }else {
					 entityplayer.inventory.addItemStackToInventory(new ItemStack(Items.GLASS_BOTTLE));
				 }
			 }
		 }
		 return stack;
	 }
	@Override
    public int getUseDuration(ItemStack stack)
    {
        return 32;
    }
	 @Override
	 public EnumAction getUseAction(ItemStack stack)
	 {
		 return EnumAction.DRINK;
	 }
	 @Override
	 public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn)
	 {
		  playerIn.setActiveHand(handIn);
		 return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, playerIn.getHeldItem(handIn));
	 }
}
