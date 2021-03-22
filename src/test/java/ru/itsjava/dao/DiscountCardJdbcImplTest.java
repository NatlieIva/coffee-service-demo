//package ru.itsjava.dao;
//
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
//import org.springframework.context.annotation.Import;
//import ru.itsjava.domain.DiscountCard;
//
//@JdbcTest
//@Import (DiscountCardJdbcImpl.class)
//public class DiscountCardJdbcImplTest {
//
//    @Autowired
//    private DiscountCardDao discountCardJdbc;
//
//    @Test
//    public void shouldHaveCorrectInsert() {
//        int countBeforeInsert = discountCardJdbc.countDiscountCard();
//        discountCardJdbc.insertDiscountCard(new DiscountCard(4, "gold", 10));
//        int countAfterInsert = discountCardJdbc.countDiscountCard();
//
//        Assertions.assertEquals(countBeforeInsert + 1, countAfterInsert);
//    }
//
//    @Test
//    public void shouldHaveCorrectDelete() {
//
//        DiscountCard discountCard = new DiscountCard(4, "gold", 10);
//
//        discountCardJdbc.insertDiscountCard(discountCard);
//        int countAfterInsert = discountCardJdbc.countDiscountCard();
//        discountCardJdbc.deleteDiscountCard(discountCard);
//        int countAfterDelete = discountCardJdbc.countDiscountCard();
//
//        Assertions.assertEquals(countAfterInsert - 1, countAfterDelete);
//    }
//
//    @Test
//    public void shouldHaveCorrectUpdate() {
//        DiscountCard discountCard = new DiscountCard(4, "gold", 10);
//        discountCardJdbc.insertDiscountCard(discountCard);
//
//        DiscountCard newDiscountCard = new DiscountCard(4, "diamond", 15);
//        discountCardJdbc.updateDiscountCard(discountCard, newDiscountCard.getColor(),newDiscountCard.getDiscount());
//
//        Assertions.assertEquals(discountCard.getColor(), newDiscountCard.getColor());
//    }
//}
//
