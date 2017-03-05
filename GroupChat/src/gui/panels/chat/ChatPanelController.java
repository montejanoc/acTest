package gui.panels.chat;

import com.codename1.ui.Command;
import com.codename1.ui.Form;
import com.codename1.ui.events.ActionEvent;

import client.MobileController;
import objects.ChatGroup;

public class ChatPanelController {

	private MobileController mobileController;
	
	private ChatGroup chatGroup;
	private ChatPanel chatPanel;
	
	public ChatPanelController(MobileController mobileController) {

		this.mobileController = mobileController;
		
		chatPanel = new ChatPanel(this);
	}
	
	public ChatGroup getChatGroup() {return chatGroup;}
	public ChatPanel getChatPanel() {return chatPanel;}
	
	public void showChat(ChatGroup chatGroup) {
		this.chatGroup = chatGroup;
		chatPanel.show();
	}
	
	
	public void addChatPanelCommands(Form addTo) {
		addTo.addCommand(new Command("Back") {
			@Override
			public void actionPerformed(ActionEvent evt) {
				mobileController.getMainMenuController().showMenu();
			}
		});
	}
}
