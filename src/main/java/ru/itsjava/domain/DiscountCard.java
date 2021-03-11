package ru.itsjava.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
@Getter
@RequiredArgsConstructor
public enum DiscountCard {
    WHITE(5),
    BLACK(10);

    private final int discount;


}
