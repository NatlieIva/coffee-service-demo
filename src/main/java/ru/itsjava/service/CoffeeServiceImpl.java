package ru.itsjava.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itsjava.dao.CoffeeDao;
import ru.itsjava.dao.CoffeeDaoImpl;
import ru.itsjava.domain.Coffee;

@Service
@RequiredArgsConstructor
public class CoffeeServiceImpl implements CoffeeService {

    private final CoffeeDao coffeeDao;

    @Override
    public Coffee getCoffeeByPrice(double price) {
        return coffeeDao.findByPrice(price);
    }
}
