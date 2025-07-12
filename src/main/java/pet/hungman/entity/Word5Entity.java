package pet.hungman.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "words5")
@NoArgsConstructor
public class Word5Entity {
    @Id
    @SequenceGenerator(name = "words5Sequence", sequenceName = "words5_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "words5Sequence")
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "word")
    private String word;

    public Word5Entity(String word) {
        this.word = word;
    }
}
