package ru.itsjava.service;

import ru.itsjava.domain.Email;
import ru.itsjava.domain.User;

import java.util.Optional;

public interface UserAuthorizationService {
    User authorization(Email email);
    void addUser();
}
