package pet.hungman.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "words7")
@NoArgsConstructor
public class Word7Entity {
    @Id
    @SequenceGenerator(name = "words7Sequence", sequenceName = "words7_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "words7Sequence")
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "word")
    private String word;

    public Word7Entity(String word) {
        this.word = word;
    }
}
