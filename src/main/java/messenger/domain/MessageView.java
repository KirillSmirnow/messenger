package messenger.domain;

import lombok.Value;

import java.time.LocalDateTime;

@Value
public class MessageView {

    private final long id;
    private final LocalDateTime creation;
    private final UserView author;
    private final String text;

    public static MessageView of(Message message) {
        return new MessageView(message.getId(), message.getCreation(),
                UserView.of(message.getAuthor()), message.getText());
    }
}
