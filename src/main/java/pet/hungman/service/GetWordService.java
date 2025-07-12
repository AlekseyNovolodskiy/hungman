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

    public void loadWordsFromFile() throws IOException {
        String filePath = "src/main/java/pet/hungman/files/5lit.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {

                    Word5Entity wordEntity = new Word5Entity();
                    wordEntity.setWord(line);
                    word5Repository.save(wordEntity);

            }
        }
        String filePath2 = "src/main/java/pet/hungman/files/6lit.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath2))) {
            String line;
            while ((line = reader.readLine()) != null) {

                Word6Entity wordEntity = new Word6Entity();
                wordEntity.setWord(line);
                word6Repository.save(wordEntity);

            }
        }

        String filePath3 = "src/main/java/pet/hungman/files/7lit.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath3))) {
            String line;
            while ((line = reader.readLine()) != null) {

                Word7Entity wordEntity = new Word7Entity();
                wordEntity.setWord(line);
                word7Repository.save(wordEntity);

            }
        }

        String filePath4 = "src/main/java/pet/hungman/files/8lit.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath4))) {
            String line;
            while ((line = reader.readLine()) != null) {

                Word8Entity wordEntity = new Word8Entity();
                wordEntity.setWord(line);
                word8Repository.save(wordEntity);

            }
        }
    }
}
