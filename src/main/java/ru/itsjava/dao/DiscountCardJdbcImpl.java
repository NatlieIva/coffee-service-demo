package ru.itsjava.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.itsjava.domain.DiscountCard;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class DiscountCardJdbcImpl implements DiscountCardDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @Override
    public DiscountCard saveDiscountCard(DiscountCard discountCard) {
        if (discountCard.getId() == 0L) {
            entityManager.persist(discountCard);
            return discountCard;
        }
        return entityManager.merge(discountCard);
    }

    @Transactional
    @Override
    public void deleteDiscountCardById(long id) {
        DiscountCard deletedDiscountCard = entityManager.find(DiscountCard.class, id);
        entityManager.remove(deletedDiscountCard);
    }

    @Transactional
    @Override
    public void updateDiscountCard(DiscountCard discountCard) {
        entityManager.merge(discountCard);
    }

    @Transactional(readOnly = true)
    public Optional<DiscountCard> findById(long id) {
        return Optional.ofNullable(entityManager.find(DiscountCard.class, id));
    }
}
