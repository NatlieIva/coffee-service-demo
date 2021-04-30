package ru.itsjava.repository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import ru.itsjava.domain.Email;
import ru.itsjava.domain.User;

import javax.persistence.EntityManager;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DisplayName ("Класс UserRepository должен: ")
@DataJpaTest
@Import (UserRepositoryImpl.class)
public class UserRepositoryImplTest {
    public static final long FIRST_USER_ID = 1L;
    public static final String USER_NAME = "test";
    public static final String REAL_EMAIL = "Bob@email.com";
    public static final long USER_ID = 2L;
    @Autowired
    private UserRepositoryImpl userRepository;

    @Autowired
    private EntityManager entityManager;

    @Test
    public void shouldHaveCorrectFindById() {
        User expectedUser = entityManager.find(User.class, FIRST_USER_ID);
        Optional<User> actualUser = userRepository.findUserById(FIRST_USER_ID);
        assertThat(actualUser).isPresent().get().usingRecursiveComparison().isEqualTo(expectedUser);
    }

    @Test
    public void shouldHaveCorrectUpdate() {
        User user = userRepository.findUserById(FIRST_USER_ID).get();
        user.setName(USER_NAME);

        userRepository.updateUser(user);

        User actualUser = userRepository.findUserById(FIRST_USER_ID).get();
        assertThat(actualUser.getName())
                .isNotNull()
                .isEqualTo(USER_NAME);
    }

    @Test
    public void shouldHaveCorrectFindByEmail() {
        User actualUser = entityManager.find(User.class, FIRST_USER_ID);
        Email actualEmail = actualUser.getEmail();

        User expectedUser = userRepository.findUserByEmail(actualEmail).get();
        assertThat(actualUser)
                .isNotNull()
                .isEqualTo(expectedUser);
    }

    @Test
    public void shouldHaveCorrectSave() {
        User expectedUser = entityManager.find(User.class, FIRST_USER_ID);
        userRepository.saveUser(expectedUser);
        User actualUser = entityManager.find(User.class, USER_ID);
        System.out.println("actualUser.getId() = " + actualUser.getId());
        assertThat(actualUser).isNotNull().isEqualTo(expectedUser);
    }

    @Test
    public void shouldHaveCorrectDelete() {
        userRepository.deleteUserById(FIRST_USER_ID);
        Optional<User> deletedUser = userRepository.findUserById(FIRST_USER_ID);
        assertThat(deletedUser).isEmpty();
    }

}
