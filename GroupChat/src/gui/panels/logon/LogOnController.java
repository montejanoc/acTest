package gui.panels.logon;

import client.MobileController;

public class LogOnController {

	private MobileController mobileController;

	private boolean initialized;
	private LogOnPanel logOnPanel;

	public LogOnController(MobileController mobileController) {
		this.mobileController = mobileController;

		logOnPanel = new LogOnPanel(this);

		initialized = false;
	}

	public void showLogOnPanel() {
		if (!initialized) {
			initialized = true;
			logOnPanel.show();
		}
		else {
			logOnPanel.clean();
			logOnPanel.showBack();
		}
	}

	public void logOn(String userName, String passWord) {
		mobileController.logOn(userName, passWord);
	}
}
