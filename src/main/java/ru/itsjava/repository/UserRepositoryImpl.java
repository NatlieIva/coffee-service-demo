package ru.itsjava.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.itsjava.domain.Email;
import ru.itsjava.domain.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;


@RequiredArgsConstructor
@Repository
public class UserRepositoryImpl implements UserRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public User saveUser(User user) {
        if (user.getId() == 0L) {
            entityManager.persist(user);
            return user;
        }
        return entityManager.merge(user);
    }

    @Override
    public void deleteUserById(long id) {
        User deletedUser = entityManager.find(User.class, id);
        entityManager.remove(deletedUser);
    }

    @Override
    public void updateUser(User user) {
        entityManager.merge(user);
    }

    @Override
    public Optional<User> findUserById(long id) {
        return Optional.ofNullable(entityManager.find(User.class, id));
    }

    @Override
    public Optional<User> findUserByEmail(Email email) {
        Query queryUser = entityManager.createQuery("select id from users where email = :email");
        queryUser.setParameter("email", email);
        List resultList = queryUser.getResultList();
        if (resultList.isEmpty()) {
            return Optional.empty();
        } else {
            Long foundUserId = (Long) resultList.get(0);
            User foundUser = entityManager.find(User.class, foundUserId);
            return Optional.ofNullable(foundUser);
        }
    }
}
