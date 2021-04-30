package ru.itsjava.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "discount_card_id")
    private DiscountCard discountCard;

    @OneToOne(fetch=FetchType.EAGER, optional=true, cascade=CascadeType.ALL)
    @JoinColumn(name = "email_id")
    private  Email email;
}
