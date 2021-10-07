package com.customer.db;

import com.mysql.jdbc.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static String userName = "root";
    private static String password = "1234";
    private static String url = "mysql:jdbc://localhost:3306/Customer";
    private static Connection connection;

    public static Connection getConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = (Connection) DriverManager.getConnection(url, userName, password);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Database connection is not success!!!");
        }
        return connection;
    }


}
