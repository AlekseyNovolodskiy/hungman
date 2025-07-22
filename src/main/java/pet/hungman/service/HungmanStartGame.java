package pet.hungman.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import pet.hungman.entity.GameSession;
import pet.hungman.entity.UserEntity;
import pet.hungman.repository.GameSessionRepository;
import pet.hungman.repository.UserEntityRepository;
import pet.hungman.service.programmbody.WordBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class HungmanStartGame {
    private final WordBody wordBody;
    private final GameSessionRepository gameSessionRepository;
    private final UserEntityRepository userEntityRepository;
    private final GetWordService getWordService;

    public String bodyChaineMethod(int complexity, String username, Model model) {
        String word = getWordService.getWordMethod(complexity);
        List<Character> list = wordBody.fillTheWord(complexity);

        List<String> suggestByUser = new ArrayList<>();
        GameSession gameSession = new GameSession();
        gameSession.setSuggestedByUser(suggestByUser);
        gameSession.setWord(word);
        gameSession.setMask(list);

        UserEntity userEntity = userEntityRepository.findByLogin(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        gameSession.setUserEntity(userEntity);
        userEntity.setGameSession(gameSession);

        GameSession saved = gameSessionRepository.save(gameSession);
        userEntityRepository.save(userEntity);

        model.addAttribute("sessionKey", saved.getKeyId().toString());
        model.addAttribute("maskedWord", list);
        model.addAttribute("mistakes", 0);
        model.addAttribute("username", username);
        return "game";
    }

}
