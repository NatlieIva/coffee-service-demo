package ru.itsjava.dao;

import ru.itsjava.domain.DiscountCard;

public interface DiscountCardDao {
    int countDiscountCard();

    void insertDiscountCard(DiscountCard discountCard);

    void deleteDiscountCard(DiscountCard discountCard);

    void updateDiscountCard(DiscountCard discountCard);

    String getColor(int id);
}
