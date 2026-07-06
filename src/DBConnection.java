import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    public static Connection getConnection() {
        Connection con = null;

        try {
            String url = "jdbc:mysql://localhost:3306/retail_sales";
            String username = "root";
            String password = "nimisql@123";

            con = DriverManager.getConnection(url, username, password);
            System.out.println("Connected successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }

        return con;
    }
}