package gui.panels.profileeditor;

import objects.Profile;

import com.codename1.ui.Command;
import com.codename1.ui.Form;
import com.codename1.ui.events.ActionEvent;

import client.MobileController;

public class ProfileEditorController {

	private MobileController mobileController;
	private Profile profileEditing;
	
	public ProfileEditorController(MobileController mobileController) {
		this.mobileController = mobileController;
	}
	
	public void showEditor(Profile toEdit) {
		this.profileEditing = toEdit;
		new ProfileEditorPanel(this).show();
	}
	
	public Profile getProfileEditing() {
		return profileEditing;
	}
	
	public void addProfileEditorCommands(Form addTo) {
		addTo.addCommand(new Command("Back") {
			@Override
			public void actionPerformed(ActionEvent evt) {
				mobileController.getMainMenuController().showMenu();
			}
		});
	}
}
