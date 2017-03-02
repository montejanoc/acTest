package gui.panels.profileeditor;

import com.codename1.ui.Button;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.BorderLayout;

import objects.Profile;

public class ProfileEditorPanel extends Form {

	private Profile profileToEdit;
	private Button btnUpdate;
	private Form centerForm;
	private TextField username;
	private TextField password;
	private TextField bio;
	private TextField realname;

	public ProfileEditorPanel(Profile profileToEdit) {
		username = new TextField(profileToEdit.getUserName());
		password = new TextField(profileToEdit.getPassWord());
		bio = new TextField(profileToEdit.getProfileBio());
		realname = new TextField(profileToEdit.getHumanName());

		this.profileToEdit = profileToEdit;

		setLayout(new BorderLayout());

		centerForm = new Form();
		this.add(BorderLayout.CENTER, centerForm);
		centerForm.add(new Label("Username"));
		centerForm.add(username);
		centerForm.add(new Label("Password"));
		centerForm.add(password);
		centerForm.add(new Label("Bio"));
		centerForm.add(bio);
		centerForm.add(new Label("RealName"));
		centerForm.add(realname);
		
		initBtnUpdate();
		this.add(BorderLayout.SOUTH, btnUpdate);

		show();
	}
	
	public void initBtnUpdate(){
		btnUpdate = new Button("Update Profile");
		btnUpdate.addActionListener(e -> {
			profileToEdit.setHumanName(realname.getText());
			profileToEdit.setPassWord(password.getText());
			profileToEdit.setProfileBio(bio.getText());
			profileToEdit.setUserName(username.getText()); 
		});
	}
}