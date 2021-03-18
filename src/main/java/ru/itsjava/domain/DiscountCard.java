package ru.itsjava.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;


@AllArgsConstructor
@Data
public class DiscountCard {
    private final int id;
    private final String color;
    private final int discount;
}
