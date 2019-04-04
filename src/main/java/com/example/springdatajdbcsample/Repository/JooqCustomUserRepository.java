package com.example.springdatajdbcsample.Repository;

import com.example.springdatajdbcsample.Entity.User;

import java.util.List;

public interface JooqCustomUserRepository {
    List<User> findByName(String name);
}
