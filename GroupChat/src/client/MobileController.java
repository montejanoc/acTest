package client;

import java.util.List;

import java18.Pair;

import com.codename1.ui.Dialog;

import objects.ChatGroup;
import objects.Profile;
import objects.exceptions.LogOnException;
import server.AppServer;
import gui.panels.chat.ChatPanelController;
import gui.panels.logon.LogOnController;
import gui.panels.mainmenu.MainMenuController;
import gui.panels.profileeditor.ProfileEditorController;


public class MobileController {

	private AppServer appServer;
	
	private Profile currentUser;
	
	private LogOnController logOnController;
	private MainMenuController mainMenuController;
	private ChatPanelController chatPanelController;
	private ProfileEditorController editorController;
	
	public MobileController(AppServer appServer) {
		this.appServer = appServer;
		
		this.logOnController = new LogOnController(this);
		
		this.mainMenuController = new MainMenuController(this);
		
		this.chatPanelController = new ChatPanelController(this);
		
		this.editorController = new ProfileEditorController(this);
		
	}
	
	public ChatPanelController getChatPanelController() {return chatPanelController;}
	public LogOnController getLogOnController() {return logOnController;}
	public MainMenuController getMainMenuController() {return mainMenuController;}
	
	public void logOn(String userName, String passWord) {
		try {
			currentUser = appServer.logOn(userName, passWord);
			mainMenuController.showMenu(); 
			
		} catch (LogOnException e) {
			Dialog.show("LogOn Exception", e.getMessage(), "Ok", null);
		}
	}
	
	public void logOut() {
		this.currentUser = null;
		logOnController.showLogOnPanel();
	}
	
	
	public ChatGroup getChatGroup(long chatId) {
		return appServer.getChatGroup(chatId);
	}
	
	public List<Pair<Long, String>> getChatIdsAndNamesForLoggedOnProfile() {
		return appServer.getChatGroupsForUser(currentUser.getProfileId());
	}
	
	
	public Profile getCurrentUser() {return currentUser;}
	public void editCurrentProfile() {
		editorController.showEditor(currentUser);
	}
	
	
	public void startGui() {
		logOnController.showLogOnPanel();
	}
}
