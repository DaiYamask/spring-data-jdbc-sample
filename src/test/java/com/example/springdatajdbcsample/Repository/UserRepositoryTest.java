package com.example.springdatajdbcsample.Repository;

import com.example.springdatajdbcsample.Entity.User;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Optional;

@RunWith(SpringRunner.class)
@DataJdbcTest
@Transactional
public class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Before
    public void setUp() throws Exception {
        userRepository.deleteAll();
    }

    @Test
    public void save() {
        User user = User.of("タグバンガーズ太郎", 8);
        User savedUser = userRepository.save(user);

        Assertions.assertThat(savedUser).isNotNull();
        Assertions.assertThat(user).isNotEqualTo(savedUser);
    }

    @Test
    public void saveAndFind() {
        User user = User.of("タグバンガーズ太郎", 8);
        User savedUser = userRepository.save(user);

        Optional<User> findUser = userRepository.findById(savedUser.getId());

        Assertions.assertThat(findUser.get()).isNotNull();
        Assertions.assertThat(findUser.get().getAge()).isEqualTo(8);
        Assertions.assertThat(findUser.get().getName()).isEqualTo("タグバンガーズ太郎");
    }

    @Test
    public void saveAndDelete() {
        User user = User.of("タグバンガーズ太郎", 8);
        User savedUser = userRepository.save(user);
        userRepository.deleteById(savedUser.getId());

        Iterable<User> users = userRepository.findAll();

        Assertions.assertThat(users.iterator().hasNext()).isFalse();
    }

    @Test
    public void saveAndCount() {
        User taro = User.of("タグバンガーズ太郎", 8);
        User hanako = User.of("タグバンガーズ花子", 10);
        userRepository.saveAll(Arrays.asList(taro, hanako));

        long countUser = userRepository.count();

        Assertions.assertThat(countUser).isEqualTo(2L);
    }

    @Test
    public void saveAndExist() {
        User user = User.of("タグバンガーズ太郎", 8);
        User savedUser = userRepository.save(user);

        boolean exists = userRepository.existsById(savedUser.getId());

        Assertions.assertThat(exists).isTrue();
    }

}