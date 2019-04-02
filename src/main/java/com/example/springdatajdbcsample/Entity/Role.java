package com.example.springdatajdbcsample.Entity;

import lombok.Getter;
import org.springframework.data.annotation.Id;

@Getter
public class Role {
    @Id
    private final Long id;
    private final String name;

    private Role(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Role withId(Long id){
        return new Role(id, name);
    }

}
