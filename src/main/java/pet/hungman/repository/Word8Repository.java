package pet.hungman.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pet.hungman.entity.Word8Entity;

public interface Word8Repository extends JpaRepository<Word8Entity, Long> {
    @Query(value = "SELECT * FROM public.words8 ORDER BY random() LIMIT 1", nativeQuery = true)
    Word8Entity findTheWord();
}
