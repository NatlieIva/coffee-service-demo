package ru.itsjava.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import ru.itsjava.domain.Coffee;
import ru.itsjava.service.CoffeeService;

@SpringBootTest
public class CoffeeRepositoryImplTest {

    private CoffeeService coffeeService;
    private final static Coffee COFFEE = new Coffee(0L, "Mocha", 160);

    @Test
    public void shouldCorrectFindByPrice(){
        Coffee foundCoffee = coffeeService.findByPrice(100).get();
        Assertions.assertEquals("Americano", foundCoffee.getName());
    }

//    @Test
//    public void shouldHaveCorrectSave() {
//    coffeeService.saveCoffee(COFFEE);
////        Coffee foundCoffee = coffeeService.findByPrice(COFFEE.getPrice()).get();
//        Assertions.assertEquals(COFFEE.getName(), coffeeService.findByPrice(COFFEE.getPrice()).get().getName());
//    }
}
