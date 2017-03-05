package server;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import java18.Pair;
import objects.ChatGroup;
import objects.ChatMessage;
import objects.Profile;
import objects.exceptions.LogOnException;

public class FakeLocalServer implements AppServer {

	private List<Profile> profiles;
	private Map<Long, ChatGroup> chatGroupsByChatGroupId;

	public FakeLocalServer() {
		profiles = new ArrayList<>();
		chatGroupsByChatGroupId = new HashMap<>();

		initializeWithFakeInfo();
	}

	@Override
	public Profile logOn(String userName, String passWord)
			throws LogOnException {
		for (Profile p : profiles) {
			if (p.getUserName().equals(userName)) {
				if (p.getPassWord().equals(passWord)) {
					return p;
				} else {
					throw new LogOnException(
							"Incorrect Password for UserName \"" + userName
									+ "\". Please try again");
				}
			}
		}
		throw new LogOnException("Unknown UserName - \"" + userName
				+ "\". Please try again");
	}

	@Override
	public List<Pair<Long, String>> getChatGroupsForUser(long userId) {
		List<Pair<Long, String>> toReturn = new ArrayList<>();

		for (ChatGroup chatGroup : chatGroupsByChatGroupId.values()) {
			if (chatGroup.getProfileIdsInChat().contains(userId)) {
				toReturn.add(Pair.with(chatGroup.getChatId(),chatGroup.getChatName()));
			}
		}
		return toReturn;
	}

	@Override
	public ChatGroup getChatGroup(long chatGroupId) {
		return chatGroupsByChatGroupId.get(chatGroupId);
	}

	private void initializeWithFakeInfo() {
		Profile cole = new Profile("Cole", "Cole M", "Bio4Cole", "theCole");
		Profile alec = new Profile("Alec", "Alec J", "Bio4Alec", "theAlec");
		profiles.add(cole);
		profiles.add(alec);

		for (int i = 0; i < new Random().nextInt(4) + 1; i++) {
			addFakeChatGroupWithTheseUsers(profiles);
		}
	}

	private void addFakeChatGroupWithTheseUsers(List<Profile> possibleUsers) {
		if (possibleUsers.size() > 0) {
			ChatGroup fakeGroup = new ChatGroup();
			fakeGroup.setChatName("Fake For Testing - "
					+ new Random().nextDouble());

			List<Long> idsToAdd = new ArrayList<>();
			for (Profile p : possibleUsers) {
				idsToAdd.add(p.getProfileId());
			}
			fakeGroup.setProfileIdsInThisGroup(idsToAdd);

			int nMessage = new Random().nextInt(1) + 7;
			for (int i = 0; i < nMessage; i++) {
				fakeGroup.addMessage(new ChatMessage(possibleUsers.get(
						new Random().nextInt(possibleUsers.size()))
						.getProfileId(), fakeGroup.getChatId(),
						"FakeMessage - " + i));
			}

			chatGroupsByChatGroupId.put(fakeGroup.getChatId(), fakeGroup);
		}
	}
}
