package bg.rumen.villains.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionManager {

    public static Connection getConnection() {

        Connection connection;
        try {
          connection = doGetConnection();
        } catch (SQLException ex) {
            throw new RuntimeException(ex.getMessage());
        }
        return connection;
    }


    private static Connection doGetConnection() throws SQLException {
        Properties properties = new Properties();
        properties.put("user", JdbcProps.USERNAME);
        properties.put("password", JdbcProps.PASSWORD);

        return DriverManager.getConnection(JdbcProps.URL, properties);
    }
}
