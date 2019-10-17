package messenger.domain;

import lombok.Value;

@Value
public class UserView {

    private final long id;

    public static UserView of(User user) {
        return new UserView(user.getId());
    }
}
