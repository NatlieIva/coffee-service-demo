package ru.itsjava.rest.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.itsjava.domain.Coffee;

@Data
@AllArgsConstructor
public class CoffeeDto {
    private long id;
    private String name;
    private double price;


    public static Coffee toDomainObject(CoffeeDto coffeeDto) {
        return new Coffee(coffeeDto.id, coffeeDto.name, coffeeDto.price);
    }

    public static CoffeeDto toDto(Coffee coffee) {
        return new CoffeeDto(coffee.getId(), coffee.getName(), coffee.getPrice());
    }
}
