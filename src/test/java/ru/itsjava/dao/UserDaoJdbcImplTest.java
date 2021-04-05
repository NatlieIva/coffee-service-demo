//package ru.itsjava.dao;
//
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
//import org.springframework.context.annotation.Import;
//import ru.itsjava.domain.DiscountCard;
//import ru.itsjava.domain.Email;
//import ru.itsjava.domain.User;
//
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//@JdbcTest
//@Import (UserDaoJdbcImpl.class)
//public class UserDaoJdbcImplTest {
//
//    static final User USER_TEST = new User(2L, "Kate",
//            new DiscountCard(1L, "white", 0),
//            new Email(2L, "Kate@mail.ru"));
//
//    @Autowired
//    private UserDao userJdbc;
//
//    @Test
//    public void shouldHaveCorrectCount() {
//        int count = userJdbc.countUser();
//        System.out.println("count = " + count);
//
//        assertEquals(1, count);
//    }
//
//    @Test
//    public void shouldHaveCorrectInsert() {
//        int countBeforeInsert = userJdbc.countUser();
//        userJdbc.insertUser(USER_TEST);
//        int countAfterInsert = userJdbc.countUser();
//        System.out.println("userJdbc.findById(2).get() = " + userJdbc.findUserById(2).get());
//
//        Optional<User> optionalUser = userJdbc.findUserById(2L);
//        Assertions.assertAll(() -> assertEquals(countBeforeInsert + 1, countAfterInsert),
//                optionalUser::isPresent,
//                () -> assertEquals(USER_TEST, optionalUser.get()));
//    }
//
//    @Test
//    public void shouldHaveCorrectDelete() {
//        userJdbc.insertUser(USER_TEST);
//        int countAfterInsert = userJdbc.countUser();
//        userJdbc.deleteUser(2);
//        int countAfterDelete = userJdbc.countUser();
//
//        Optional<User> optionalUser = userJdbc.findUserById(2L);
//        Assertions.assertAll(() -> assertEquals(countAfterInsert - 1, countAfterDelete),
//                optionalUser::isEmpty);
//    }
//
//    @Test
//    public void shouldHaveCorrectUpdate() {
//        userJdbc.insertUser(USER_TEST);
//        USER_TEST.setDiscountCard(new DiscountCard(2L, "black", 5));
//        userJdbc.updateUser(USER_TEST);
//        User foundUser = userJdbc.findUserById(2).get();
//        System.out.println("foundUser.getDiscountCard() = " + foundUser.getDiscountCard());
//        System.out.println("foundUser.getEmail() = " + foundUser.getEmail());
//        System.out.println("foundUser.getId() = " + foundUser.getId());
//        assertEquals(2, foundUser.getDiscountCard().getId());
//    }
//
//    @Test
//    public void shouldCorrectFindById() {
//        User foundUser = userJdbc.findUserById(1).get();
//        User newUser = new User(1, "Bob",
//                new DiscountCard(2, "black", 5),
//                new Email(1, "Bob@email.com"));
//        assertEquals(foundUser, newUser);
//    }
//}
