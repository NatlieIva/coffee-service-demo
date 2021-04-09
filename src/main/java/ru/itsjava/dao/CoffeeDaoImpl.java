package ru.itsjava.dao;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.itsjava.domain.Coffee;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Optional;


@RequiredArgsConstructor
@Getter
@Repository
public class CoffeeDaoImpl implements CoffeeDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional(readOnly = true)
    @Override
    public Optional<Coffee> findByPrice(int price) {
        Query query = entityManager.createQuery("select id from coffees where price = :price");
        query.setParameter("price", price);
        Long foundCoffeeId = (Long) query.getSingleResult();
        Coffee foundCoffee = entityManager.find(Coffee.class, foundCoffeeId);
            return Optional.ofNullable(foundCoffee);
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Coffee> findById(long id) {
        return Optional.ofNullable(entityManager.find(Coffee.class, id));
    }

    @Transactional
    @Override
    public Coffee saveCoffee(Coffee coffee) {
        if (coffee.getId() == 0L) {
            entityManager.persist(coffee);
            return coffee;
        }
        return entityManager.merge(coffee);
    }

    @Transactional
    @Override
    public void deleteCoffeeById(long id) {
        Coffee deleteCoffee = entityManager.find(Coffee.class, id);
        entityManager.remove(deleteCoffee);
    }

    @Transactional
    @Override
    public void updateCoffee(Coffee coffee) {
        entityManager.merge(coffee);
    }
}
