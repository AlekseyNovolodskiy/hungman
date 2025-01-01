package pet.hungman.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pet.hungman.entity.UserEntity;

import java.util.Optional;

public interface UserEntityRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByLoginAndPassword(String login, String password);

    Optional<UserEntity> findByLogin(String login);

}
