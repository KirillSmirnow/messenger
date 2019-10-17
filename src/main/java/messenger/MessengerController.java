package messenger;

import lombok.RequiredArgsConstructor;
import messenger.domain.*;
import messenger.repository.ChatRepository;
import messenger.repository.MessageRepository;
import messenger.repository.UserRepository;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
@RequiredArgsConstructor
public class MessengerController {

    private final SimpMessagingTemplate messagingTemplate;

    private final ChatRepository chatRepository;
    private final MessageRepository messageRepository;
    private final UserRepository userRepository;

    @GetMapping("/users")
    public List<UserView> getAllUsers() {
        return userRepository.findAll().stream()
                .map(UserView::of)
                .collect(toList());
    }

    @GetMapping("/users/{userId}/chats")
    public List<ChatView> getUserChats(@PathVariable long userId) {
        User user = userRepository.getOne(userId);
        return chatRepository.findAllByMembersOrderById(user).stream()
                .map(ChatView::of)
                .collect(toList());
    }

    @GetMapping("/chats/{chatId}/messages")
    public List<MessageView> getChatMessages(@PathVariable long chatId) {
        Chat chat = chatRepository.getOne(chatId);
        return messageRepository.findAllByChatOrderById(chat).stream()
                .map(MessageView::of)
                .collect(toList());
    }

    @PostMapping("/chats/{chatId}/messages")
    public void sendMessage(@PathVariable long chatId, @RequestParam long authorId, @RequestParam String text) {
        Chat chat = chatRepository.getOne(chatId);
        User author = userRepository.getOne(authorId);
        MessageView message = MessageView.of(messageRepository.save(new Message(chat, author, text)));

        messagingTemplate.convertAndSend("/chats/" + chat.getAccessToken(), message);
    }
}
