package ru.itsjava.domain;

import lombok.*;


@AllArgsConstructor
@Data
public class DiscountCard {
    private final int id;
    private final String color;
    private final int discount;
}
