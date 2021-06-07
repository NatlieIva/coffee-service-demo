package ru.itsjava.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.itsjava.domain.DiscountCard;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class DiscountCardRepositoryImpl implements DiscountCardRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public DiscountCard saveDiscountCard(DiscountCard discountCard) {
        if (discountCard.getId() == 0L) {
            entityManager.persist(discountCard);
            return discountCard;
        }
        return entityManager.merge(discountCard);
    }

    @Override
    public void deleteDiscountCardById(long id) {
        DiscountCard deletedDiscountCard = entityManager.find(DiscountCard.class, id);
        entityManager.remove(deletedDiscountCard);
    }

    @Override
    public void updateDiscountCard(DiscountCard discountCard) {
        entityManager.merge(discountCard);
    }

    public Optional<DiscountCard> findById(long id) {
        return Optional.ofNullable(entityManager.find(DiscountCard.class, id));
    }

    @Override
    public List<DiscountCard> getAll() {
        TypedQuery<DiscountCard> query = entityManager.createQuery("select d " +
                "from discount_cards d", DiscountCard.class);
        return query.getResultList();
    }
}
