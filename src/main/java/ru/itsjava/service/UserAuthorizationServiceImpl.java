package ru.itsjava.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itsjava.dao.DiscountCardDao;
import ru.itsjava.dao.EmailDao;
import ru.itsjava.dao.UserDao;
import ru.itsjava.domain.DiscountCard;
import ru.itsjava.domain.Email;
import ru.itsjava.domain.User;

import javax.persistence.Query;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserAuthorizationServiceImpl implements UserAuthorizationService {
    private final UserDao userDao;
    private final EmailDao emailDao;
    private final ScannerService scannerService;
    private final DiscountCardDao discountCardDao;

    @Override
    public User authorization(Email email ) {
//        if (userDao.findUserByEmail(email).isEmpty())
//           addUser();
        return userDao.findUserByEmail(email).get();
    }

    @Override
    public void addUser() {
//        System.out.println("Enter your name");
//        String name = scannerService.scannerStart();
//        System.out.println("Enter your email");
//        String email = scannerService.scannerStart();
//
//        userDao.saveUser(user);
    }
}
