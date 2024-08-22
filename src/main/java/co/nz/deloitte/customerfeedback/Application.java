package nz.co.bnz.lapworkshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        try {
            final var app = new SpringApplication(Application.class);
            app.run(args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}