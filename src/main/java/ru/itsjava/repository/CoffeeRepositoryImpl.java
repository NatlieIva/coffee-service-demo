package ru.itsjava.repository;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.itsjava.domain.Coffee;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
@Getter
public class CoffeeRepositoryImpl implements CoffeeRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Optional<Coffee> findByPrice(double price) {
        Query query = entityManager.createQuery("select id from coffees where price = :price");
        query.setParameter("price", price);
        Long foundCoffeeId = (Long) query.getSingleResult();
        Coffee foundCoffee = entityManager.find(Coffee.class, foundCoffeeId);
            return Optional.ofNullable(foundCoffee);
    }

    @Override
    public Optional<Coffee> findById(long id) {
        return Optional.ofNullable(entityManager.find(Coffee.class, id));
    }

    @Override
    public Coffee saveCoffee(Coffee coffee) {
        if (coffee.getId() == 0L) {
            entityManager.persist(coffee);
            return coffee;
        }
        return entityManager.merge(coffee);
    }

    @Override
    public void deleteCoffeeById(long id) {
        Coffee deleteCoffee = entityManager.find(Coffee.class, id);
        entityManager.remove(deleteCoffee);
    }

    @Override
    public void updateCoffee(Coffee coffee) {
        entityManager.merge(coffee);
    }
}
