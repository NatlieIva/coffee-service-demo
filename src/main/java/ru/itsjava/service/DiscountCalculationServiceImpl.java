package ru.itsjava.service;

import org.springframework.stereotype.Service;
import ru.itsjava.domain.User;

@Service
public class DiscountCalculationServiceImpl implements DiscountCalculationService {
    @Override
    public double calculate(User user, int price) {
        return price * user.getDiscountCard().getDiscount() / 100;
    }
}
