DROP TABLE IF EXISTS books;

CREATE TABLE books
(
    id       INT AUTO_INCREMENT PRIMARY KEY,
    author   VARCHAR(250) NOT NULL,
    title    VARCHAR(250) NOT NULL,
    priceOld VARCHAR(250) DEFAULT NULL,
    price    VARCHAR(250) DEFAULT NULL
);

DROP TABLE IF EXISTS authors;

CREATE TABLE authors
(
    id       INT AUTO_INCREMENT PRIMARY KEY,
    firstname           VARCHAR(250) NOT NULL,
    secondname          VARCHAR(250) NOT NULL,
    UNIQUE (firstname, secondname)
);