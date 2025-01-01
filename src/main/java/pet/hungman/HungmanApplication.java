package pet.hungman;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import pet.hungman.service.programmbody.WordBody;

@SpringBootApplication
public class HungmanApplication {

    public static void main(String[] args) {
        SpringApplication.run(HungmanApplication.class, args);


    }


}
