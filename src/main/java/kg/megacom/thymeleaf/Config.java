package kg.megacom.thymeleaf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Configuration
public class Config {
    @Bean
    public List<User> getUsers() {
        return new ArrayList<>();
    }

    @Bean
    public Long getUserId() {
        return ThreadLocalRandom.current().nextLong(100);
    }
}
