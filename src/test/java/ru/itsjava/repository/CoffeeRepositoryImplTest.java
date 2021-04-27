package ru.itsjava.repository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.context.annotation.Import;
import ru.itsjava.domain.Coffee;

import javax.persistence.EntityManager;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DisplayName("Класс CoffeeRepository должен: ")
@DataJdbcTest
@Import(CoffeeRepositoryImpl.class)
public class CoffeeRepositoryImplTest {
    @Autowired
    private CoffeeRepositoryImpl coffeeRepository;

    @Autowired
    private EntityManager entityManager;

    @Test
    public void shouldHaveCorrectFindById(){
        Coffee expectedCoffee = entityManager.find(Coffee.class, 1L);
        Optional<Coffee> actualCoffee = coffeeRepository.findById(1L);
        assertThat(actualCoffee).isPresent().get().usingRecursiveComparison().isEqualTo(expectedCoffee);
    }
}
