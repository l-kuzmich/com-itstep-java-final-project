package model;

import java.util.Scanner;

public class Book {

    Scanner scanner = new Scanner(System.in);

    private long id;
    private String title;
    private String author;
    private int yearOfRelease;
    private String genre;
    private int countOfPages;
    private double price;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle() {
        System.out.print("Title: ");
        this.title = scanner.nextLine();
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor() {
        System.out.print("Author: ");
        this.author = scanner.nextLine();
    }

    public int getYearOfRelease() {
        return yearOfRelease;
    }

    public void setYearOfRelease() {
        System.out.print("Year of release: ");
        this.yearOfRelease = scanner.nextInt();
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre() {
        System.out.print("Genre: ");
        this.genre = scanner.nextLine();
    }

    public int getCountOfPages() {
        return countOfPages;
    }

    public void setCountOfPages() {
        System.out.print("Pages: ");
        this.countOfPages = scanner.nextInt();
    }

    public double getPrice() {
        return price;
    }

    public void setPrice() {
        System.out.print("Price: ");
        this.price = scanner.nextDouble();
    }
}
