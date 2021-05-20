package ru.itsjava.repository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import ru.itsjava.domain.Email;

import javax.persistence.EntityManager;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DisplayName ("Класс EmailRepository должен: ")
@DataJpaTest
@Import (EmailRepositoryImpl.class)
public class EmailRepositoryImplTest {
    public static final long FIRST_EMAIL_ID = 1L;
    public static final String EMAIL_NAME = "test@mail.com";
    public static final String REAL_EMAIL = "Bob@email.com";
    public static final Email EMAIL = new Email(0L, "test@mail.com");
    public static final long EMAIL_ID = 2L;
    @Autowired
    private EmailRepositoryImpl emailRepository;

    @Autowired
    private EntityManager entityManager;

    @Test
    public void shouldHaveCorrectFindById() {
        Email expectedEmail = entityManager.find(Email.class, FIRST_EMAIL_ID);
        Optional<Email> actualEmail = emailRepository.findById(FIRST_EMAIL_ID);
        assertThat(actualEmail).isPresent().get().usingRecursiveComparison().isEqualTo(expectedEmail);
    }

    @Test
    public void shouldHaveCorrectUpdate() {
        Email email = emailRepository.findById(FIRST_EMAIL_ID).get();
        email.setName(EMAIL_NAME);

        emailRepository.updateEmail(email);

        Email actualEmail = emailRepository.findById(FIRST_EMAIL_ID).get();
        assertThat(actualEmail.getName())
                .isNotNull()
                .isEqualTo(EMAIL_NAME);
    }

    @Test
    public void shouldHaveCorrectFindByName() {
        Email actualEmail = emailRepository.findByEmailName(REAL_EMAIL).get();
        Email expectedEmail = emailRepository.findById(FIRST_EMAIL_ID).get();
        assertThat(actualEmail)
                .isNotNull()
                .isEqualTo(expectedEmail);
    }

    @Test
    public void shouldHaveCorrectSave() {
        Email expectedEmail = emailRepository.saveEmail(EMAIL);
        Email actualEmail = entityManager.find(Email.class, expectedEmail.getId());
        System.out.println("actualEmail.getName() = " + actualEmail.getName());
        assertThat(actualEmail).isNotNull().isEqualTo(expectedEmail);
    }

    @Test
    public void shouldHaveCorrectDelete() {
        emailRepository.saveEmail(EMAIL);
        emailRepository.deleteEmailById(EMAIL_ID);
        Optional<Email> deletedEmail = emailRepository.findById(EMAIL_ID);
        assertThat(deletedEmail).isEmpty();
    }
}
