package ru.itsjava.dao;

import ru.itsjava.domain.DiscountCard;

import java.util.Optional;

public interface DiscountCardDao {
    int countDiscountCard();

    long insertDiscountCard(DiscountCard discountCard);

    void deleteDiscountCard(DiscountCard discountCard);

    void updateDiscountCard(DiscountCard discountCard, String color, int discount);

    Optional<DiscountCard> findById(int id);
}
