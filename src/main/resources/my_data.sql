INSERT INTO DISCOUNT_CARDS(ID, COLOR, DISCOUNT)
VALUES (1, 'white', 0),
       (2, 'black', 5),
       (3, 'gold', 10);

INSERT INTO EMAILS(ID, NAME)
VALUES (1, 'Bob@email.com'),
       (2, 'Jack@email.com');

INSERT INTO USERS(ID, NAME, DISCOUNT_CARD_ID, EMAIL_ID)
VALUES (1, 'Bob', 1, 1),
       (2, 'Jack', 3, 2);

INSERT INTO PRICES(ID, VALUE)
VALUES (1, 100.0),
       (2, 200.0),
       (3, 150.0),
       (4, 50.0);

INSERT INTO COFFEES(ID, NAME, PRICE_ID)
VALUES (1, 'Americano', 1),
       (2, 'Latte', 2),
       (3, 'Cappuccino', 3),
       (4, 'Espresso', 4);