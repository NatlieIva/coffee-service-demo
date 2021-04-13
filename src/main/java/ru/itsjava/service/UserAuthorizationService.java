package ru.itsjava.service;

import ru.itsjava.domain.Email;
import ru.itsjava.domain.User;

public interface UserAuthorizationService {
    User authorization(String email);

    User addUser();
}
