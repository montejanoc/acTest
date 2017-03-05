package gui.panels.chat;

import objects.ChatMessage;

import com.codename1.ui.Form;
import com.codename1.ui.TextArea;
import com.codename1.ui.layouts.BorderLayout;

public class ChatBubble extends TextArea {
	
	private ChatMessage chatMessage;
	
	
	public ChatBubble(ChatMessage message) {
		this.chatMessage = message;
		
		setText(message.getMessage());
		setEditable(false);
		
	}
}
