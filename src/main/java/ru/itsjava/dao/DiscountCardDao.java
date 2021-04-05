package ru.itsjava.dao;

import ru.itsjava.domain.DiscountCard;
import java.util.Optional;

public interface DiscountCardDao {

//    int countDiscountCard();

    DiscountCard saveDiscountCard(DiscountCard discountCard);

    void deleteDiscountCardById(long id);

    void updateDiscountCard(DiscountCard discountCard);

    Optional<DiscountCard> findById(long id);
}
