package com.example.springdatajdbcsample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;

@SpringBootApplication
public class SpringDataJdbcSampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDataJdbcSampleApplication.class, args);
    }

}
