INSERT INTO DISCOUNT_CARDS(ID, COLOR, DISCOUNT)
VALUES (1, 'white', 10);

INSERT INTO EMAILS(ID, EMAIL_NAME)
VALUES (1, 'Bob@email.com');

INSERT INTO USERS(ID, NAME, DISCOUNT_CARD_ID, EMAIL_ID)
VALUES (1, 'Bob', 1, 1);

INSERT INTO COFFEES(ID, NAME, PRICE)
VALUES (1, 'Americano', 100),
       (2, 'Latte', 200);