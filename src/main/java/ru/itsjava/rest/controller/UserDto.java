package ru.itsjava.rest.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.itsjava.domain.DiscountCard;
import ru.itsjava.domain.Email;
import ru.itsjava.domain.User;

@Data
@AllArgsConstructor
public class UserDto {
    private long id;
    private String name;
    private DiscountCard discount_card;
    private Email email;

    public static User toDomainObject(UserDto userDto) {
        return new User(userDto.id, userDto.name, userDto.discount_card, userDto.email);
    }

    public static UserDto toDto(User user) {
        return new UserDto(user.getId(), user.getName(), user.getDiscountCard(), user.getEmail());
    }
}
