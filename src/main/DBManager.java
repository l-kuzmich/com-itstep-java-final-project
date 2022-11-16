import model.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class DBManager {
    ConnectionToDB connectionToDB = new ConnectionToDB();

    public void insertBook(Book book) throws Exception{
        try{
            Connection connection = connectionToDB.getConnection();
            PreparedStatement insert = connection.prepareStatement("Insert into book values ('" + book.getId() + "', '" + book.getTitle() + "', '" +
                    book.getAuthor() + "', '" + book.getYearOfRelease() + "', '" + book.getGenre() + "', '" + book.getCountOfPages() +
                    "', '" + book.getPrice() + "')");

            insert.executeUpdate();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        finally {
            System.out.println("Insert completed");
        }
    }
}
