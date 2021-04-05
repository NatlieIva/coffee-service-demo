package ru.itsjava.service;

import ru.itsjava.domain.Coffee;

import java.util.Optional;

public interface CoffeeService {
    Optional<Coffee> getCoffeeByPrice(int price);
}
