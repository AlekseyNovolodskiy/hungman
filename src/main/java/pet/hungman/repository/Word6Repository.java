package pet.hungman.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pet.hungman.entity.Word6Entity;

public interface Word6Repository extends JpaRepository<Word6Entity,Long> {
    @Query(value = "SELECT * FROM public.words6 ORDER BY random() LIMIT 1",nativeQuery = true)
    Word6Entity findTheWord();
}
