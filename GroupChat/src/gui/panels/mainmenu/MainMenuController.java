package gui.panels.mainmenu;

import gui.panels.profileeditor.ProfileEditorPanel;

import java.util.ArrayList;
import java.util.List;

import com.codename1.ui.Command;
import com.codename1.ui.Form;
import com.codename1.ui.events.ActionEvent;

import client.MobileController;
import java18.Pair;
import objects.ChatGroup;
import objects.Profile;

public class MainMenuController {

	private MobileController mobileController;
	private MainMenu mainMenu;
	private Profile loggedOn;

	private List<Pair<Long, String>> chatIdAndNameList;

	public MainMenuController(MobileController mobileController) {
		this.mobileController = mobileController;
		this.chatIdAndNameList = new ArrayList<>();
		this.mainMenu = new MainMenu(this);
	}


	public void showMainMenu(List<Pair<Long, String>> chatsToShow) {
		this.loggedOn = mobileController.getCurrentUser();
		this.chatIdAndNameList = chatsToShow;

		mainMenu.show(chatsToShow);
	}

	public List<Pair<Long, String>> getChatIdAndNameList() {return chatIdAndNameList;}

	public ChatGroup getChatGroupForId(long chatId) {return mobileController.getChatGroup(chatId);}

	public void applyMainMenuCommands(Form mainMenu) {

		Command settings = new Command("Setting") {
			public void actionPerformed(ActionEvent ev) {
				System.out.println("CLicked Settings");
			}
		};
		Command editProfile = new Command("Edit Profile") {
			public void actionPerformed(ActionEvent ev) {
				new ProfileEditorPanel(mobileController.getCurrentUser());
			}		
		};
		Command back = new Command("Back") {
			public void actionPerformed(ActionEvent ev) {
				System.out.println("Back");
			}	
		};

		mainMenu.addCommand(settings);
		mainMenu.addCommand(editProfile);
		mainMenu.setBackCommand(back);

	}

}
