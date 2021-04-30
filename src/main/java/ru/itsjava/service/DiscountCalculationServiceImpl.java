package ru.itsjava.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.itsjava.domain.User;

@Service
public class DiscountCalculationServiceImpl implements DiscountCalculationService {

    @Transactional
    @Override
    public double calculate(User user, double price) {
        return price - price * user.getDiscountCard().getDiscount() / 100;
    }
}
