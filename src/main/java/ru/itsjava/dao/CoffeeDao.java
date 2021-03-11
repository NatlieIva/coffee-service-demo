package ru.itsjava.dao;

import ru.itsjava.domain.Coffee;

public interface CoffeeDao {
    Coffee findByPrice(double price);

}
