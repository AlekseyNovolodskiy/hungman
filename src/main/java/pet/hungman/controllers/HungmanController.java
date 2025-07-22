package pet.hungman.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pet.hungman.service.AuthService;
import pet.hungman.service.HungmanGame;
import pet.hungman.service.HungmanStartGame;


import static pet.hungman.controllers.PathConstant.*;

@Controller
@RequiredArgsConstructor
@Slf4j
public class HungmanController {

    private final HungmanStartGame hungmanStartGame;
    private final HungmanGame hungmanGame;
    private final AuthService authService;

    private static final Logger userLogger  = LoggerFactory.getLogger("USER_LOGGER");

    @GetMapping("/")
    public String index() {
        return "index.html";
    }

    @GetMapping(AUTH)
    public String authorization(@RequestParam String login, Model model) {
        String result = authService.authTheUser(login, model);
        userLogger.info("user starts the game with login "+login);
        if ("start".equals(result)) {
            model.addAttribute("username", login);
        }
        return result;
    }

    @GetMapping(NEW_GAME)
    public String hungMan(@RequestParam Integer complexity, @RequestParam String username, Model model) {
        return hungmanStartGame.bodyChaineMethod(complexity, username, model);
    }

    @GetMapping(GAME)
    public String hungManTheGame(@RequestParam String symbol, @RequestParam String key, Model model) {
        return hungmanGame.hungmanStartTheGame(symbol, key, model);
    }

    @GetMapping(START)
    public String startNewGame(@RequestParam String username, Model model) {
        model.addAttribute("username", username);
        return "start";
    }
}
