package messenger.domain;

import lombok.Value;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Value
public class ChatView {

    private final long id;
    private final List<UserView> members;
    private final String accessToken;

    public static ChatView of(Chat chat) {
        List<UserView> members = chat.getMembers().stream().map(UserView::of).collect(toList());
        return new ChatView(chat.getId(), members, chat.getAccessToken());
    }
}
