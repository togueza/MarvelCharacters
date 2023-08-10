package com.marvel.openpay.api;

import com.marvel.openpay.api.model.UserTable;
import com.marvel.openpay.api.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class OpenpayAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(OpenpayAppApplication.class, args);
    }

    @Bean
    protected CommandLineRunner init(final UserRepository userRepository) {

        return args -> {
            UserTable user = new UserTable();
            user.setUsername("marvel");
            user.setPassword("marvel");
            user.setName("User_Marvel");
            userRepository.save(user);

        };
    }

}
