package objects;

import java.util.Random;

public class Profile {

	private String userName;
	private String humanName;
	
	private String profileBio;
	
	private String passWord;
	private long profileId;
	
	public Profile() {
		profileId = new Random().nextLong();
	}
	public Profile(String userName, String humanName, String bio, String passWord) {
		this.userName = userName;
		this.humanName = humanName;
		this.profileBio = bio;
		this.passWord = passWord;
	}
	
	
	public void setUserName(String userName) {this.userName = userName;}
	public String getUserName() {return userName;}
	
	public void setHumanName(String humanName) {this.humanName = humanName;}
	public String getHumanName() {return humanName;}
	
	public void setProfileBio(String profileBio) {this.profileBio = profileBio;}
	public String getProfileBio() {return profileBio;}
	
	public void setPassWord(String passWord) {this.passWord = passWord;}
	public String getPassWord() {return passWord;}
	
	public long getProfileId() {return profileId;}
}
