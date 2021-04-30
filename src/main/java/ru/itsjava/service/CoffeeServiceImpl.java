package ru.itsjava.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.itsjava.domain.Coffee;
import ru.itsjava.repository.CoffeeRepository;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CoffeeServiceImpl implements CoffeeService {

    private final CoffeeRepository coffeeRepository;

    @Transactional (readOnly = true)
    @Override
    public Optional<Coffee> findByPrice(double price) {
        return coffeeRepository.findByPrice(price);
    }

    @Transactional (readOnly = true)
    @Override
    public Optional<Coffee> findById(long id) {
        return coffeeRepository.findById(id);
    }

    @Transactional
    @Override
    public Coffee saveCoffee(Coffee coffee) {
        return coffeeRepository.saveCoffee(coffee);
    }

    @Transactional
    @Override
    public void deleteCoffeeById(long id) {
        coffeeRepository.deleteCoffeeById(id);
    }

    @Transactional
    @Override
    public void updateCoffee(Coffee coffee) {
        coffeeRepository.updateCoffee(coffee);
    }
}
