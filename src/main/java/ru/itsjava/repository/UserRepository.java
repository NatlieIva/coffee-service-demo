package ru.itsjava.repository;

import ru.itsjava.domain.Email;
import ru.itsjava.domain.User;

import java.util.Optional;

public interface UserRepository {
//    int countUser();

    User saveUser(User user);

    void deleteUserById(long id);

    void updateUser(User user);

    Optional<User> findUserById(long id);

    Optional<User> findUserByEmail(Email email);


}
