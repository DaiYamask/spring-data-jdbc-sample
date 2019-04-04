package com.example.springdatajdbcsample.Repository;

import com.example.springdatajdbcsample.Entity.User;
import com.querydsl.core.types.Predicate;

public interface QueryDslUserRepository {
    User findOne(Predicate predicate);
}
