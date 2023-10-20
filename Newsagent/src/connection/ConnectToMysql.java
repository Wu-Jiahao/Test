package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectToMysql {

    public static final String URL = "jdbc:mysql://127.0.0.1:3306/NewsagentDB";
    public static final String USER = "root"; 
    public static final String PASSWORD = "Admin1234"; 
    public static final String DRIVER_CLASS = "com.mysql.cj.jdbc.Driver"; 

    public ConnectToMysql() {
    }

    public static void main(String[] args) {
        Connection connection = null;
        
        try {
            
            Class.forName(DRIVER_CLASS);
            
            
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            
            System.out.println("Connected to Database: " + connection);
        } catch (SQLException e) {
            System.out.println("ERROR: Unable to Connect to Database. " + e);
        } catch (ClassNotFoundException e) {
            System.out.println("ERROR: MySQL Driver not found. " + e);
        } finally {
            try {
                if (connection != null) {
                    connection.close(); 
                }
            } catch (SQLException e) {
                System.out.println("ERROR: Unable to close database connection. " + e);
            }
        }
    }
}
