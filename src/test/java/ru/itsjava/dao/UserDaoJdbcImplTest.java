package ru.itsjava.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;
import ru.itsjava.domain.DiscountCard;
import ru.itsjava.domain.Email;
import ru.itsjava.domain.User;

@JdbcTest
@Import (UserDaoJdbcImpl.class)
public class UserDaoJdbcImplTest {
    @Autowired
    private UserDao userJdbc;

    @Test
    public void shouldHaveCorrectInsert() {
        int countBeforeInsert = userJdbc.countUser();
        User userTest = new User(2, "Kate", new DiscountCard(1, "red", 35), new Email(1, "Kate@mail.ru"));
        userJdbc.insertUser(userTest);
        int countAfterInsert = userJdbc.countUser();

        Assertions.assertEquals(countBeforeInsert + 1, countAfterInsert);
    }

    @Test
    public void shouldHaveCorrectDelete() {

        User userTest = new User(2, "Kate", new DiscountCard(1, "red", 35), new Email(1, "Kate@mail.ru"));

        userJdbc.insertUser(userTest);
        int countAfterInsert = userJdbc.countUser();
        userJdbc.deleteUser(2);
        int countAfterDelete = userJdbc.countUser();

        Assertions.assertEquals(countAfterInsert - 1, countAfterDelete);
    }

//    @Test
//    public void shouldHaveCorrectUpdate() {
//
//        User userTest = new User(2, "Kate", new DiscountCard(1,"red", 35), new Email(1, "Kate@mail.ru"));
//        userJdbc.insertUser(userTest);
//        userJdbc.updateUser(userTest, 2);
//
//        Assertions.assertEquals(userTest.getDiscountCard().getId(), 2);
//    }

    @Test
    public void shouldCorrectFindById() {
        User foundUser = userJdbc.findById(2).get();
        User newUser = new User(2, "Jack",
                new DiscountCard(3, "gold", 10),
                new Email(2, "Jack@email.com"));
        Assertions.assertEquals(foundUser, newUser);
    }
}
