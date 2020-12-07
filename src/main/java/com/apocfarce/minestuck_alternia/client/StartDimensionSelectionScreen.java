package com.apocfarce.minestuck_alternia.client;

import com.apocfarce.minestuck_alternia.network.AlterniaPacketHandler;
import com.apocfarce.minestuck_alternia.network.DimensionSelectionPacket;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.client.resources.I18n;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.client.event.ClientPlayerNetworkEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class StartDimensionSelectionScreen extends Screen {
	
	public static final String TITLE = "start_dim_selection.title", PROMPT = "start_dim_selection.prompt",
			OVERWORLD = "start_dim_selection.overworld", ALTERNIA = "start_dim_selection.alternia";
	
	public StartDimensionSelectionScreen() {
		super(new TranslationTextComponent(TITLE));
	}
	
	@Override
	protected void init() {
		addButton(new Button(width/2 - 100, height/2 - 10, 200, 20, new TranslationTextComponent(OVERWORLD), this::pickOverworld));
		addButton(new Button(width/2 - 100, height/2 + 10, 200, 20, new TranslationTextComponent(ALTERNIA), this::pickAlternia));
	}
	
	@Override
	public void render(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {
		renderBackground(matrixStack);
		
		super.render(matrixStack, mouseX, mouseY, partialTicks);
		drawCenteredString(matrixStack, font, I18n.format(PROMPT), width/2, height/2 - 50, 0xFFFFFF);
	}
	
	@Override
	public boolean shouldCloseOnEsc() {
		return false;
	}
	
	private void pickOverworld(Button button) {
		AlterniaPacketHandler.INSTANCE.sendToServer(DimensionSelectionPacket.overworld());
		shouldShowScreen = false;
		closeScreen();
	}
	
	@SuppressWarnings("ConstantConditions")
	private void pickAlternia(Button button) {
		minecraft.displayGuiScreen(new BloodSelectionScreen());
	}
	
	static boolean shouldShowScreen;
	
	public static void setShouldShowScreen() {
		shouldShowScreen = true;
	}
	
	@SubscribeEvent
	public static void clientTickEvent(TickEvent.ClientTickEvent event) {
		if(event.phase == TickEvent.Phase.END) {
			if(shouldShowScreen && Minecraft.getInstance().currentScreen == null)
				Minecraft.getInstance().displayGuiScreen(new StartDimensionSelectionScreen());
		}
	}
	
	@SubscribeEvent
	public static void onLogin(ClientPlayerNetworkEvent.LoggedInEvent event) {
		shouldShowScreen = false;
	}
}