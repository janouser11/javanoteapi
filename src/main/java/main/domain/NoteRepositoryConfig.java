package main.domain;

import main.data.NoteContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NoteRepositoryConfig {

    @Bean
    public NoteRepository noteRepository() {
        NoteContext noteContext = new NoteContext();
        return new NoteRepository(noteContext);
    }
}
