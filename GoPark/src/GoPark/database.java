package GoPark;

import java.sql.Connection;
import java.sql.DriverManager;

public class database {
    public static Connection connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/gopark",
                "root",
                "your_password" // Replace with your MySQL password
            );
        } catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}







