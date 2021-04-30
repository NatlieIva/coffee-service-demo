DROP TABLE IF EXISTS DISCOUNT_CARDS, USERS, EMAILS;

CREATE TABLE DISCOUNT_CARDS
(
    id INT PRIMARY KEY AUTO_INCREMENT,
    color VARCHAR(256),
    discount INT
);

CREATE TABLE EMAILS
(
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    email_name VARCHAR(256)

);

CREATE TABLE USERS
(
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(256),
    discount_card_id BIGINT,
    email_id BIGINT
);

CREATE TABLE COFFEES
(
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(256),
    price DOUBLE
);

ALTER TABLE USERS ADD FOREIGN KEY (discount_card_id) REFERENCES DISCOUNT_CARDS(id);
ALTER TABLE USERS ADD FOREIGN KEY (email_id) REFERENCES EMAILS(id);
