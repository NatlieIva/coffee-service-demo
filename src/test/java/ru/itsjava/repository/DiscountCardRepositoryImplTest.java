package ru.itsjava.repository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import ru.itsjava.domain.DiscountCard;

import javax.persistence.EntityManager;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DisplayName ("Класс DiscountCardRepository должен: ")
@DataJpaTest
@Import (DiscountCardRepositoryImpl.class)
public class DiscountCardRepositoryImplTest {
    public static final long FIRST_DISCOUNT_CARD_ID = 1L;
    public static final int DISCOUNT = 100_000;
    public static final DiscountCard DISCOUNT_CARD = new DiscountCard(0L, "diamond", 50);
    public static final long DISCOUNT_CARD_ID = 2L;
    @Autowired
    private DiscountCardRepositoryImpl discountCardRepository;

    @Autowired
    private EntityManager entityManager;

    @Test
    public void shouldHaveCorrectFindById() {
        DiscountCard expectedDiscountCard = entityManager.find(DiscountCard.class, FIRST_DISCOUNT_CARD_ID);
        Optional<DiscountCard> actualDiscountCard = discountCardRepository.findById(FIRST_DISCOUNT_CARD_ID);
        assertThat(actualDiscountCard).isPresent()
                .get()
                .usingRecursiveComparison()
                .isEqualTo(expectedDiscountCard);
    }

    @Test
    public void shouldHaveCorrectUpdate() {
        DiscountCard discountCard = discountCardRepository.findById(FIRST_DISCOUNT_CARD_ID).get();
        discountCard.setDiscount(DISCOUNT);

        discountCardRepository.updateDiscountCard(discountCard);

        DiscountCard actualDiscountCard = discountCardRepository.findById(FIRST_DISCOUNT_CARD_ID).get();
        assertThat(actualDiscountCard.getDiscount())
                .isNotNull()
                .isEqualTo(DISCOUNT);
    }

    @Test
    public void shouldHaveCorrectSave() {
        DiscountCard expectedDiscountCard = discountCardRepository.saveDiscountCard(DISCOUNT_CARD);
        Optional<DiscountCard> actualDiscountCard = discountCardRepository.findById(expectedDiscountCard.getId());
        System.out.println("actualDiscountCard.get().getColor() = " + actualDiscountCard.get().getColor());
        assertThat(actualDiscountCard.get()).isNotNull().isEqualTo(expectedDiscountCard);
    }

    @Test
    public void shouldHaveCorrectDelete() {
        discountCardRepository.saveDiscountCard(DISCOUNT_CARD);
        discountCardRepository.deleteDiscountCardById(DISCOUNT_CARD_ID);
        Optional<DiscountCard> deletedDiscountCard = discountCardRepository.findById(DISCOUNT_CARD_ID);
        assertThat(deletedDiscountCard).isEmpty();
    }
}
