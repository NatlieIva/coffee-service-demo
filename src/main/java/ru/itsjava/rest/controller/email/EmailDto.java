package ru.itsjava.rest.controller.email;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.itsjava.domain.Email;

@Data
@AllArgsConstructor
public class EmailDto {
    private Long id;
    private String name;

    public static Email toDomainObject(EmailDto emailDto) {
        return new Email(emailDto.getId(), emailDto.getName());
    }

    public static EmailDto toDto(Email email) {
        return new EmailDto(email.getId(), email.getName());
    }
}
