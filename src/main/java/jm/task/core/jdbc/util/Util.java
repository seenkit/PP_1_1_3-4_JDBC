package jm.task.core.jdbc.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public final class Util {

    private static final Properties PROPERTIES = new Properties();

    public static void main(String[] args) {
    }

    static {
        loadProperties();
    }

    private Util() {
    }

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(PROPERTIES.getProperty("db.url"), PROPERTIES.getProperty("db.username"),
                    PROPERTIES.getProperty("db.password"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void loadProperties() {
        try (InputStream inputStream = Util.class.getClassLoader()
                .getResourceAsStream("application.properties")) {
            PROPERTIES.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
