package pet.hungman.repository.convereter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Converter
public class CharacterListConverter implements AttributeConverter<List<Character>, String> {

    @Override
    public String convertToDatabaseColumn(List<Character> list) {
        if (list == null)
            return "";
        StringBuilder listString = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
                listString.append(list.get(i));

        }
        return listString.toString();
    }

    @Override
    public List<Character> convertToEntityAttribute(String string) {
        if(!StringUtils.hasText(string))
            return new ArrayList<>();
        List<Character> list = new ArrayList<>();
        for (int x : string.toCharArray()) {
            list.add((char) x);
        }
        return list;
    }
}