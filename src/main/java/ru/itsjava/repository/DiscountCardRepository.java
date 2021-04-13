package ru.itsjava.repository;

import ru.itsjava.domain.DiscountCard;
import java.util.Optional;

public interface DiscountCardRepository {

//    int countDiscountCard();

    DiscountCard saveDiscountCard(DiscountCard discountCard);

    void deleteDiscountCardById(long id);

    void updateDiscountCard(DiscountCard discountCard);

    Optional<DiscountCard> findById(long id);
}
