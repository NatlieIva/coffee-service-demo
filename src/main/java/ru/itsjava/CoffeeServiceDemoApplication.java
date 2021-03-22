package ru.itsjava;

import org.h2.tools.Console;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ru.itsjava.dao.DiscountCardDao;
import ru.itsjava.dao.UserDao;
import ru.itsjava.domain.DiscountCard;
import ru.itsjava.domain.Email;
import ru.itsjava.domain.User;
import ru.itsjava.service.CoffeeHouse;

import java.sql.SQLException;

@SpringBootApplication
public class CoffeeServiceDemoApplication {

    public static void main(String[] args) throws SQLException {

        ConfigurableApplicationContext context = SpringApplication.run(CoffeeServiceDemoApplication.class, args);
//        context.getBean(CoffeeHouse.class).coffeeSale();
        DiscountCardDao discountCardDao = context.getBean(DiscountCardDao.class);
        System.out.println("discountCardDao.countDiscountCard() = " + discountCardDao.countDiscountCard());

        DiscountCard yellowDiscountCard = new DiscountCard(5, "yellow", 50);
        DiscountCard diamondDiscountCard = new DiscountCard(4, "diamond", 25);

        discountCardDao.insertDiscountCard(diamondDiscountCard);
        discountCardDao.insertDiscountCard(yellowDiscountCard);
//        discountCardDao.deleteDiscountCard(yellowDiscountCard);

        discountCardDao.updateDiscountCard(diamondDiscountCard, "pink", 30);

        System.out.println("discountCardDao.findById(5) = " + discountCardDao.findById(5));
//        System.out.println("context.getBean(DiscountCardDao.class).countDiscountCard() = " + context.getBean(DiscountCardDao.class).countDiscountCard());

        UserDao userDao = context.getBean(UserDao.class);
        System.out.println("userDao.countUser() = " + userDao.countUser());

        User user1 = new User(1, "Sam",diamondDiscountCard, new Email(3, "@EEE.com"));
        userDao.insertUser(user1);
        userDao.deleteUser(2);

        System.out.println("userDao.findById(1) = " + userDao.findById(1));
        userDao.updateUser(user1, 3);
        Console.main(args);
    }
}
