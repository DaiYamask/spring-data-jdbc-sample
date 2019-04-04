package com.example.springdatajdbcsample.Repository;

import com.example.springdatajdbcsample.Entity.Role;
import com.example.springdatajdbcsample.Entity.User;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static com.example.springdatajdbcsample.Repository.Tables.ROLE;
import static com.example.springdatajdbcsample.Repository.Tables.USER;


public class JooqCustomUserRepositoryImpl implements JooqCustomUserRepository {

    @Autowired
    private DSLContext dslContext;

    @Override
    public List<User> findByName(String name) {
        return this.dslContext.select().from(USER).where(USER.NAME.equal(name))
                .fetchInto(User.class);
    }
}
