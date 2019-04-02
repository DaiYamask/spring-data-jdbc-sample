package com.example.springdatajdbcsample.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.Wither;
import org.springframework.data.annotation.Id;

@AllArgsConstructor
@Getter
public class User {

    @Id
    @Wither
    private final Long id;
    private final String name;
    private final Integer age;

    public static User of(String name, Integer age) {
        return new User(null, name, age);
    }

}
