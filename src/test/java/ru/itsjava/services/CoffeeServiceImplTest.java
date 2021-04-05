package ru.itsjava.services;

import lombok.Data;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.itsjava.dao.CoffeeDao;
import ru.itsjava.domain.Coffee;
import ru.itsjava.service.CoffeeService;
import ru.itsjava.service.CoffeeServiceImpl;

import static org.mockito.Mockito.when;

//@SpringBootTest
//@DisplayName("The class CoffeeServiceImpl should: ")
//public class CoffeeServiceImplTest {
//
//    @Autowired
//    CoffeeService coffeeService;
//
//    @Autowired
//    CoffeeDao coffeeDao;
//
//    @Configuration
//    static class CoffeeServiceConfiguration{


//        @Bean
//        public CoffeeServiceImpl coffeeService(){
//            return new CoffeeServiceImpl(coffeeDao());
//        }
//        @Bean
//        public CoffeeDao coffeeDao(){
//            CoffeeDao mock = Mockito.mock(CoffeeDao.class);
//            when (mock
//            .findByPrice(150.0))
//                    .thenReturn(new Coffee("Cappuccino", new Price(3L,150.0)));
//                    return mock;
//        }
//    }
//    @DisplayName("return the correct coffee name ")
//    @Test
//    public void shouldCorrectCoffeeName(){
//        String actualCoffeeName = coffeeService.getCoffeeByPrice(150.0).getName();
//        Assertions.assertEquals("Cappuccino", actualCoffeeName);
//    }
//}
