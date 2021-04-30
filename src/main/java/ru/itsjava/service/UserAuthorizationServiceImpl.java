package ru.itsjava.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itsjava.domain.Email;
import ru.itsjava.domain.User;
import ru.itsjava.repository.DiscountCardRepository;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserAuthorizationServiceImpl implements UserAuthorizationService {
    private final UserService userService;
    private final EmailService emailService;
    private final ScannerService scannerService;
    private final DiscountCardRepository discountCardRepository;

    @Override
    public User authorization(String email) {
        Optional<Email> foundEmailByName = emailService.findByEmailName(email);

        if (foundEmailByName.isPresent()) {
            return userService.findUserByEmail(foundEmailByName.get()).get();
        }
        return addUser();
    }

    @Override
    public User addUser() {
        System.out.println("Enter your name");
        String name = scannerService.readLine();
        System.out.println("Enter your email");
        String email = scannerService.readLine();

        Email savedEmail = new Email(0L, email);
        User user = new User(0L, name, discountCardRepository.findById(1L).get(), savedEmail);
        userService.saveUser(user);
        return user;
    }
}
