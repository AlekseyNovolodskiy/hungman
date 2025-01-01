package pet.hungman.controllers.dto;

import lombok.Data;
import java.util.List;


@Data
public class GameSessionDTO {

    private String keyId;

    private String word;

    private List<Character> mask;

    private List<String> suggestedByUser;
}
