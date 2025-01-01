package pet.hungman.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@Table(name = "words8")
@NoArgsConstructor
public class Word8Entity {
    @Id
    @SequenceGenerator(name = "words8Sequence", sequenceName = "words8_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "words8Sequence")
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "word")
    private String word;

    public Word8Entity(String word) {
        this.word = word;
    }
}
