package ru.itsjava.repository;

import org.springframework.stereotype.Repository;
import ru.itsjava.domain.Email;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

@Repository
public class EmailRepositoryImpl implements EmailRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Email saveEmail(Email email) {
        if (email.getId() == 0L) {
            entityManager.persist(email);
            return email;
        }
        return entityManager.merge(email);
    }

    @Override
    public void deleteEmailById(long id) {
        Email deletedEmail = entityManager.find(Email.class, id);
        entityManager.remove(deletedEmail);
    }

    @Override
    public void updateEmail(Email email) {
        entityManager.merge(email);
    }

    @Override
    public Optional<Email> findById(long id) {
        return Optional.ofNullable(entityManager.find(Email.class, id));
    }

    @Override
    public Optional<Email> findByEmailName(String emailName) {
        Query query = entityManager.createQuery("select id from emails where name = :email_name");
        query.setParameter("email_name", emailName);
        List resultList = query.getResultList();
        if (resultList.isEmpty()) {
            return Optional.empty();
        } else {
            Long foundEmailId = (Long) resultList.get(0);
            Email foundEmail = entityManager.find(Email.class, foundEmailId);
            return Optional.ofNullable(foundEmail);
        }
    }
}
