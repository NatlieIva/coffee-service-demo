package ru.itsjava.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itsjava.dao.CoffeeDao;
import ru.itsjava.domain.Coffee;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CoffeeServiceImpl implements CoffeeService {

    private final CoffeeDao coffeeDao;

    @Override
    public Optional<Coffee> getCoffeeByPrice(int price) {
        return coffeeDao.findByPrice(price);
    }
}
