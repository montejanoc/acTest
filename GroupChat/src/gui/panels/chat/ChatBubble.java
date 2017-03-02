package gui.panels.chat;

import objects.ChatMessage;

import com.codename1.ui.Form;
import com.codename1.ui.TextArea;
import com.codename1.ui.layouts.BorderLayout;

public class ChatBubble extends Form {
	
	private ChatMessage chatMessage;
	
	private TextArea taMessage;
	
	public ChatBubble(ChatMessage message) {
		this.chatMessage = message;
		
		taMessage = new TextArea(chatMessage.getMessage());
		taMessage.setEditable(false);
		
		setLayout(new BorderLayout());
		
		this.add(BorderLayout.CENTER, taMessage);
	}

}
