package ru.itsjava.dao;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Repository;
import ru.itsjava.domain.DiscountCard;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class DiscountCardJdbcImpl implements DiscountCardDao {
    private final JdbcOperations jdbcOperations;

    @Override
    public int countDiscountCard() {
        return jdbcOperations.queryForObject("select count(*) from discount_card", Integer.class);

    }

    @Override
    public void insertDiscountCard(DiscountCard discountCard) {
        jdbcOperations.update("insert into discount_card(id,color,discount) values (?,?,?)",
                discountCard.getId(), discountCard.getColor(), discountCard.getDiscount());
    }

    @Override
    public void deleteDiscountCard(DiscountCard discountCard) {
        jdbcOperations.update("delete from discount_card  where id = ?",
                discountCard.getId());
    }

    @Override
    public void updateDiscountCard(DiscountCard discountCard) {
        jdbcOperations.update("update discount_card set color = ?",
                discountCard.getColor());
    }

    @Override
    public String getColor(int id) {
        return jdbcOperations.queryForObject("select color from discount_card where id = ?", String.class, id);
    }
}
