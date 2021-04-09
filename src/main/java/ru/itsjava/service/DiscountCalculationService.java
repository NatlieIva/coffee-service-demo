package ru.itsjava.service;

import ru.itsjava.domain.DiscountCard;
import ru.itsjava.domain.User;

public interface DiscountCalculationService {
    double calculate(User user, int price);
}
