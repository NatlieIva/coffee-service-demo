package ru.itsjava.rest.controller.coffee;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.itsjava.domain.Coffee;

import java.util.Objects;

@Data
@AllArgsConstructor
public class CoffeeDto {
    private Long id;
    private String name;
    private double price;


    public static Coffee toDomainObject(CoffeeDto coffeeDto) {
        return new Coffee(Objects.requireNonNullElse(coffeeDto.id, 0L), coffeeDto.name, coffeeDto.price);
    }

    public static CoffeeDto toDto(Coffee coffee) {
        return new CoffeeDto(coffee.getId(), coffee.getName(), coffee.getPrice());
    }
}
