INSERT INTO DISCOUNT_CARDS(ID, COLOR, DISCOUNT)
VALUES (1, 'white', 0),
       (2, 'black', 5);

INSERT INTO EMAILS(ID, NAME)
VALUES (1, 'Bob@email.com'),
       (2,'Kate@mail.ru');

INSERT INTO USERS(ID, NAME, DISCOUNT_CARD_ID, EMAIL_ID)
VALUES (1, 'Bob', 1, 1),
       (2, 'Kate', 2, 2);

INSERT INTO COFFEES(ID, NAME, PRICE)
VALUES (1, 'Americano', 100),
       (2, 'Latte', 200),
       (3, 'Cappuccino', 150),
       (4, 'Espresso', 50);