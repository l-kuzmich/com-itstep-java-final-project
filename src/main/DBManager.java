import model.Book;
import model.Customer;
import model.Employee;
import model.Order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBManager {
    ConnectionToDB connectionToDB = new ConnectionToDB();

    public void insertBook(Book book) {
        try {
            Connection connection = connectionToDB.getConnection();
            PreparedStatement insert = connection.prepareStatement("INSERT book (Title, Author, YearOFRelease, Genre, CountOfPage, Price) values ('" +
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

    public void insertCustomer(Customer customer) {
        try {
            Connection connection = connectionToDB.getConnection();
            PreparedStatement insert = connection.prepareStatement("INSERT customer (Name, Age) values ('" +
                    customer.getName() + "', '" +
                    customer.getAge() + "')");

            insert.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Customer successfully added\n");
        }
    }

    public void insertEmployee(Employee employee) {
        try {
            Connection connection = connectionToDB.getConnection();
            PreparedStatement insert = connection.prepareStatement("INSERT employee (Name, Age, Post) values ('" +
                    employee.getName() + "', '" +
                    employee.getAge() + "', '" +
                    employee.getPost() + "')");

            insert.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Employee successfully added\n");
        }
    }

    public void insertOrder(Order order) {
        try {
            Connection connection = connectionToDB.getConnection();
            PreparedStatement insert = connection.prepareStatement("INSERT orders (employeeid, customerid, bookid, purchasedate, bookscount, price) values ('" +
                    order.getEmployeeId() + "', '" +
                    order.getCustomerId() + "', '" +
                    order.getBookId() + "', '" +
                    order.getPurchaseDate() + "', '" +
                    order.getBooksCount() + "', '" +
                    order.getPrice() + "')");

            insert.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Order successfully added\n");
        }
    }

    public void changeBook(Book book, int id) {
        try {
            Connection connection = connectionToDB.getConnection();
            PreparedStatement change = connection.prepareStatement("UPDATE book set " +
                    "Title = '" + book.getTitle() + "', " +
                    "Author = '" + book.getAuthor() + "', " +
                    "YearOFRelease = '" + book.getYearOfRelease() + "', " +
                    "Genre = '" + book.getGenre() + "', " +
                    "CountOfPage = '" + book.getCountOfPages() + "', " +
                    "Price = '" + book.getPrice() + "' WHERE Id = '" + id + "';");

            change.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Book successfully changed\n");
        }
    }

    public void changeCustomer(Customer customer, int id) {
        try {
            Connection connection = connectionToDB.getConnection();
            PreparedStatement change = connection.prepareStatement("UPDATE customer set " +
                    "Name = '" + customer.getName() + "', " +
                    "Age = '" + customer.getAge() + "' WHERE Id = '" + id + "';");

            change.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Customer successfully changed\n");
        }
    }

    public void changeEmployee(Employee employee, int id) {
        try {
            Connection connection = connectionToDB.getConnection();
            PreparedStatement change = connection.prepareStatement("UPDATE employee set " +
                    "Name = '" + employee.getName() + "', " +
                    "Age = '" + employee.getAge() + "', " +
                    "Post = '" + employee.getPost() +
                    "' WHERE Id = '" + id + "';");

            change.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Employee successfully changed\n");
        }
    }

    public void changeOrder(Order order, int id) {
        try {
            Connection connection = connectionToDB.getConnection();
            PreparedStatement change = connection.prepareStatement("UPDATE orders set " +
                    "EmployeeId = '" + order.getEmployeeId() + "', " +
                    "CustomerId = '" + order.getCustomerId() + "', " +
                    "BookId = '" + order.getBookId() + "', " +
                    "PurchaseDate = '" + order.getPurchaseDate() + "', " +
                    "BooksCount = '" + order.getBooksCount() + "', " +
                    "Price = '" + order.getPrice() + "' WHERE Id = '" + id + "';");

            change.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Book successfully changed\n");
        }
    }

    public void showBooks() {
        try {
            Connection connection = connectionToDB.getConnection();
            PreparedStatement showBook = connection.prepareStatement("Select * from book");
            ResultSet rs = showBook.executeQuery();

            while (rs.next()) {
                System.out.println("\nID: " + rs.getString(1));
                System.out.println("Title: " + rs.getString(2));
                System.out.println("Author: " + rs.getString(3));
                System.out.println("Year of release: " + rs.getString(4));
                System.out.println("Genre: " + rs.getString(5));
                System.out.println("Pages: " + rs.getString(6));
                System.out.println("Price: " + rs.getString(7));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void showOrders() {
        try {
            Connection connection = connectionToDB.getConnection();
            PreparedStatement showOrders = connection.prepareStatement("Select * from orders");
            ResultSet rs = showOrders.executeQuery();

            while (rs.next()) {
                System.out.println("\nID: " + rs.getString(1));
                System.out.println("Employee ID: " + rs.getString(2));
                System.out.println("Customer ID: " + rs.getString(3));
                System.out.println("Book ID: " + rs.getString(4));
                System.out.println("Date: " + rs.getString(5));
                System.out.println("Count of books: " + rs.getString(6));
                System.out.println("Total Price: " + rs.getString(7));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void showCustomers() {
        try {
            Connection connection = connectionToDB.getConnection();
            PreparedStatement showCustomers = connection.prepareStatement("Select * from customer");
            ResultSet rs = showCustomers.executeQuery();

            while (rs.next()) {
                System.out.println("\nID: " + rs.getString(1));
                System.out.println("Name: " + rs.getString(2));
                System.out.println("Age: " + rs.getString(3));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void showEmployee() {
        try {
            Connection connection = connectionToDB.getConnection();
            PreparedStatement showEmployee = connection.prepareStatement("Select * from employee");
            ResultSet rs = showEmployee.executeQuery();

            while (rs.next()) {
                System.out.println("\nID: " + rs.getString(1));
                System.out.println("Name: " + rs.getString(2));
                System.out.println("Age: " + rs.getString(3));
                System.out.println("Post: " + rs.getString(4));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void searchBookByAuthor(String author) {
        try {
            Connection connection = connectionToDB.getConnection();
            PreparedStatement search = connection.prepareStatement("SELECT * from book WHERE Author = '" + author + "'");
            ResultSet resultSet = search.executeQuery();

            while (resultSet.next()) {
                System.out.println("\nID: " + resultSet.getString(1));
                System.out.println("Title: " + resultSet.getString(2));
                System.out.println("Author: " + resultSet.getString(3));
                System.out.println("Year of release: " + resultSet.getString(4));
                System.out.println("Genre: " + resultSet.getString(5));
                System.out.println("Pages: " + resultSet.getString(6));
                System.out.println("Price: " + resultSet.getString(7));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("One book successfully searched\n");
        }
    }

    public void filterBookByPrice(int maxPrice) {
        try {
            Connection connection = connectionToDB.getConnection();
            PreparedStatement search = connection.prepareStatement("SELECT * from book WHERE Price < '" + maxPrice + "'");
            ResultSet resultSet = search.executeQuery();

            while (resultSet.next()) {
                System.out.println("\nID: " + resultSet.getString(1));
                System.out.println("Title: " + resultSet.getString(2));
                System.out.println("Author: " + resultSet.getString(3));
                System.out.println("Year of release: " + resultSet.getString(4));
                System.out.println("Genre: " + resultSet.getString(5));
                System.out.println("Pages: " + resultSet.getString(6));
                System.out.println("Price: " + resultSet.getString(7));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("One book successfully searched\n");
        }
    }

    public void deleteBookById(String fromTable, int id) {
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
