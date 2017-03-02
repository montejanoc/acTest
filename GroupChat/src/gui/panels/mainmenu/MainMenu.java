package gui.panels.mainmenu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java18.Pair;
import objects.ChatGroup;
import objects.Profile;
import gui.panels.chat.*;

import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Form;
import com.codename1.ui.MenuBar;
import com.codename1.ui.SideMenuBar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Border;



public class MainMenu extends Form {

	private MainMenuController controller;

	private Form buttonPanel;

	public MainMenu(MainMenuController controller) {
		this.controller = controller;
		
		controller.applyMainMenuCommands(this);
		
		buttonPanel = new Form();
		
		setTitle("Main Menu");

	}

	public void show(List<Pair<Long, String>> chatIdsAndNames) {
		buttonPanel.removeAll();
		buttonPanel.setLayout(new BoxLayout(BoxLayout.Y_AXIS));

		for (Pair<Long, String> chatIdAndName : controller.getChatIdAndNameList()) {
			buttonPanel.add(convertChatToButton(chatIdAndName));
		}

		initLayout();

		show();
	}

	private Button convertChatToButton(Pair<Long, String> chatIdAndName) {
		Button toReturn = new Button(chatIdAndName.getValue1());

		//TODO Create action event to show Convo
		toReturn.addActionListener(e -> {
			new ChatPanelController(controller.getChatGroupForId(chatIdAndName.getValue0())).showChat();
		});

		return toReturn;
	}

	private void initLayout() {
		setLayout(new BorderLayout());
		add(BorderLayout.CENTER, buttonPanel);
	}
}