package com.carona.abc.caronabc.user;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
class UserRepositoryTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private UserRepository userRepository;

    @Test
    void testCreateUser() {

        User user = new User();
        user.setEmail("dummy.email@aluno.ufabc.edu.br");
        user.setPassword("123456");
        user.setFullName("Dummy Name");
        user.setRa("123456789");

        User savedUser = userRepository.save(user);
        User existUser = testEntityManager.find(User.class,savedUser.getId());

        assertThat(user.getEmail()).isEqualTo(existUser.getEmail());
    }
}