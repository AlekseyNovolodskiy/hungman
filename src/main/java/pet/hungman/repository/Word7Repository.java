package pet.hungman.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pet.hungman.entity.Word7Entity;

public interface Word7Repository extends JpaRepository<Word7Entity,Long> {
    @Query(value = "SELECT * FROM public.words7 ORDER BY random() LIMIT 1",nativeQuery = true)
    Word7Entity findTheWord();
}
