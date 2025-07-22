package pet.hungman.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import pet.hungman.entity.GameSession;
import pet.hungman.repository.GameSessionRepository;
import pet.hungman.service.programmbody.HungPicture;
import pet.hungman.service.programmbody.WordBody;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class HungmanGame {
    private final GameSessionRepository gameSessionRepository;
    private final WordBody wordBody;
    private final HungPicture hungPicture;

    public String hungmanStartTheGame(String symbol, String key, Model model) {
        GameSession gameSession = gameSessionRepository.getReferenceById(UUID.fromString(key));
        gameSession.getSuggestedByUser().add(symbol);
        String word = gameSession.getWord();
        List<Character> mask = gameSession.getMask();
        List<Character> masked = wordBody.masked(symbol, word, mask);

        gameSession.setMask(masked);
        gameSessionRepository.save(gameSession);

        if (wordBody.testToWin(masked)) {
            model.addAttribute("username", gameSession.getUserEntity().getLogin());
            return "win";
        }

        if (gameSession.getMistakes() == null) {
            gameSession.setMistakes(0);
        }
        if (!masked.contains(symbol.toLowerCase().charAt(0))) {
            int mistakes = gameSession.getMistakes();
            gameSession.setMistakes(mistakes + 1);
            gameSessionRepository.save(gameSession);
        }
        if (gameSession.getMistakes() >= 5) {
            model.addAttribute("username", gameSession.getUserEntity().getLogin());
            return "loose";
        }

        String formattedPicture = hungPicture.risuemViselicu(gameSession.getMistakes())
                .replace("\n", "<br>")
                .replace(" ", "&nbsp;");
        model.addAttribute("formattedPicture", "<div style='font-family: monospace;'>" + formattedPicture + "</div>");
        model.addAttribute("sessionKey", key);
        model.addAttribute("maskedWord", masked);
        model.addAttribute("mistakes", gameSession.getMistakes());
        model.addAttribute("suggested", gameSession.getSuggestedByUser());

        if (gameSession.getUserEntity() != null) {
            model.addAttribute("username", gameSession.getUserEntity().getLogin());
        } else {
            model.addAttribute("username", "Unknown");
        }

        return "game";
    }
}
