package pet.hungman.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;
import pet.hungman.repository.convereter.CharacterListConverter;
import pet.hungman.repository.convereter.StringListConverter;

import java.util.List;
import java.util.UUID;

@Data
@Entity
public class GameSession {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID keyId; // keyId = ID

    @Column(name = "word")
    private String word;

    @Column(name="mistakes")
    private Integer mistakes;

    @Column(name = "mask")
    @Convert(converter = CharacterListConverter.class)
    private List<Character> mask;

    @Column(name = "suggested_by_user")
    @Convert(converter = StringListConverter.class)
    private List<String> suggestedByUser;

    @OneToOne(mappedBy = "gameSession")
    @ToString.Exclude
    private UserEntity userEntity;
}
