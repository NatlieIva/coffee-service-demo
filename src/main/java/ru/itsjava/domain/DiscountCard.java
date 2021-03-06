package ru.itsjava.domain;

import lombok.*;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "discount_cards")
public class DiscountCard {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "color")
    private String color;

    @Column(name = "discount")
    private int discount;
}

