package messenger.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "messages")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
public class Message extends JpaEntity {

    @ManyToOne(optional = false)
    private Chat chat;

    @ManyToOne(optional = false)
    private User author;

    @NotNull
    @NotBlank
    private String text;
}
