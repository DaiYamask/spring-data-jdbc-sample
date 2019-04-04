package com.example.springdatajdbcsample.Repository;

import com.example.springdatajdbcsample.Entity.QUser;
import com.example.springdatajdbcsample.Entity.User;
import com.querydsl.core.BooleanBuilder;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.management.Query;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
//@DataJdbcTest
@SpringBootTest
@Transactional
public class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Before
    public void setUp() throws Exception {
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

    @Test
    public void findByName() {
        User user = User.of("タグバンガーズ太郎", 8);
        userRepository.save(user);

        List<User> users = userRepository.findByName("タグバンガーズ太郎");
        Assertions.assertThat(users).isNotEmpty();

    }

    @Test
    public void queryDsl() {
        User user = User.of("tagbangers", 8);
        userRepository.save(user);

        User userName = userRepository.findOne(queryNamesWithDSL("tagbangers"));
//        Optional<User> users = userRepository.findOne(queryNamesWithDSL("タグバンガーズ"));
        Assertions.assertThat(userName).isNotNull();

    }

    @Test
    public void page() {
//        User user = User.of("タグバンガーズ太郎", 8);
//        userRepository.save(user);
//        userRepository.save(user);
//        userRepository.save(user);
//        userRepository.save(user);
//
//        Pageable pageable = new PageRequest(0, 1);
//        Page<User> all = userRepository.findAll(pageable);
    }

    public static com.querydsl.core.types.Predicate queryNamesWithDSL(String filter) {
        BooleanBuilder builder = new BooleanBuilder();
        QUser user = QUser.user;
        final String param = filter;
        builder.or(user.name.lower().eq(param));

        return builder;

    }
}