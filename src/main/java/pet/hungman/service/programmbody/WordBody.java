package pet.hungman.service.programmbody;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class WordBody {

    public List<Character> fillTheWord( int comp) {
        List<Character> list = new ArrayList<>(comp);
        for (int i = 0; i < comp; i++) {
            list.add('*');
        }
        return list;
    }

    public List<Character> masked(String symbol, String string, List<Character> mask) {
        List<Character> updatedMask = new ArrayList<>();
        for (int i = 0; i < string.length(); i++) {
            if (symbol.toLowerCase().charAt(0) == string.toLowerCase().charAt(i)) {
                updatedMask.add(symbol.toLowerCase().charAt(0));
            } else {
                updatedMask.add(mask.get(i));
            }
        }
        return updatedMask;
    }

    public int countOfletters(List<Character> word){
        int count =0;
        for (char letter : word){
            if(letter!='*'){
                count++;
            }
        }
        return count;
    }

    public boolean testToWin(List list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals('*'))
                return false;
        }
        return true;
    }

}

