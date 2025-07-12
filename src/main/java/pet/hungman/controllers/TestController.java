package pet.hungman.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pet.hungman.service.GetWordService;

import java.io.IOException;

@RequiredArgsConstructor
@RestController
public class TestController {
    private final GetWordService getWordSerice;
    @GetMapping("/intiate")
    public void  testrepository () throws IOException {
      getWordSerice.loadWordsFromFile();

    }





}
