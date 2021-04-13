package ru.itsjava.service;

import ru.itsjava.domain.Email;

import java.util.Optional;

public interface EmailService {

    Email saveEmail(Email email);

    void deleteEmailById(long id);

    void updateEmail(Email email);

    Optional<Email> findById(long id);

    Optional<Email> findByEmailName(String emailName);
}
