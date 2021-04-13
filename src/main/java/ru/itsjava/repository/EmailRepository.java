package ru.itsjava.repository;


import ru.itsjava.domain.Email;

import java.util.Optional;

public interface EmailRepository {
    Email saveEmail(Email email);

    void deleteEmailById(long id);

    void updateEmail(Email email);

    Optional<Email> findById(long id);

    Optional<Email> findByEmailName(String emailName);
}
