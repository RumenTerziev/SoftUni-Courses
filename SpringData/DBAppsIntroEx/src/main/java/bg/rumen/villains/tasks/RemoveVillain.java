package bg.rumen.villains.tasks;

import bg.rumen.villains.jdbc.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class RemoveVillain {

    private static final String GET_VILLAIN_NAME = "SELECT `name` FROM `villains` WHERE `id` = ?;";
    private static final String DELETE_VILLAIN = "DELETE FROM `villains` WHERE `id` = ?;";
    private static final String RELEASE_MINIONS = "DELETE FROM `minions_villains` WHERE `villain_id` = ?;";
    private static final String NAME_COLUMN = "name";

    public static void main(String[] args) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        Scanner scanner = new Scanner(System.in);
        int searchedId = Integer.parseInt(scanner.nextLine());

        connection.setAutoCommit(false);

        try {
            String villainName = getVillainName(connection, searchedId);
            int count = releaseMinions(connection, searchedId);
            deleteVillainById(connection, searchedId);
            connection.commit();
            System.out.printf("%s was deleted%n", villainName);
            System.out.printf("%d minions released", count);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            connection.rollback();
        }

        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    private static String getVillainName(Connection connection, Integer searchedId) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(GET_VILLAIN_NAME);
        preparedStatement.setInt(1, searchedId);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            return resultSet.getString(NAME_COLUMN);
        } else {
            throw new SQLException("No such villain was found");
        }
    }


    private static void deleteVillainById(Connection connection, Integer searchedId) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(DELETE_VILLAIN);
        preparedStatement.setInt(1, searchedId);
        preparedStatement.executeUpdate();
    }

    private static Integer releaseMinions(Connection connection, int searchedId) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(RELEASE_MINIONS);
        preparedStatement.setInt(1, searchedId);
        return preparedStatement.executeUpdate();
    }
}
