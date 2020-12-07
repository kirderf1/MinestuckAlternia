package com.apocfarce.minestuck_alternia.client;

import com.apocfarce.minestuck_alternia.network.AlterniaPacketHandler;
import com.apocfarce.minestuck_alternia.network.DimensionSelectionPacket;
import com.apocfarce.minestuck_alternia.util.BloodColor;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.client.resources.I18n;
import net.minecraft.util.text.TranslationTextComponent;

public class BloodSelectionScreen extends Screen {
	
	public static final String TITLE = "blood_selection.title", PROMPT = "blood_selection.prompt";
	
	public BloodSelectionScreen() {
		super(new TranslationTextComponent(TITLE));
	}
	
	@Override
	protected void init() {
		for(BloodColor color : BloodColor.values()) {
			int x = width/2 - 100 + (color.ordinal() % 2)*100;
			int y = height/2 - 60 + (color.ordinal() / 2)*20;
			if(color == BloodColor.LIME)	//the last color
				x =  width/2 - 50;
			
			addButton(new Button(x, y, 100, 20, new TranslationTextComponent(color.getTranslationKey()), button -> pickColor(color)));
		}
	}
	
	@Override
	public void render(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {
		renderBackground(matrixStack);
		
		super.render(matrixStack, mouseX, mouseY, partialTicks);
		drawCenteredString(matrixStack, font, I18n.format(PROMPT), width/2, height/2 - 80, 0xFFFFFF);
	}
	
	@Override
	public boolean shouldCloseOnEsc() {
		return false;
	}
	
	private void pickColor(BloodColor color) {
		AlterniaPacketHandler.INSTANCE.sendToServer(DimensionSelectionPacket.alternia(color));
		StartDimensionSelectionScreen.shouldShowScreen = false;
		closeScreen();
	}
}