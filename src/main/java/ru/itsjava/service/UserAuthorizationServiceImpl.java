package ru.itsjava.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.itsjava.repository.DiscountCardRepository;
import ru.itsjava.repository.EmailRepository;
import ru.itsjava.repository.UserRepository;
import ru.itsjava.domain.Email;
import ru.itsjava.domain.User;

@RequiredArgsConstructor
@Service
public class UserAuthorizationServiceImpl implements UserAuthorizationService {
    private final UserService userService;
    private final EmailService emailService;
    private final ScannerService scannerService;
    private final DiscountCardRepository discountCardRepository;

    @Transactional
    @Override
    public User authorization(String email) {
        Email foundEmailByName;
        if (emailService.findByEmailName(email).isEmpty()) {
            foundEmailByName = emailService.saveEmail(new Email(0L, email));
        } else foundEmailByName = emailService.findByEmailName(email).get();
        if (userService.findUserByEmail(foundEmailByName).isEmpty()) {
            return addUser();
        }
        return userService.findUserByEmail(foundEmailByName).get();
    }

    @Transactional
    @Override
    public User addUser() {
        System.out.println("Enter your name");
        String name = scannerService.scannerStart();
        System.out.println("Enter your email");
        String email = scannerService.scannerStart();

        User user = new User(0L, name, discountCardRepository.findById(1L).get(),
                emailService.saveEmail(new Email(0L, email)));
        userService.saveUser(user);
        return user;
    }
}
