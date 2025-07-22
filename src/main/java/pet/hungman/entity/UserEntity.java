package pet.hungman.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Entity
@Data
@Table(name = "user_info")
@NoArgsConstructor
public class UserEntity {

    @Id
    @SequenceGenerator(name = "user_infoSequence", sequenceName = "user_info_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_infoSequence")
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "login")
    private String login;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "gamesession_id")
    @ToString.Exclude
    private GameSession gameSession;
}
