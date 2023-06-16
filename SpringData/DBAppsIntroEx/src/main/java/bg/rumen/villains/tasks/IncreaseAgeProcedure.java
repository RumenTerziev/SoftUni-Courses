package bg.rumen.villains.tasks;

import bg.rumen.villains.jdbc.ConnectionManager;

import java.sql.*;
import java.util.Scanner;

public class IncreaseAgeProcedure {

    private static final String CALL_PROCEDURE = "CALL usp_get_older(?);";
    private static final String GET_MINION = "SELECT `name`, `age` FROM `minions` WHERE `id` = ?;";

    private static final String NAME_COLUMN = "name";
    private static final String AGE_COLUMN = "age";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Connection connection = ConnectionManager.getConnection();
        int searchedId = Integer.parseInt(scanner.nextLine());

        try {
            doCallStatement(connection, searchedId);
            PreparedStatement preparedStatement = connection.prepareStatement(GET_MINION);
            preparedStatement.setInt(1, searchedId);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                System.out.printf("%s -> %d", resultSet.getString(NAME_COLUMN), resultSet.getInt(AGE_COLUMN));
            }


        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    private static void doCallStatement(Connection connection, Integer searchedId) throws SQLException {
        CallableStatement callableStatement = connection.prepareCall(CALL_PROCEDURE);
        callableStatement.setInt(1, searchedId);
        callableStatement.executeUpdate();
    }
}
