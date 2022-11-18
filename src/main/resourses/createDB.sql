CREATE DATABASE IF NOT exists bookstore;

USE bookstore;

CREATE TABLE Book
(
    Id INT primary key auto_increment,
    Title VARCHAR(20),
    Author VARCHAR(20),
    YearOFRelease year,
    Genre VARCHAR(20),
    CountOfPage int,
    Price double
);

INSERT book (Title, Author, YearOFRelease, Genre, CountOfPage, Price)
values
    ('The Alchemist', 'Paulo Coelho', '1988', 'Novel', 163, 869.3),
    ('The Great Gatsby', 'F. Scott Fitzgerald', '1925', 'History', 180, 994),
    ('The Grapes of Wrath', 'John Steinbeck', '1939', 'History', 455, 963),
    ('One Hundred Years of Solitude', 'Gabriel García Márquez', '1967', 'Fantasy', 432, 667)
