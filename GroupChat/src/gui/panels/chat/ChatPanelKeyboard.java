package gui.panels.chat;

import com.codename1.ui.Button;
import com.codename1.ui.Form;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.GridBagConstraints;
import com.codename1.ui.layouts.GridBagLayout;

public class ChatPanelKeyboard extends Form{

	private TextField tfMessage;
	private Button btnSend;
	
	public ChatPanelKeyboard() {
	
		tfMessage = new TextField("Type Here");
		btnSend = new Button("Send");
		btnSend.addActionListener(e -> send());
		
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		c.gridx = 0; c.gridwidth = 1; c.weightx = .5; c.ipadx = 0;
		c.gridy = 0; c.gridheight = 1; c.weighty = .5; c.ipady = 0;
		add(c, tfMessage);
		
		c.gridx = 1; c.gridwidth = 1; c.weightx = .5; c.ipadx = 0;
		c.gridy = 0; c.gridheight = 1; c.weighty = .5; c.ipady = 0;
		add(c, btnSend);
	}
	
	private void send() {
		System.out.println("Should send \"" + tfMessage.getText() + "\"");
	}
}
