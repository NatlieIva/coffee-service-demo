package ru.itsjava.rest.controller.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.itsjava.domain.DiscountCard;
import ru.itsjava.domain.Email;
import ru.itsjava.domain.User;

@Data
@AllArgsConstructor
public class UserDto {
    private Long id;
    private String name;
    private String discountCardColor;
    private int discount;
    private String email;

    public static User toDomainObject(UserDto userDto) {
        return new User(userDto.id, userDto.name, new DiscountCard(
                0L, userDto.discountCardColor, userDto.discount),
                new Email(0L, userDto.email));
    }

    public static UserDto toDto(User user) {
        return new UserDto(user.getId(),
                user.getName(),
                user.getDiscountCard().getColor(),
                user.getDiscountCard().getDiscount(),
                user.getEmail().getName());
    }
}
