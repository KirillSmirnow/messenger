package messenger.repository;

import messenger.domain.JpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BaseJpaRepository<T extends JpaEntity> extends JpaRepository<T, Long> {
}
