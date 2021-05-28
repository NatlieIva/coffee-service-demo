package ru.itsjava.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itsjava.domain.Email;
import ru.itsjava.domain.User;
import ru.itsjava.repository.DiscountCardRepository;

import java.util.Optional;

@AllArgsConstructor
@Service
public class UserAuthorizationServiceImpl implements UserAuthorizationService {
    private final UserService userService;
    private final EmailService emailService;
    private final ScannerService scannerService;
    private final DiscountCardRepository discountCardRepository;

    @Override
    public User authorization(String email) {
        Optional<Email> foundEmailByName = emailService.findByEmailName(email);
        return foundEmailByName.map(value -> userService.findUserByEmail(value).get()).orElseGet(this::addUser);
    }

    public User readUserFromConsole() {
//        замокать в тестах scannerService.readLine() - возвращает Привет;
        System.out.println("Enter your name");
        String name = scannerService.readLine();
        System.out.println("Enter your email");
        String email = scannerService.readLine();

        Email savedEmail = new Email(0L, email);
        return new User(0L, name, discountCardRepository.findById(1L).get(), savedEmail);

    }

    @Override
    public User addUser() {
        User user = readUserFromConsole();
        userService.saveUser(user);
        return user;
    }
}
