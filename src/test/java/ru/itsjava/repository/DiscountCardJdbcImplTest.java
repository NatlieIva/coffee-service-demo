//package ru.itsjava.dao;
//
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
//import org.springframework.context.annotation.Import;
//import ru.itsjava.domain.DiscountCard;
//
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//@JdbcTest
//@Import (DiscountCardJdbcImpl.class)
//public class DiscountCardJdbcImplTest {
//
//    private final static DiscountCard DISCOUNT_CARD =
//            new DiscountCard(3L, "gold", 10);
//
//    @Autowired
//    private DiscountCardDao discountCardJdbc;
//
//    @Test
//    public void shouldHaveCorrectInsert() {
//        int countBeforeInsert = discountCardJdbc.countDiscountCard();
//        discountCardJdbc.saveDiscountCard(DISCOUNT_CARD);
//        int countAfterInsert = discountCardJdbc.countDiscountCard();
//
//        Optional<DiscountCard> optionalDiscountCard = discountCardJdbc.findById(3L);
//        Assertions.assertAll(()-> assertEquals(countBeforeInsert + 1, countAfterInsert),
//                optionalDiscountCard::isPresent,
//                () -> assertEquals(DISCOUNT_CARD, optionalDiscountCard.get()));
//    }
//
//    @Test
//    public void shouldHaveCorrectDelete() {
//        discountCardJdbc.saveDiscountCard(DISCOUNT_CARD);
//        int countAfterInsert = discountCardJdbc.countDiscountCard();
//        discountCardJdbc.deleteById(DISCOUNT_CARD);
//        int countAfterDelete = discountCardJdbc.countDiscountCard();
//
//        Optional<DiscountCard> optionalDiscountCard = discountCardJdbc.findById(3L);
//        Assertions.assertAll(()-> assertEquals(countAfterInsert - 1, countAfterDelete),
//                optionalDiscountCard::isEmpty);
////        Если в методе использовать Map.of(), то ошибка с просьбой указать delete ANY, ALL
//    }
//
//    @Test
//    public void shouldHaveCorrectUpdate() {
//        discountCardJdbc.saveDiscountCard(DISCOUNT_CARD);
//
//        DiscountCard updatedDiscountCard = new DiscountCard(3L, "diamond", 15);
//        discountCardJdbc.updateDiscountCard(DISCOUNT_CARD);
//
//        assertEquals(DISCOUNT_CARD.getColor(), updatedDiscountCard.getColor());
//    }
//
//    @Test
//    public void shouldCorrectFindById(){
//        DiscountCard foundDiscountCard = discountCardJdbc.findById(2L).get();
//
//        assertEquals(foundDiscountCard, new DiscountCard(2L, "black", 5));
//    }
//}
//
