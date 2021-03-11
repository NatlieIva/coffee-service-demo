package ru.itsjava.domain;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class User {
    private final int id;
    private final String name;
    private final Email email;
    private DiscountCard discountCard;
}
