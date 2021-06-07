package ru.itsjava.rest.controller.discountCard;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.itsjava.domain.DiscountCard;

@Data
@AllArgsConstructor
public class DiscountCardDto {
    private Long id;
    private String color;
    private int discount;

    public static DiscountCard toDomainObject(DiscountCardDto discountCardDto) {
        return new DiscountCard(0L, discountCardDto.color, discountCardDto.discount);
    }

    public static DiscountCardDto toDto(DiscountCard discountCard) {
        return new DiscountCardDto(discountCard.getId(), discountCard.getColor(), discountCard.getDiscount());
    }
}
