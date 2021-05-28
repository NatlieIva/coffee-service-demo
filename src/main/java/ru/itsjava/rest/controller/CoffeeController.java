package ru.itsjava.rest.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.itsjava.service.CoffeeService;

@Controller
@AllArgsConstructor
public class CoffeeController {
    private final CoffeeService coffeeService;

    @GetMapping ("/coffees")
    public String getCoffeesList(Model model) {
        model.addAttribute("coffees", coffeeService.findAll());
        return "coffees-list";
    }
}
