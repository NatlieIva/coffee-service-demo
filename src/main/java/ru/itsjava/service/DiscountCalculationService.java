package ru.itsjava.service;

import ru.itsjava.domain.User;

public interface DiscountCalculationService {
    double calculate(User user, double price);
}
