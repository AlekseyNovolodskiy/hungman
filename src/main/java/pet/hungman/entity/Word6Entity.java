package pet.hungman.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "words6")
@NoArgsConstructor
public class Word6Entity {
    @Id
    @SequenceGenerator(name = "words6Sequence", sequenceName = "words6_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "words6Sequence")
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "word")
    private String word;

    public Word6Entity(String word) {
        this.word = word;
    }
}
