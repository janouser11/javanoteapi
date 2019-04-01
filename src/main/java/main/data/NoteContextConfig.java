package main.data;

import main.domain.NoteRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NoteContextConfig {
    @Bean
    public NoteContext noteContext() {
        return new NoteContext();
    }
}
