package com.apocfarce.minestuck_alternia.client;

import com.apocfarce.minestuck_alternia.network.AlterniaPacketHandler;
import com.apocfarce.minestuck_alternia.network.DimensionSelectionPacket;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.client.resources.I18n;
import net.minecraft.util.text.TranslationTextComponent;

public class StartDimensionSelectionScreen extends Screen {
	
	public static final String TITLE = "start_dim_selection.title", PROMPT = "start_dim_selection.prompt",
			OVERWORLD = "start_dim_selection.overworld", ALTERNIA = "start_dim_selection.alternia";
	
	public StartDimensionSelectionScreen() {
		super(new TranslationTextComponent(TITLE));
	}
	
	@Override
	protected void init() {
		addButton(new Button(width/2 - 100, height/2 - 10, 200, 20, I18n.format(OVERWORLD), this::pickOverworld));
		addButton(new Button(width/2 - 100, height/2 + 10, 200, 20, I18n.format(ALTERNIA), this::pickAlternia));
	}
	
	@Override
	public void render(int mouseX, int mouseY, float partialTicks) {
		renderBackground();
		
		super.render(mouseX, mouseY, partialTicks);
		drawCenteredString(font, I18n.format(PROMPT), width/2, height/2 - 50, 0xFFFFFF);
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