package com.example.springdatajdbcsample.Repository;

import com.example.springdatajdbcsample.Entity.QUser;
import com.example.springdatajdbcsample.Entity.User;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.Projections;
import com.querydsl.sql.SQLQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class QueryDslUserRepositoryImpl implements QueryDslUserRepository {

    private final QUser qUser = QUser.user;

    @Autowired
    SQLQueryFactory sqlQueryFactory;

    @Override
    public User findOne(Predicate predicate) {
//        return sqlQueryFactory.selectFrom(qUser.name);
        return sqlQueryFactory.select(Projections.bean(User.class, qUser.id, qUser.name, qUser.age)).from(qUser).where(predicate).fetchOne();
    }
}
