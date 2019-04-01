package main.host;
import main.controller.NoteController;
import main.data.NoteContext;
import main.domain.NoteRepository;
import main.domain.NoteRepositoryConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by Alex on 3/29/19.
 */
@SpringBootApplication
//allows spring to see other packages
@ComponentScan(basePackageClasses = NoteController.class)
@ComponentScan(basePackageClasses = NoteRepositoryConfig.class)
@ComponentScan(basePackageClasses = NoteContext.class)
public class Application {

    public static void main(String[] args) {
        //start spring application
        SpringApplication.run(Application.class, args);
    }
}
