package bg.rumen.miniorm.jdbc;

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
            throw new RuntimeException(ex);
        }
        return connection;
    }


    private static Connection doGetConnection() throws SQLException {

        Properties properties = new Properties();
        properties.setProperty("user", Props.USER);
        properties.setProperty("password", Props.PASSWORD);

        return DriverManager.getConnection(Props.URL, properties);
    }
}
