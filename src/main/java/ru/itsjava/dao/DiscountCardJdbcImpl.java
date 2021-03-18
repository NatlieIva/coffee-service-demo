package ru.itsjava.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Repository;
import ru.itsjava.domain.DiscountCard;

@Repository
@RequiredArgsConstructor
public class DiscountCardJdbcImpl implements DiscountCardDao{
    private final JdbcOperations jdbcOperations;

    @Override
    public int countDiscountCard() {
        return jdbcOperations.queryForObject("select count(*) from discount_card", Integer.class);

    }

    @Override
    public void insertDiscountCard(DiscountCard discountCard) {
        jdbcOperations.update("insert into discount_card(id,color,discount) values (?,?,?)",
                discountCard.getId(), discountCard.getColor(),discountCard.getDiscount());
    }

    @Override
    public void deleteDiscountCard(DiscountCard discountCard) {
        jdbcOperations.update("delete from discount_card  where id = ?",
                discountCard.getId());
    }

    @Override
    public void updateDiscountCard(DiscountCard discountCard) {
        jdbcOperations.update("update discount_card set color = ? and set discount = ?",
                discountCard.getColor(), discountCard.getDiscount());
    }
}
