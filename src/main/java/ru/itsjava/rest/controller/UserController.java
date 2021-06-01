package ru.itsjava.rest.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itsjava.service.UserService;

@Controller
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping ("/")
    public String getMainPage() {
        return "index1";
    }

    @GetMapping ("/users")
    public String getUserList(Model model) {
        model.addAttribute("users", userService.findAll());
        return "users-list";
    }

    @GetMapping ("/users{id}/edit")
    public String editUser(@PathVariable ("id") String id, Model model) {
        UserDto dto = UserDto.toDto(userService.findUserById(Long.parseLong(id)).get());
        model.addAttribute("userDto", dto);
        return "users-edit";
    }

    @PostMapping ("/users{id}/edit")
    public String editUser(UserDto userDto) {
        userService.saveUser(UserDto.toDomainObject(userDto));
        return "redirect:/";
    }
}
