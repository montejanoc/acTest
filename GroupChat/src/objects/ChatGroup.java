package objects;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class ChatGroup {

	private List<Long> profileIdsInThisGroup;
	private String chatName;
	private long chatId;
	
	private List<ChatMessage> chatMessages;

		
	public ChatGroup() {
		chatId = new Random().nextLong();
		this.profileIdsInThisGroup = new ArrayList<>();
		chatMessages = new ArrayList<>();
	}
	
	public String getChatName() {return chatName;}
	public void setChatName(String chatName) {this.chatName = chatName;}
	
	public List<Long> getProfileIdsInChat() {return profileIdsInThisGroup;}
	public void setProfileIdsInThisGroup(List<Long> profileIdsInThisGroup) {this.profileIdsInThisGroup = profileIdsInThisGroup;}
	
	public void addProfileToChat(Profile toAdd) {this.profileIdsInThisGroup.add(toAdd.getProfileId());}
	public void addProfileToChat(long toAdd) {this.profileIdsInThisGroup.add(toAdd);}

	public void removeProfileFromChat(Profile toRemove) {this.profileIdsInThisGroup.remove(toRemove.getProfileId());}
	public void removeProfileFromChat(long toRemove) {this.profileIdsInThisGroup.remove(toRemove);}
	
	public List<ChatMessage> getChatMessages() {return chatMessages;}
	public void setChatMessages(List<ChatMessage> chatMessages) {this.chatMessages = chatMessages;}
	public void addMessage(ChatMessage toAdd) {this.chatMessages.add(toAdd);}
	//TODO Want to be able to remove ???
	
	public long getChatId() {return chatId;}
}
