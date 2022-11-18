import model.Book;

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
            PreparedStatement insert = connection.prepareStatement("INSERT book (Title, Author, YearOFRelease, Genre, CountOfPage, Price) values ('" + book.getTitle() + "', '" +
                    book.getAuthor() + "', '" + book.getYearOfRelease() + "', '" + book.getGenre() + "', '" + book.getCountOfPages() +
                    "', '" + book.getPrice() + "')");

            insert.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Insert completed");
        }
    }

    public void showBooks(){
        try {
            Connection connection = connectionToDB.getConnection();
            PreparedStatement ps = connection.prepareStatement("Select * from book");
            ResultSet rs = ps.executeQuery();

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
}
