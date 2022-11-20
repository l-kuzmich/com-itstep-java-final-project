package model;

import java.time.LocalDate;
import java.util.Scanner;

public class Order {

    Scanner scanner = new Scanner(System.in);
    private long employeeId;
    private long customerId;
    private long bookId;
    private LocalDate purchaseDate;
    private int booksCount;
    private double price;

    public long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId() {
        System.out.print("Employee id: ");
        this.employeeId = scanner.nextLong();
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId() {
        System.out.print("Customer id: ");
        this.customerId = scanner.nextLong();
    }

    public long getBookId() {
        return bookId;
    }

    public void setBookId() {
        System.out.print("Book id: ");
        this.bookId = scanner.nextLong();
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate() {
        System.out.print("Date (yyyy mm dd): ");
        this.purchaseDate = LocalDate.of(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
    }

    public int getBooksCount() {
        return booksCount;
    }

    public void setBookCount() {
        System.out.print("Product count: ");
        this.booksCount = scanner.nextInt();
    }

    public double getPrice() {
        return price;
    }

    public void setPrice() {
        System.out.print("Total price: ");
        this.price = scanner.nextDouble();
    }
}
