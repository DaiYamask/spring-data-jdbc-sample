package com.example.springdatajdbcsample.Entity;

import com.querydsl.core.annotations.QueryEntity;
import com.querydsl.core.annotations.QueryProjection;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.Wither;
import org.springframework.data.annotation.Id;

@QueryEntity
@Getter
public class User {

    @Id
    @Wither
    private Long id;
    private String name;
    private Integer age;


    @QueryProjection
    public User(Long id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public static User of(String name, Integer age) {
        return new User(null, name, age);
    }

}
