package ru.itsjava.dao;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.itsjava.domain.Coffee;
import ru.itsjava.domain.Price;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Repository
@RequiredArgsConstructor
@Getter
public class CoffeeDaoImpl implements CoffeeDao {

    @Override
    public Coffee findByPrice(double price) {
        List<Coffee> coffeeList = new ArrayList<>();

        Coffee americano = new Coffee("Americano", new Price(100.0));
        Coffee latte = new Coffee("Latte", new Price(200.0));
        Coffee cappuccino = new Coffee("Cappuccino", new Price(150.0));
        Coffee espresso = new Coffee("Espresso", new Price(50.0));
        coffeeList.add(americano);
        coffeeList.add(latte);
        coffeeList.add(cappuccino);
        coffeeList.add(espresso);

        for (Coffee coffee : coffeeList) {
        if (coffee.getPrice().getPrice() == price)
            return coffee;
    }
        throw new NoSuchElementException("There is no coffee at this price");
    }
}
