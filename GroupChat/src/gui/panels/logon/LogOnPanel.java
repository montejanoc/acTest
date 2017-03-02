package gui.panels.logon;

import com.codename1.ui.Button;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.BoxLayout;

public class LogOnPanel extends Form{

	private LogOnController logOnController;
		
	private TextField tfUserName;
	private TextField tfPassWord;
	
	private Button btnLogOn;
	
	
	public LogOnPanel(LogOnController logOnController) {
		this.logOnController = logOnController;
		
		this.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
		
		tfUserName = new TextField(15);
		tfPassWord = new TextField(15);
		
		btnLogOn = new Button("LogOn");
		btnLogOn.addActionListener(e -> logOnController.logOn(tfUserName.getText(), tfPassWord.getText()));
		
		this.add(new Label("UserName"));
		this.add(tfUserName);
		this.add(new Label("Password"));
		this.add(tfPassWord);
		this.add(btnLogOn);
		
	}	
}
