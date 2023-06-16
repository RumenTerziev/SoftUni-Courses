package bg.rumen.villains.tasks;

import bg.rumen.villains.jdbc.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ChangeTownsNameCasing {

    private static final String UPDATE_TOWNS = "UPDATE `towns` SET `name` = UPPER(`name`) WHERE `country` = ?;";
    private static final String GET_TOWNS = "SELECT `name` FROM `towns` WHERE `country` = ?;";
    private static final String NAME_COLUMN = "name";

    public static void main(String[] args) {
        Connection connection = ConnectionManager.getConnection();
        Scanner scanner = new Scanner(System.in);
        String townName = scanner.nextLine();

        try {
            PreparedStatement updateStatement = connection.prepareStatement(UPDATE_TOWNS);
            updateStatement.setString(1, townName);
            int count = updateStatement.executeUpdate();

            if (count == 0) {
                System.out.println("No town names were affected.");
                return;
            }

            System.out.printf("%d town names were affected.%n", count);

            PreparedStatement getTownsStatement = connection.prepareStatement(GET_TOWNS);
            getTownsStatement.setString(1, townName);
            ResultSet resultSet = getTownsStatement.executeQuery();

            List<String> townList = new ArrayList<>();
            while (resultSet.next()) {
                townList.add(resultSet.getString(NAME_COLUMN));
            }

            System.out.println("[" + String.join(", ", townList) + "]");


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
