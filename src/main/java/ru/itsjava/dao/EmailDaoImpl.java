package ru.itsjava.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.itsjava.domain.Coffee;
import ru.itsjava.domain.Email;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Optional;

@Repository
public class EmailDaoImpl implements EmailDao{
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @Override
    public Email saveEmail(Email email) {
        if (email.getId() == 0L) {
            entityManager.persist(email);
            return email;
        }
        return entityManager.merge(email);
    }

    @Transactional
    @Override
    public void deleteEmailById(long id) {
        Email deletedEmail = entityManager.find(Email.class, id);
        entityManager.remove(deletedEmail);
    }

    @Transactional
    @Override
    public void updateEmail(Email email) {
        entityManager.merge(email);
    }

    @Transactional
    @Override
    public Optional<Email> findById(long id) {
        return Optional.ofNullable(entityManager.find(Email.class, id));
    }

    @Override
    public Optional<Email> findByEmailName(String emailName) {
        Query query = entityManager.createQuery("select id from emails where email_name = :email_name");
        query.setParameter("email_name", emailName);
        Long foundEmailId = (Long) query.getSingleResult();
        Email foundEmail = entityManager.find(Email.class, foundEmailId);
        return Optional.ofNullable(foundEmail);
    }
}
