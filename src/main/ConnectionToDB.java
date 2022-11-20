import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionToDB {
    public Connection getConnection() {
        try {
            String url = "jdbc:mysql://localhost/bookstore";
            String username = "root";
            String password = "Tap35seven_at";
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, username, password);
            System.out.println("Connection to Store DB successful");
            return conn;

        } catch (Exception ex) {
            System.out.println("Connection failed...");
            System.out.println(ex.getMessage());
        }
        return null;
    }
}