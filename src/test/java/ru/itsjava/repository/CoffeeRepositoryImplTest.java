package ru.itsjava.repository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import ru.itsjava.domain.Coffee;

import javax.persistence.EntityManager;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DisplayName ("Класс CoffeeRepository должен: ")
@DataJpaTest
@Import (CoffeeRepositoryImpl.class)
public class CoffeeRepositoryImplTest {
    public static final long FIRST_COFFEE_ID = 1L;
    public static final int PRICE = 100_000;
    public static final int REAL_PRICE = 100;
    public static final Coffee COFFEE = new Coffee(0L, "Mocha", 250);
    public static final long COFFEE_ID = 3L;
    @Autowired
    private CoffeeRepositoryImpl coffeeRepository;

    @Autowired
    private EntityManager entityManager;

    @Test
    public void shouldHaveCorrectFindById(){
        Coffee expectedCoffee = entityManager.find(Coffee.class, FIRST_COFFEE_ID);
        Optional<Coffee> actualCoffee = coffeeRepository.findById(FIRST_COFFEE_ID);
        assertThat(actualCoffee).isPresent().get().usingRecursiveComparison().isEqualTo(expectedCoffee);
    }

    @Test
    public void shouldHaveCorrectUpdate(){
        Coffee coffee = coffeeRepository.findById(FIRST_COFFEE_ID).get();
        coffee.setPrice(PRICE);

        coffeeRepository.updateCoffee(coffee);

        Coffee actualCoffee = coffeeRepository.findById(FIRST_COFFEE_ID).get();
        assertThat(actualCoffee.getPrice())
                .isNotNull()
                .isEqualTo(PRICE);
    }

    @Test
    public void shouldHaveCorrectFindByPrice(){
        Coffee actualCoffee = coffeeRepository.findByPrice(REAL_PRICE).get();
        Coffee expectedCoffee = coffeeRepository.findById(FIRST_COFFEE_ID).get();
        assertThat(actualCoffee)
                .isNotNull()
                .isEqualTo(expectedCoffee);
    }

    @Test
    public void shouldHaveCorrectSave(){
        Coffee expectedCoffee = coffeeRepository.saveCoffee(COFFEE);
//        Coffee actualCoffee = coffeeRepository.findById(COFFEE_ID).get();
        Coffee actualCoffee = entityManager.find(Coffee.class, expectedCoffee.getId());
        System.out.println("actualCoffee.getName() = " + actualCoffee.getName());
        assertThat(actualCoffee).isNotNull().isEqualTo(expectedCoffee);
    }

    @Test
    public void shouldHaveCorrectDelete(){
        coffeeRepository.saveCoffee(COFFEE);
        coffeeRepository.deleteCoffeeById(COFFEE_ID);
        Optional<Coffee> deletedCoffee = coffeeRepository.findById(COFFEE_ID);
        assertThat(deletedCoffee).isEmpty();
    }
}

