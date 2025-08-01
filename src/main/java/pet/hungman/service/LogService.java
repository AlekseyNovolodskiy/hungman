package pet.hungman.service;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Service
public class LogService {


    public List<String> getUserLogs() throws IOException {
        String filePath = "logs/user.log";

        return readFileToList(filePath);

    }

    public List<String> getAppLogs() throws IOException {
        String filePath = "logs/application.log";


        return readFileToList(filePath);
    }


    private List<String> readFileToList(String filePath) throws IOException {
        List<String> stringList = new LinkedList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                stringList.add(line);
            }
        }

        return stringList;
    }
}
