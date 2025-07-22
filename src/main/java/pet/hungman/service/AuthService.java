package pet.hungman.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import pet.hungman.entity.UserEntity;
import pet.hungman.repository.UserEntityRepository;

import java.util.Optional;

@AllArgsConstructor
@Service
public class AuthService {
    private final UserEntityRepository userEntityRepository;

    public String authTheUser(String login, Model model) {
        Optional<UserEntity> byLogin = userEntityRepository.findByLogin(login);
        if (byLogin.isEmpty()) {
            UserEntity userEntity = new UserEntity();
            userEntity.setLogin(login);
            userEntity.setGameSession(null);
            userEntityRepository.save(userEntity);
            return "start";
        }

        UserEntity userEntity = byLogin.get();

        if (userEntity.getGameSession() != null) {
            model.addAttribute("sessionKey", userEntity.getGameSession().getKeyId());
            model.addAttribute("maskedWord", userEntity.getGameSession().getMask());
            model.addAttribute("username", userEntity.getLogin());
            return "game";
        }

        return "start";
    }
}
