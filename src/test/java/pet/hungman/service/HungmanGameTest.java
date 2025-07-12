//package pet.hungman.service;
//
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.ui.Model;
//import pet.hungman.entity.GameSession;
//import pet.hungman.entity.UserEntity;
//import pet.hungman.repository.GameSessionRepository;
//import pet.hungman.service.programmbody.WordBody;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.UUID;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.ArgumentMatchers.*;
//import static org.mockito.Mockito.*;
//import static pet.hungman.service.test_util_method.HungmanGameTestUtil.getGameSession;
//import static pet.hungman.service.test_util_method.HungmanGameTestUtil.getUserTest;
//
//@ExtendWith(MockitoExtension.class)
//class HungmanGameTest {
//
//    @Mock
//    private GameSessionRepository gameSessionRepository;
//
//    @Mock
//    private WordBody wordBody;
//
//    @Mock
//    private Model model;
//
//    @InjectMocks
//    private HungmanGame hungmanGame;
//
//    @Test
//    public void testWinScenario() {
//
//        String uuidKey = "16693fc8-973a-4e21-a05d-2b2438cfea12";
//
//        GameSession gameSession = getGameSession();
//        UserEntity testUser = getUserTest(gameSession);
//
//        when(gameSessionRepository.getReferenceById(UUID.fromString(uuidKey))).thenReturn(gameSession);
//        when(wordBody.masked(anyString(), anyString(), anyList())).thenReturn(List.of('И', 'г', 'р', 'о', 'к'));
//        when(wordBody.testToWin(anyList())).thenReturn(true);
//
//        // 3. Вызов метода
//        String result = hungmanGame.hungmanStartTheGame("a", uuidKey, model);
//
//        // 4. Проверки
//        assertEquals("win", result);
//        verify(model).addAttribute("username", "testUser");
//        verify(gameSessionRepository, times(2)).save(gameSession);
//    }
//}