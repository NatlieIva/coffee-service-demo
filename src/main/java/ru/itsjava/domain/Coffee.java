package ru.itsjava.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;

@Getter
@ToString
@RequiredArgsConstructor
public class Coffee {
    private final String name;
    private final Price price;


//    AMERICANO("Americano", 100.0),
//    LATTE("Latte", 200.0),
//    CAPPUCCINO("Cappuccino", 150.0),
//    ESPRESSO("Espresso", 50.0);
//
//    private final String name;
//    private final double price;
}
