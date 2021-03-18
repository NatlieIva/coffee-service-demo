package ru.itsjava.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
@AllArgsConstructor
public class CoffeeHouseImpl implements CoffeeHouse {
    private final CoffeeService coffeeService;

    @Override
    public void coffeeSale() {
        System.out.println("Hello! What price do you want coffee?");
        System.out.println("Americano - 100.0" + '\n'
                + "Latte - 200.0" + '\n'
                + "Cappuccino - 150.0" + '\n'
                + "Espresso - 50.0");
        Scanner console = new Scanner(System.in);
        double order = console.nextDouble();
        System.out.println(
                coffeeService.getCoffeeByPrice(order).getName() + " for you");
    }
}
