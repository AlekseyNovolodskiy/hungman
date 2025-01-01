package pet.hungman.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pet.hungman.entity.GameSession;
import java.util.UUID;

public interface GameSessionRepository extends JpaRepository<GameSession, UUID> {


}
