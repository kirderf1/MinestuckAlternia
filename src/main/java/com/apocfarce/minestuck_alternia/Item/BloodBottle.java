package com.apocfarce.minestuck_alternia.Item;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.UseAction;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class BloodBottle extends Item  {
	public EnumBloodColor color;
	public BloodBottle(Item.Properties properties, EnumBloodColor bloodColor) {
		super(properties);
		color=bloodColor;
	}
	public EnumBloodColor GetBloodColor() {
		return color;
	}
	
	
	@Override
	 public ItemStack onItemUseFinish(ItemStack stack, World worldIn, LivingEntity entityLiving)
	 {
		PlayerEntity entityplayer = entityLiving instanceof PlayerEntity ? (PlayerEntity)entityLiving : null;
		 //destroy this potion(as it has been drank)
		 if (entityplayer == null || !entityplayer.isCreative());
		 {
			 stack.shrink(1);
		 }
		 //???? it seems to break when i remove this set of code, so i keep it in
		 if (entityplayer instanceof ServerPlayerEntity)
		 {
			 CriteriaTriggers.CONSUME_ITEM.trigger((ServerPlayerEntity)entityplayer, stack);
		 }
		 //give the player nausia
		 if (!worldIn.isRemote)
		 {
			 entityLiving.addPotionEffect(new EffectInstance(new EffectInstance(Effects.NAUSEA,600,0)));

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
	   public UseAction getUseAction(ItemStack stack) {
	      return UseAction.DRINK;
	   }
	 @Override
	 public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn)
	 {
		  playerIn.setActiveHand(handIn);
		 return new ActionResult<ItemStack>(ActionResultType.SUCCESS, playerIn.getHeldItem(handIn));
	 }
}
