package bg.rumen.basicjdbc;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionManager {
    private String database;

    public ConnectionManager(String database) {
        this.database = database;
    }

    public Connection getConnection() {

        Connection connection;
        try {
            connection = doGetConnection();
        } catch (SQLException ex) {
            throw new RuntimeException(ex.getMessage());
        }
        return connection;
    }


    private Connection doGetConnection() throws SQLException {

        Properties connectionProps = new Properties();
        connectionProps.put("user", JDBCProps.USERNAME);
        connectionProps.put("password", JDBCProps.PASSWORD);
        String url = String.format(JDBCProps.URL, this.database);

        return DriverManager.getConnection(url, connectionProps);
    }
}