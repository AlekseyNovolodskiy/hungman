package pet.hungman.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pet.hungman.entity.Word5Entity;
import pet.hungman.entity.Word6Entity;
import pet.hungman.entity.Word7Entity;
import pet.hungman.entity.Word8Entity;
import pet.hungman.repository.Word5Repository;
import pet.hungman.repository.Word6Repository;
import pet.hungman.repository.Word7Repository;
import pet.hungman.repository.Word8Repository;

import java.io.*;

@Service
@RequiredArgsConstructor
public class GetWordService {

    private final Word5Repository word5Repository;
    private final Word6Repository word6Repository;
    private final Word7Repository word7Repository;
    private final Word8Repository word8Repository;

    public String getWordMethod(Integer compl) {
        String theWord = null;
        if (compl == 8) {
            theWord = word8Repository.findTheWord().getWord();
        } else if (compl == 7) {
            theWord = word7Repository.findTheWord().getWord();
        } else if (compl == 6) {
            theWord = word6Repository.findTheWord().getWord();
        } else if (compl == 5) {
            theWord = word5Repository.findTheWord().getWord();
        }

        return theWord;
    }

}
