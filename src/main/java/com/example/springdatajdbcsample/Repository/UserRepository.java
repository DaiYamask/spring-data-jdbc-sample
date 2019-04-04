package com.example.springdatajdbcsample.Repository;

import com.example.springdatajdbcsample.Entity.User;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long>, QueryDslUserRepository {

    @Query("select * from user where name = :name")
    List<User> findByName(String name);

    public class UserSpecifications {
    }
}
