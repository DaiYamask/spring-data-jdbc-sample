package com.example.springdatajdbcsample;

import com.example.springdatajdbcsample.Entity.User;
import com.example.springdatajdbcsample.Repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringDataJdbcSampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDataJdbcSampleApplication.class, args);
    }

    @Bean
    public boolean initData(UserRepository repository) {
        User user1 = User.of("タグバンガーズたろう", 19);
        User user2 = User.of("やまさきだい", 33);
        repository.save(user1);
        repository.save(user2);

        return true;
    }

}
