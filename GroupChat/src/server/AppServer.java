package server;

import java.util.List;

import java18.Pair;
import objects.ChatGroup;
import objects.Profile;
import objects.exceptions.LogOnException;

public interface AppServer {
	
	public Profile logOn(String userName, String passWord) throws LogOnException;
	
	public List<Pair<Long, String>> getChatGroupsForUser(long userId);
	
	public ChatGroup getChatGroup(long chatGroupId);
	
}
