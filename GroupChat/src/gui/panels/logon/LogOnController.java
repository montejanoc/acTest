package gui.panels.logon;

import client.MobileController;

public class LogOnController {

	private MobileController mobileController;
	
	private LogOnPanel logOnPanel;
	
	public LogOnController(MobileController mobileController) {
		this.mobileController = mobileController;
		
		logOnPanel = new LogOnPanel(this);
	}
	
	public void showLogOnPanel() {
		this.logOnPanel.show();
	}
	
	public void logOn(String userName, String passWord) {
		mobileController.logOn(userName, passWord);
	}
}
