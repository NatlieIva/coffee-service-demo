package ru.itsjava.dao;

import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import ru.itsjava.domain.DiscountCard;
import ru.itsjava.domain.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class DiscountCardJdbcImpl implements DiscountCardDao {
    private final NamedParameterJdbcOperations namedParameterJdbcOperations;

    @Override
    public int countDiscountCard() {
        return namedParameterJdbcOperations
                .getJdbcOperations()
                .queryForObject("select count(*) from discount_cards", Integer.class);
    }

    @Override
    public long insertDiscountCard(DiscountCard discountCard) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        val parameters = new MapSqlParameterSource();
        parameters.addValue("color", discountCard.getColor());
        parameters.addValue("discount", discountCard.getDiscount());

        namedParameterJdbcOperations
                .update("insert into discount_cards(color, discount) values (:color, :discount)",
                        parameters, keyHolder);
        return keyHolder.getKey().longValue();
    }

    @Override
    public void deleteDiscountCard(DiscountCard discountCard) {
        namedParameterJdbcOperations
                .getJdbcOperations()
                .update("delete from discount_cards  where id = ?",
                        discountCard.getId());
    }

    @Override
    public void updateDiscountCard(DiscountCard discountCard, String color, int discount) {
        val parameters = new MapSqlParameterSource();
        parameters.addValue("id", discountCard.getId());
        parameters.addValue("color", color);
        parameters.addValue("discount", discount);
        namedParameterJdbcOperations
                .update("update discount_cards set color = :color where id = :id",
                        parameters);
        namedParameterJdbcOperations
                .update("update discount_cards set discount = :discount where id = :id",
                        parameters);
    }

    @Override
    public Optional<DiscountCard> findById(int id) {
        try {
            return Optional.of(namedParameterJdbcOperations.queryForObject(
                    "select d.id, d.color, d.discount from discount_cards d where d.id = :id", Map.of("id", id),
                    new DiscountCardMapper()));
        } catch (EmptyResultDataAccessException exception) {
            return Optional.empty();
        }
    }

    private class DiscountCardMapper implements RowMapper<DiscountCard> {

        @Override
        public DiscountCard mapRow(ResultSet resultSet, int i) throws SQLException {
            int discountCardId = resultSet.getInt("discount_cards.id");
            String discountCardColor = resultSet.getString("discount_cards.color");
            int discount = resultSet.getInt("discount_cards.discount");

            return new DiscountCard(discountCardId, discountCardColor, discount);
        }
    }
}
