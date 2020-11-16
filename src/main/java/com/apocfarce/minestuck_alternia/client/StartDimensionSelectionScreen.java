package com.apocfarce.minestuck_alternia.client;

import com.apocfarce.minestuck_alternia.network.AlterniaPacketHandler;
import com.apocfarce.minestuck_alternia.network.DimensionSelectionPacket;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.util.text.StringTextComponent;

public class StartDimensionSelectionScreen extends Screen {
	
	public StartDimensionSelectionScreen() {
		super(new StringTextComponent("Start dimension selection"));	//TODO should probably be a proper translation
	}
	
	@Override
	protected void init() {
		addButton(new Button(width/2 - 100, height/2 - 10, 200, 20, "Overworld", this::pickOverworld));
		addButton(new Button(width/2 - 100, height/2 + 10, 200, 20, "Alternia", this::pickAlternia));
	}
	
	@Override
	public void render(int mouseX, int mouseY, float partialTicks) {
		renderBackground();
		
		super.render(mouseX, mouseY, partialTicks);
		//TODO translation key
		drawCenteredString(font, "Select a home dimension", width/2, height/2 - 50, 0xFFFFFF);
	}
	
	@Override
	public boolean shouldCloseOnEsc() {
		return false;
	}
	
	private void pickOverworld(Button button) {
		AlterniaPacketHandler.INSTANCE.sendToServer(new DimensionSelectionPacket(false));
		onClose();
	}
	
	private void pickAlternia(Button button) {
		AlterniaPacketHandler.INSTANCE.sendToServer(new DimensionSelectionPacket(true));
		onClose();
	}
}