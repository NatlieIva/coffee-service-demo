package ru.itsjava.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itsjava.repository.EmailRepository;
import ru.itsjava.domain.Email;
import ru.itsjava.domain.User;

@Service
@AllArgsConstructor
public class CoffeeHouseImpl implements CoffeeHouse {
    private final CoffeeService coffeeService;
    private final ScannerService scannerService;
    private final UserAuthorizationService userAuthorizationService;
    private final DiscountCalculationService discountCalculation;
    private final EmailService emailService;

    @Override
    public void coffeeSale() {
        System.out.println("Hello, enter your email, please");
        String emailRequest = scannerService.scannerStart();


        System.out.println("What price do you want coffee?");
        System.out.println("Americano - 100.0" + '\n'
                + "Latte - 200.0" + '\n'
                + "Cappuccino - 150.0" + '\n'
                + "Espresso - 50.0");

        int priceRequest = Integer.parseInt(scannerService.scannerStart());
//        Email foundEmailByName = emailService.findByEmailName(emailRequest);
//        User foundUserByEmail = userAuthorizationService.authorization(foundEmailByName);
        User foundUserByEmail = userAuthorizationService.authorization(emailRequest);

        System.out.println(coffeeService.findByPrice(priceRequest).get() + " for you");
        System.out.println("With your discount for pay: " + discountCalculation.calculate(foundUserByEmail,
                priceRequest));
    }
}
