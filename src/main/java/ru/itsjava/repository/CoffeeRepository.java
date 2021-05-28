package ru.itsjava.repository;

import ru.itsjava.domain.Coffee;

import java.util.List;
import java.util.Optional;

public interface CoffeeRepository {

    Optional<Coffee> findByPrice(double price);

    Optional<Coffee> findById(long id);

    Coffee saveCoffee(Coffee coffee);

    void deleteCoffeeById(long id);

    void updateCoffee(Coffee coffee);

    List<Coffee> getAll();

}
