DROP TABLE IF EXISTS PERSON;
CREATE TABLE PERSON (
    id IDENTITY NOT NULL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    surname VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL
);