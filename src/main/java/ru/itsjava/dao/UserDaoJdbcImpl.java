package ru.itsjava.dao;

import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import ru.itsjava.domain.DiscountCard;
import ru.itsjava.domain.Email;
import ru.itsjava.domain.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserDaoJdbcImpl implements UserDao {
    private final NamedParameterJdbcOperations namedParameterJdbcOperations;

    @Override
    public int countUser() {
        return namedParameterJdbcOperations
                .getJdbcOperations()
                .queryForObject("select count(*) from users", Integer.class);
    }

    @Override
    public long insertUser(User user) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        val parameters = new MapSqlParameterSource();
        parameters.addValue("name", user.getName());
        parameters.addValue("discountCardId", user.getDiscountCard().getId());
        parameters.addValue("emailId", user.getEmail().getId());

        namedParameterJdbcOperations
                .update("insert into users(name, discount_card_id, email_id) values (:name, :discountCardId, :emailId)",
                        parameters, keyHolder);
        return keyHolder.getKey().longValue();
    }

    @Override
    public void deleteUser(int id) {
        namedParameterJdbcOperations
                .getJdbcOperations()
                .update("delete from users  where id = ?",
                        id);
    }

    @Override
    public void updateUser(User user, int newDiscountCardId) {
        val parameters = new MapSqlParameterSource();
        parameters.addValue("id", user.getId());
        parameters.addValue("discount_card_id", newDiscountCardId);
        namedParameterJdbcOperations
                .update("update users set discount_card_id = :discount_card_id where id = :id",
                        parameters);
    }

    @Override
    public Optional<User> findById(int id) {
        try {
            return Optional.of(namedParameterJdbcOperations.queryForObject(
                    "select u.id, u.name, d.id, d.color, d.discount, e.id, e.name from discount_cards d, users u, emails e where u.id = :id and u.discount_card_id = d.id and u.email_id = e.id", Map.of("id", id),
                    new UserMapper()));
        } catch (EmptyResultDataAccessException exception) {
            return Optional.empty();
        }
    }

    private static class UserMapper implements RowMapper<User> {

        @Override
        public User mapRow(ResultSet resultSet, int i) throws SQLException {
            int idUser = resultSet.getInt("users.id");
            String nameUser = resultSet.getString("users.name");
            int idDiscountCard = resultSet.getInt("discount_cards.id");
            String colorDiscountCard = resultSet.getString("discount_cards.color");
            int discount = resultSet.getInt("discount_cards.discount");
            int idEmail = resultSet.getInt("emails.id");
            String nameEmail = resultSet.getString("emails.name");

            DiscountCard discountCard = new DiscountCard(idDiscountCard, colorDiscountCard, discount);
            Email email = new Email(idEmail, nameEmail);
            return new User(idUser, nameUser, discountCard, email);
        }
    }
}
