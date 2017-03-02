package gui.panels.chat;

import objects.ChatGroup;

public class ChatPanelController {

	private ChatGroup chatGroup;
	private ChatPanel chatPanel;
	
	public ChatPanelController(ChatGroup chatGroup) {
		this.chatGroup = chatGroup;

		chatPanel = new ChatPanel(this);
	}
	
	public ChatGroup getChatGroup() {return chatGroup;}
	public ChatPanel getChatPanel() {return chatPanel;}
	
	public void showChat() {chatPanel.show();}
}
