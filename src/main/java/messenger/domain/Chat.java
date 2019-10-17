package messenger.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "chats")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
public class Chat extends JpaEntity {

    @ManyToMany
    private List<User> members;

    @NotNull
    @NotBlank
    private String accessToken;
}
