package ru.itsjava.dao;

import ru.itsjava.domain.DiscountCard;
import ru.itsjava.domain.User;

import java.util.Optional;

public interface UserDao {
    int countUser();

    long insertUser(User user);

    void deleteUser(int id);

    void updateUser(User user, int discountCardId);

    Optional<User> findById(int id);
}
