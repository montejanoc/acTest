package gui.panels.chat;

import java.util.ArrayList;
import java.util.List;

import objects.ChatMessage;
import objects.DefaultInfiniteContainer;

import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.InfiniteContainer;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.GridLayout;

public class ChatPanel extends Form {
	
	private ChatPanelController controller;
	
	private DefaultInfiniteContainer messageForm;
	private ChatPanelKeyboard keyboard;
	
	public ChatPanel(ChatPanelController controller) {
		this.controller = controller;
		
		messageForm = new DefaultInfiniteContainer();
		messageForm.setScrollableY(true);
		
		keyboard = new ChatPanelKeyboard();

		this.setLayout(new BorderLayout());
		
		this.add(BorderLayout.CENTER, messageForm);
		this.add(BorderLayout.SOUTH, keyboard);
		
		controller.addChatPanelCommands(this);
	}
	
	@Override
	public void show() {
		setTitle(controller.getChatGroup().getChatName());
		
		List<ChatBubble> bubbles = new ArrayList<>();
		for (ChatMessage chatMessage : controller.getChatGroup().getChatMessages()) {
			bubbles.add(new ChatBubble(chatMessage));
		}
		messageForm.setComponents(bubbles);
		
		super.show();
	}
	
	
}
