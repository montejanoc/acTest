package gui.panels.chat;

import objects.ChatMessage;

import com.codename1.ui.Form;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.GridLayout;

public class ChatPanel extends Form {
	
	private ChatPanelController controller;
	
	private Form messageForm;
	private ChatPanelKeyboard keyboard;
	
	public ChatPanel(ChatPanelController controller) {
		this.controller = controller;
		
		messageForm = new Form();
		messageForm.setLayout(new GridLayout(1));
		keyboard = new ChatPanelKeyboard();

		this.setLayout(new BorderLayout());
		
		this.add(BorderLayout.CENTER, messageForm);
		this.add(BorderLayout.SOUTH, keyboard);
		
		controller.addChatPanelCommands(this);
	}
	
	@Override
	public void show() {
		setTitle(controller.getChatGroup().getChatName());
		
		for (ChatMessage chatMessage : controller.getChatGroup().getChatMessages()) {
			messageForm.add(new ChatBubble(chatMessage));
		}
		
		super.show();
	}
	
	
}
