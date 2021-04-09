package ru.itsjava.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.itsjava.domain.Coffee;
import ru.itsjava.domain.Email;
import ru.itsjava.domain.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Optional;


@RequiredArgsConstructor
@Repository
public class UserDaoJdbcImpl implements UserDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @Override
    public User saveUser(User user) {
        if (user.getId() == 0L) {
            entityManager.persist(user);
            return user;
        }
        return entityManager.merge(user);
    }

    @Transactional
    @Override
    public void deleteUserById(long id) {
        User deletedUser = entityManager.find(User.class, id);
        entityManager.remove(deletedUser);
    }

    @Transactional
    @Override
    public void updateUser(User user) {
        entityManager.merge(user);
    }

    @Transactional
    @Override
    public Optional<User> findUserById(long id) {
        return Optional.ofNullable(entityManager.find(User.class, id));
    }

    @Override
    public Optional<User> findUserByEmail(Email email) {
        Query query = entityManager.createQuery("select userId from emails where name = :email");
        query.setParameter("name", email);
        Long foundUserId = (Long) query.getSingleResult();
        User foundUser= entityManager.find(User.class, foundUserId);
        return Optional.ofNullable(foundUser);
    }
}
