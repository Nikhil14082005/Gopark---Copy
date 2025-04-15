CREATE DATABASE gopark;
USE gopark;

CREATE TABLE booking (
    name VARCHAR(100),
    city VARCHAR(50),
    parking_place VARCHAR(100),
    date DATE,
    spots INT,
    entry_time TIME,
    leaving_time TIME
);

CREATE TABLE checkout (
    name VARCHAR(100),
    card_number VARCHAR(16),
    card_type VARCHAR(20),
    exp_date DATE,
    cvv INT
);
