package ru.itsjava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ru.itsjava.service.CoffeeHouse;

import java.sql.SQLException;

@SpringBootApplication
public class CoffeeServiceDemoApplication {

    public static void main(String[] args) throws SQLException {

        ConfigurableApplicationContext context = SpringApplication.run(CoffeeServiceDemoApplication.class, args);
//        Console.main(args);
        context.getBean(CoffeeHouse.class).coffeeSale();
    }
}
