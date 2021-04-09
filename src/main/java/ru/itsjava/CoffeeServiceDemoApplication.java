package ru.itsjava;

import org.h2.tools.Console;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ru.itsjava.dao.CoffeeDao;
import ru.itsjava.domain.Coffee;
import ru.itsjava.service.CoffeeHouse;

import java.sql.SQLException;

@SpringBootApplication
public class CoffeeServiceDemoApplication {

    public static void main(String[] args) throws SQLException {

        ConfigurableApplicationContext context = SpringApplication.run(CoffeeServiceDemoApplication.class, args);
//
//        CoffeeDao coffeeDao = context.getBean(CoffeeDao.class);
//        coffeeDao.saveCoffee(new Coffee(0L, "Americano", 100));
//        coffeeDao.saveCoffee(new Coffee(0L, "Latte", 200));
//        coffeeDao.saveCoffee(new Coffee(0L, "Cappuccino", 150));
//        coffeeDao.saveCoffee(new Coffee(0L, "Espresso", 50));
        Console.main(args);
        context.getBean(CoffeeHouse.class).coffeeSale();
    }

}
