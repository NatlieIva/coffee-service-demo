package ru.itsjava.rest.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

    @GetMapping ("/coffees/{id}/edit")
    public String editCoffee(@PathVariable ("id") String id, Model model) {
        CoffeeDto dto = CoffeeDto.toDto(coffeeService.findById(Long.parseLong(id)).get());
        model.addAttribute("coffeeDto", dto);
        return "coffees-edit";
    }

    @PostMapping ("/coffees/{id}/edit")
    public String editCoffee(CoffeeDto coffeeDto) {
        coffeeService.saveCoffee(CoffeeDto.toDomainObject(coffeeDto));
        return "redirect:/coffees";
    }

    @GetMapping ("/coffees/{id}/delete")
    public String deleteCoffee(@PathVariable ("id") String id, Model model) {
        CoffeeDto dto = CoffeeDto.toDto(coffeeService.findById(Long.parseLong(id)).get());
        model.addAttribute("coffeeDto", dto);
        return "coffees-delete";
    }

    @PostMapping ("/coffees/{id}/delete")
    public String deleteCoffee(CoffeeDto coffeeDto) {
        coffeeService.deleteCoffeeById(coffeeDto.getId());
        return "redirect:/coffees";
    }

    @GetMapping ("/coffees/add")
    public String addCoffee(@PathVariable Model model) {
        model.addAttribute("coffeeDto");
        return "coffees-add";
    }

    @PostMapping ("/coffees/add")
    public String addCoffee(CoffeeDto coffeeDto) {
        coffeeService.saveCoffee(CoffeeDto.toDomainObject(coffeeDto));
        return "redirect:/coffees";
    }
}
