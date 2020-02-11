package com.apocfarce.minestuck_alternia.client.render;

import com.apocfarce.minestuck_alternia.Item.block.PortalCenterItem;
import com.apocfarce.minestuck_alternia.block.AlterniaBlocks;
import com.mojang.blaze3d.platform.GlStateManager;
import net.minecraft.block.BlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.*;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class PortalOutline
{
	

	
	public static void renderWorld(RenderWorldLastEvent event)
	{
		Minecraft mc = Minecraft.getInstance();
		
		if (mc.player != null && mc.getRenderViewEntity() == mc.player && mc.objectMouseOver.getType() == RayTraceResult.Type.BLOCK)
		{
			if(mc.objectMouseOver instanceof EntityRayTraceResult) return;
			BlockRayTraceResult rayTraceResult = (BlockRayTraceResult) mc.objectMouseOver;
			if (rayTraceResult == null || rayTraceResult.getFace() != Direction.UP)
				return;
			
			if (!renderCheckItem(mc.player, Hand.MAIN_HAND, mc.player.getHeldItemMainhand(), event.getContext(), rayTraceResult, event.getPartialTicks()))
				 renderCheckItem(mc.player, Hand.OFF_HAND, mc.player.getHeldItemOffhand(), event.getContext(), rayTraceResult, event.getPartialTicks());
		}
	}
	
	private static boolean renderCheckItem(ClientPlayerEntity player, Hand hand, ItemStack stack, WorldRenderer render, BlockRayTraceResult rayTraceResult, float partialTicks)
	{

		if(stack.isEmpty())
			return false;
/*		if(stack.getItem() == AlterniaBlocks.portal.asItem())
		{
			boolean placeable;
			AxisAlignedBB boundingBox;
			BlockPos pos = rayTraceResult.getPos();
			BlockItemUseContext context = new BlockItemUseContext(new ItemUseContext(player, hand, rayTraceResult));
			Direction placedFacing = player.getHorizontalFacing().getOpposite();


			
			
			if (!player.world.getBlockState(pos).isReplaceable(context)) {
				pos = pos.up();
			}
			
			switch(placedFacing) {
			case WEST://default to keep all things positive
				break;
			case SOUTH:pos=pos.north(3);
				break;
			case NORTH:pos = pos.west(3);
				break;
			case EAST:pos=pos.north(3).west(3);
				break;
			default:break;
			}
			

			//Get Player's acurate position
			double dx = player.lastTickPosX + (player.posX - player.lastTickPosX) * (double)partialTicks;
			double dy = player.lastTickPosY + (player.posY - player.lastTickPosY) * (double)partialTicks;
			double dz = player.lastTickPosZ + (player.posZ - player.lastTickPosZ) * (double)partialTicks;
			//dont know why i need to do this, but as the box is constatnly 1+10/16 above where it should be and this fixes it
			dy=dy+(1D+(10D/16D));

			
			
			//GL stuff was copied from the standard mouseover bounding box drawing, which is likely why the alpha isn't working
			GlStateManager.blendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
			GlStateManager.lineWidth(2.0F);
			GlStateManager.disableTexture();
			GlStateManager.depthMask(false);	
			

			
			
		
			

			
			boundingBox = new AxisAlignedBB(0, 0, 0, 4, 5, 4).offset(pos).offset(-dx, -dy, -dz).shrink(0.002);
			placeable = PortalCenterItem.canPlaceAt(context, placedFacing);

			
			WorldRenderer.drawSelectionBoundingBox(boundingBox, placeable ? 0 : 1, placeable ? 1 : 0, 0, 0.5F);

			GlStateManager.depthMask(true);
			GlStateManager.enableTexture();
			GlStateManager.disableBlend();
			return true;
		}*/
		return false;
	}
}
