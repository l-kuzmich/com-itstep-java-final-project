CREATE DATABASE IF NOT exists bookstore;

USE bookstore;

CREATE TABLE Book
(
    Id            INT primary key auto_increment,
    Title         VARCHAR(40),
    Author        VARCHAR(40),
    YearOFRelease year,
    Genre         VARCHAR(20),
    CountOfPage   int,
    Price         double
);

INSERT Book (Title, Author, YearOFRelease, Genre, CountOfPage, Price)
values ('The Alchemist', 'Paulo Coelho', '1988', 'Novel', 163, 869.3),
       ('The Great Gatsby', 'F. Scott Fitzgerald', '1925', 'History', 180, 994),
       ('The Grapes of Wrath', 'John Steinbeck', '1939', 'History', 455, 963),
       ('One Hundred Years of Solitude', 'Gabriel García Márquez', '1967', 'Fantasy', 432, 667),
       ('Gone Girl', 'Gillian Flynn', '2014', 'Novel', 464, 200),
       ('Sharp Objects', 'Gillian Flynn', '2007', 'Thriller', 354, 140);

CREATE TABLE Customer
(
    Id   INT primary key auto_increment,
    Name VARCHAR(30),
    Age  int
);

INSERT Customer (Name, Age)
values ('Mari Remnant', 34),
       ('Dani Richardson', 32);

CREATE TABLE Employee
(
    Id   INT primary key auto_increment,
    Name VARCHAR(30),
    Age  int,
    Post VARCHAR(20)
);

INSERT Employee (Name, Age, Post)
values ('Liza Dyson', 25, 'Manager'),
       ('Kate Fisher', 43, 'Seller'),
       ('Darrel Wilson', 23, 'Seller');

CREATE TABLE Orders
(
    Id           INT primary key auto_increment,
    EmployeeId   int,
    CustomerId   int,
    BookId       int,
    PurchaseDate date,
    BooksCount   int,
    Price        double
);

INSERT INTO Orders (EmployeeId, CustomerId, BookId, PurchaseDate, BooksCount, Price)
values ((SELECT Id from Employee where Name = 'Kate Fisher'),
        (SELECT Id from Customer where Name = 'Mari Remnant'),
        (SELECT Id from Book where Title = 'The Alchemist'), '2022-11-20', 1,
        (SELECT Price from Book where Title = 'The Alchemist'))



