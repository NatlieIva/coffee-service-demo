package ru.itsjava.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
@AllArgsConstructor
public class CoffeeHouseImpl implements CoffeeHouse {
    private final CoffeeService coffeeService;
    private final ScannerService scannerService;

    @Override
    public void coffeeSale() {
        System.out.println("What price do you want coffee?");
        System.out.println("Americano - 100.0" + '\n'
                + "Latte - 200.0" + '\n'
                + "Cappuccino - 150.0" + '\n'
                + "Espresso - 50.0");

        int findPrice = Integer.parseInt(scannerService.scannerStart());

        System.out.println(coffeeService.getCoffeeByPrice(findPrice).get() + " for you");
    }
}
