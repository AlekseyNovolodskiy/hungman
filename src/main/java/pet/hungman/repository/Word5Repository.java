package pet.hungman.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pet.hungman.entity.Word5Entity;

public interface Word5Repository extends JpaRepository<Word5Entity,Long> {

    @Query(value = "SELECT * FROM public.words5 ORDER BY random() LIMIT 1",nativeQuery = true)
    Word5Entity findTheWord();
}
