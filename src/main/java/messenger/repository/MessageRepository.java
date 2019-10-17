package messenger.repository;

import messenger.domain.Chat;
import messenger.domain.Message;

import java.util.List;

public interface MessageRepository extends BaseJpaRepository<Message> {

    List<Message> findAllByChatOrderById(Chat chat);
}
