package ru.itsjava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ru.itsjava.service.CoffeeHouse;

@SpringBootApplication
public class CoffeeServiceDemoApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(CoffeeServiceDemoApplication.class, args);
        context.getBean(CoffeeHouse.class).coffeeSale();
    }


}
