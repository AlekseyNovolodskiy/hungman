package pet.hungman.repository.convereter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Converter
public class StringListConverter implements AttributeConverter<List<String>, String> {

    @Override
    public String convertToDatabaseColumn(List<String> list) {
        if(list==null)
            return  "";
        return String.join(",", list);

    }

    @Override
    public List<String> convertToEntityAttribute(String joined) {
        if(!StringUtils.hasText(joined))
            return new ArrayList<>();
        return new ArrayList<>(Arrays.asList(joined.split(",")));
    }

}