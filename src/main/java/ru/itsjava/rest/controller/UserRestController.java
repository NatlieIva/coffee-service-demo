package ru.itsjava.rest.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.itsjava.domain.User;
import ru.itsjava.service.UserService;

@AllArgsConstructor
@RestController
public class UserRestController {
    private final UserService userService;

    @GetMapping ("/greeting")
    public User greeting(@RequestParam (value = "id", defaultValue = "1") String id) {
        return userService.findUserById(Long.parseLong(id)).get();
    }
}
