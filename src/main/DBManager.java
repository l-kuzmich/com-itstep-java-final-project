import model.Book;
import model.Customer;
import model.Employee;
import model.Order;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBManager {
    ConnectionToDB connectionToDB = new ConnectionToDB();

    public void insertBook(Book book) {
        try {
            Connection connection = connectionToDB.getConnection();
            PreparedStatement insert = connection.prepareStatement("INSERT book (Id, Title, Author, YearOFRelease, Genre, CountOfPage, Price) values ('" +
                    book.getId() + "', '" +
                    book.getTitle() + "', '" +
                    book.getAuthor() + "', '" +
                    book.getYearOfRelease() + "', '" +
                    book.getGenre() + "', '" +
                    book.getCountOfPages() + "', '" +
                    book.getPrice() + "')");

            insert.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Book successfully added\n");
        }
    }

    public void insertCustomer(Customer customer){
        try {
            Connection connection = connectionToDB.getConnection();
            PreparedStatement insert = connection.prepareStatement("INSERT customer (Id, Name, Age) values ('" +
                    customer.getId() + "', '" +
                    customer.getName() + "', '" +
                    customer.getAge() +  "')");

            insert.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Customer successfully added\n");
        }
    }

    public void insertEmployee(Employee employee){
        try {
            Connection connection = connectionToDB.getConnection();
            PreparedStatement insert = connection.prepareStatement("INSERT employee (Id, Name, Age, Post) values ('" +
                    employee.getId() + "', '" +
                    employee.getName() + "', '" +
                    employee.getAge() + "', '" +
                    employee.getPost() +  "')");

            insert.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Employee successfully added\n");
        }
    }

    public void insertOrder(Order order){
        try {
            Connection connection = connectionToDB.getConnection();
            PreparedStatement insert = connection.prepareStatement("INSERT orders (employeeid, customerid, bookid, purchasedate, bookscount, price) values ('" +
                    order.getEmployeeId() + "', '" +
                    order.getCustomerId() + "', '" +
                    order.getBookId() + "', '" +
                    order.getPurchaseDate() + "', '" +
                    order.getBooksCount() + "', '" +
                    order.getPrice() +  "')");

            insert.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Order successfully added\n");
        }
    }


    public void showBooks(){
        try {
            Connection connection = connectionToDB.getConnection();
            PreparedStatement showBook = connection.prepareStatement("Select * from book");
            ResultSet rs = showBook.executeQuery();

            while (rs.next()) {
                System.out.println(rs.getString(1));
                System.out.println(rs.getString(2));
                System.out.println(rs.getString(3));
                System.out.println(rs.getString(4));
                System.out.println(rs.getString(5));
                System.out.println(rs.getString(6));
                System.out.println(rs.getString(7));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void deleteBookById(String fromTable, int id){
        try {
            Connection connection = connectionToDB.getConnection();
            PreparedStatement deleteItem = connection.prepareStatement("Delete from " + fromTable + " WHERE Id = '" + id + "'");
            deleteItem.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("One book successfully deleted\n");
        }
    }

}
