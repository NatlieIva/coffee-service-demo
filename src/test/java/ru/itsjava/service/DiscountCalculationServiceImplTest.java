package ru.itsjava.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import ru.itsjava.domain.User;

import javax.persistence.EntityManager;

@SpringBootTest
@DisplayName ("Класс DiscountCalculationService должен: ")
@Import (DiscountCalculationServiceImpl.class)
public class DiscountCalculationServiceImplTest {

    public static final double PRICE = 100.0;
    public static final long USER_ID = 1L;
    public static final double USER_PRICE = 90.0;
    @Autowired
    DiscountCalculationServiceImpl discountCalculationService;

    @Autowired
    EntityManager entityManager;

    @Test
    public void shouldHaveCorrectCalculateDiscount() {
        User user = entityManager.find(User.class, USER_ID);
        Assertions.assertEquals(USER_PRICE, discountCalculationService.calculate(user, PRICE));
    }

}
