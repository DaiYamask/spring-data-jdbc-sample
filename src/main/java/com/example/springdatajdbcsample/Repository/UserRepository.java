package com.example.springdatajdbcsample.Repository;

import com.example.springdatajdbcsample.Entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long>, JooqCustomUserRepository {
}
