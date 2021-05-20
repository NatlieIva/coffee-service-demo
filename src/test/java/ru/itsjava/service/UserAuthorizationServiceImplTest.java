package ru.itsjava.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import ru.itsjava.domain.DiscountCard;
import ru.itsjava.domain.Email;
import ru.itsjava.domain.User;

import javax.persistence.EntityManager;

import static org.mockito.Mockito.when;

@SpringBootTest
@DisplayName ("Класс UserAuthorizationService должен: ")
@Import (UserAuthorizationServiceImpl.class)
public class UserAuthorizationServiceImplTest {

    public static final long USER_ID = 1L;
    public static final String EMAIL = "Bob@email.com";
    public static final User USER = new User(0L, "test",
            new DiscountCard(0L, "testCard", 0),
            new Email(0L, "test@mail.ru"));

    @Autowired
    EntityManager entityManager;

    @Autowired
    UserAuthorizationServiceImpl userAuthorizationService;

    @Test
    public void shouldHaveCorrectAuthorization() {
        User actualUser = userAuthorizationService.authorization(EMAIL);
        User expectedUser = entityManager.find(User.class, USER_ID);
        Assertions.assertEquals(expectedUser, actualUser);
    }

    @Test
    public void shouldHaveCorrectAddUser() {
        UserAuthorizationServiceImpl mockUser = Mockito.mock(UserAuthorizationServiceImpl.class);
        when(mockUser.readUserFromConsole()).thenReturn(new User(2L, "testName",
                entityManager.find(DiscountCard.class, 1L),
                new Email(2L, "testEmail")));
        userAuthorizationService.addUser();
        User expectedUser = entityManager.find(User.class, 2L);
        Assertions.assertEquals(expectedUser.getName(), "testName");
        // I don't know how to do it
    }
}
