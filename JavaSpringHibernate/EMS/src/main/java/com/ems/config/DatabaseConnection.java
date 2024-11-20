package com.ems.config;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnection {
    private static Connection connection;

    private static String URL;
    private static String USERNAME;
    private static String PASSWORD;

    static {
        try {
            Properties prop = new Properties();
            prop.load(DatabaseConnection.class.getClassLoader().getResourceAsStream("db.properties"));

            URL = prop.getProperty("db.URL");
            USERNAME = prop.getProperty("db.USERNAME");
            PASSWORD = prop.getProperty("db.PASSWORD");
            //System.out.println("Connection established...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //private DatabaseConnection() {}

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
}
