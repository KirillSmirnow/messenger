package messenger.repository;

import messenger.domain.Chat;
import messenger.domain.User;

import java.util.List;

public interface ChatRepository extends BaseJpaRepository<Chat> {

    List<Chat> findAllByMembersOrderById(User member);
}
