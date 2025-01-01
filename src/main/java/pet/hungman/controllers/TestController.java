package pet.hungman.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pet.hungman.controllers.dto.GameSessionDTO;
import pet.hungman.entity.GameSession;
import pet.hungman.repository.GameSessionRepository;

import java.util.UUID;

@RequiredArgsConstructor
@RestController
public class TestController {
    private final GameSessionRepository gameSessionRepository;
    @GetMapping("/testrepository")
    public GameSession testrepository (){
        GameSession gameSession = new GameSession();
        gameSession.setWord("asf");
        return gameSessionRepository.save(gameSession);
    }
    @GetMapping("/findbyid")
    public GameSessionDTO findByID(@RequestParam String key){
        GameSession referenceById = gameSessionRepository.getReferenceById(UUID.fromString(key));

        GameSessionDTO gameSessionDTO = new GameSessionDTO();
        gameSessionDTO.setKeyId(referenceById.getKeyId().toString());
        gameSessionDTO.setWord(referenceById.getWord());
        gameSessionDTO.setSuggestedByUser(referenceById.getSuggestedByUser());
        gameSessionDTO.setMask(referenceById.getMask());
        return gameSessionDTO;
    }




}
