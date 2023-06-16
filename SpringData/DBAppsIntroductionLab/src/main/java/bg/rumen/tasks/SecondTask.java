package bg.rumen.tasks;

import bg.rumen.basicjdbc.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class SecondTask {

    private static final String DATABASE = "diablo";
    private static final String USERNAME = "user_name";
    private static final String FIRST_NAME = "first_name";
    private static final String LAST_NAME = "last_name";
    private static final String COUNT = "count";

    private static final String QUERY = """
            SELECT `u`.`user_name`,
            `u`.`first_name`,
            `u`.`last_name`,
            COUNT(`g`.`id`) AS `count`
            FROM `users` AS `u`
            JOIN `users_games` AS `ug` ON `ug`.`user_id` = `u`.`id`
            JOIN `games` AS `g` ON `ug`.`game_id` = `g`.`id`
            WHERE `u`.`user_name` = ?
            GROUP BY `u`.`id`;""";


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String searchedName = scanner.nextLine();

        ConnectionManager connectionManager = new ConnectionManager(DATABASE);
        Connection connection = connectionManager.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
            preparedStatement.setString(1, searchedName);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                System.out.printf("User: %s%n", resultSet.getString(USERNAME));
                System.out.printf("%s %s has played %d games", resultSet.getString(FIRST_NAME),
                        resultSet.getString(LAST_NAME),
                        resultSet.getInt(COUNT));
            } else {
                System.out.println("No such user exists");
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
