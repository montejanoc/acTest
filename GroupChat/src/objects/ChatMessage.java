package objects;

import java.util.Date;

public class ChatMessage {

	private long senderProfileId;
	private long chatId;
	private String message;
	private Date timeSent;
	
	public ChatMessage(long senderProfileId, long chatId, String message) {
		this.senderProfileId = senderProfileId;
		this.chatId = chatId;
		this.message = message;
		timeSent = new Date();
	}
	
	public long getSenderProfileId() {return senderProfileId;}
	public long getChatId() {return chatId;}
	public String getMessage() {return message;}
	public Date getTimeSent() {return timeSent;}
	
}
