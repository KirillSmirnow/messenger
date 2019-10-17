package messenger.domain;

import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "users")
@ToString(callSuper = true)
public class User extends JpaEntity {
}
