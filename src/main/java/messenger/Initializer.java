package messenger;

import lombok.RequiredArgsConstructor;
import messenger.domain.Chat;
import messenger.domain.Message;
import messenger.domain.User;
import messenger.repository.ChatRepository;
import messenger.repository.MessageRepository;
import messenger.repository.UserRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.UUID;

import static java.util.Arrays.asList;

@Component
@RequiredArgsConstructor
public class Initializer implements ApplicationRunner {

    private final ChatRepository chatRepository;
    private final MessageRepository messageRepository;
    private final UserRepository userRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        User u1 = userRepository.save(new User());
        User u2 = userRepository.save(new User());
        User u3 = userRepository.save(new User());

        Chat c1 = chatRepository.save(new Chat(asList(u1, u2, u3), UUID.randomUUID().toString()));
        Chat c2 = chatRepository.save(new Chat(asList(u2, u3), UUID.randomUUID().toString()));

        Message m1 = messageRepository.save(new Message(c1, u1, "Hi!"));
    }
}
