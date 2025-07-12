//package pet.hungman.service.test_util_method;
//
//import org.apache.catalina.User;
//import pet.hungman.entity.GameSession;
//import pet.hungman.entity.UserEntity;
//
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//import java.util.UUID;
//
//public class HungmanGameTestUtil {
//    public static UserEntity getUserTest (GameSession gameSession){
//        UserEntity user = new UserEntity();
//
//        user.setId(1L);
//        user.setPassword("ttt");
//        user.setLogin("ttt");
//        user.setGameSession(gameSession);
//        return  user;
//    }
//    public static  GameSession getGameSession() {
//
//        List<Character> wordList = new ArrayList<>();
//        wordList.add('*');
//        wordList.add('*');
//        wordList.add('*');
//        wordList.add('*');
//        wordList.add('*');
//        List<String> mistakesList = new ArrayList<>();
//        mistakesList.add("a");
//
//        GameSession gameSession = new GameSession();
//        gameSession.setKeyId(UUID.fromString("16693fc8-973a-4e21-a05d-2b2438cfea12"));
//        gameSession.setMistakes(1);
//        gameSession.setWord("Игрок");
//        gameSession.setMask(wordList);
//        gameSession.setSuggestedByUser(mistakesList);
//
//
//        return gameSession;
//    }
//}
