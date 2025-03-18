package com.duonghoang.cms_pratice.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtils {
    private static DBUtils instance;
    private Connection connection;

    private DBUtils() {
        Properties properties = new Properties();

        try {
            properties.load(
                    DBUtils.class.getResourceAsStream("/dbConfig.properties"));

            String url = properties.getProperty("url");
            String userName = properties.getProperty("user");
            String password = properties.getProperty("password");

            connection = DriverManager.getConnection(url, userName, password);

        } catch (SQLException | IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public static DBUtils getInstance() throws SQLException {
        if (instance == null || instance.getConnection().isClosed()) {
            instance = new DBUtils();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }

}
