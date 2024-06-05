package subject1Java.java.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseHelper {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/t2208e";
    private static final String DRIVER_CLASS_NAME = "com.mysql.cj.jdbc.Driver";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";
    private static Connection connection;
    public static synchronized Connection getConnection(){
        if(connection == null){
            init();
        }
        return connection;
    }

    private static void init() {
        Connection newConnection = null;
        try {
            Class.forName(DRIVER_CLASS_NAME);
            newConnection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            if(newConnection != null){
                System.out.println("Connection successful");
            }
            else {
                System.err.println("Connection failed");
            }
        } catch (Exception e) {
            System.err.println("Exception: " + e.getMessage());
        }
        connection = newConnection;
    }
}