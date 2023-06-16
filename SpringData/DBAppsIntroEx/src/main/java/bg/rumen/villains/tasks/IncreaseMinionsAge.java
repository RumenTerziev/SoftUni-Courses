package bg.rumen.villains.tasks;

import bg.rumen.villains.jdbc.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Scanner;

public class IncreaseMinionsAge {

    private static final String UPDATE_QUERY =
            "UPDATE `minions` SET `age` = `age` + 1, `name` = LOWER(`name`) WHERE `id` = ?;";

    private static final String GET_MINIONS = "SELECT `name`, `age` FROM `minions`;";
    private static final String NAME_COLUMN = "name";
    private static final String AGE_COLUMN = "age";

    public static void main(String[] args) throws SQLException {

        Scanner scanner = new Scanner(System.in);
        Connection connection = ConnectionManager.getConnection();


        connection.setAutoCommit(false);
        try {

            doUpdateMinions(connection, scanner);
            connection.commit();
            PreparedStatement preparedStatement = connection.prepareStatement(GET_MINIONS);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                System.out.printf("%s %d%n", resultSet.getString(NAME_COLUMN), resultSet.getInt(AGE_COLUMN));
            }


        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
            connection.rollback();
        }


        connection.close();

    }

    private static void doUpdateMinions(Connection connection, Scanner scanner) throws SQLException {

        int[] searchedIds = Arrays.stream(scanner.nextLine().split("\s+")).mapToInt(Integer::parseInt).toArray();

        for (int currentId : searchedIds) {

            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_QUERY);
            preparedStatement.setInt(1, currentId);
            preparedStatement.executeUpdate();

        }
    }
}
