package bg.rumen.villains.tasks;

import bg.rumen.villains.jdbc.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class GetMinionNames {

    private static final String GET_VILLAIN_NAME = "SELECT `v`.`name` FROM `villains` AS `v` WHERE `v`.`id` = ?;";
    private static final String GET_MINIONS = """
            SELECT DISTINCT `m`.`id`, `m`.`name`, `m`.`age`
                        FROM `minions` AS `m`
                        JOIN `minions_villains` AS `mv` ON `mv`.`minion_id` = `m`.`id`
                        WHERE `mv`.`villain_id` = ?;""";
    private static final String NAME_COLUMN = "name";
    private static final String AGE_COLUMN = "age";

    public static void main(String[] args) {
        Connection connection = ConnectionManager.getConnection();
        Scanner scanner = new Scanner(System.in);

        int searchedVillainId = Integer.parseInt(scanner.nextLine());

        String searchedVillain = getVillainNameById(connection, searchedVillainId);
        if (searchedVillain == null) {
            System.out.println("No villain with ID 10 exists in the database.");
        } else {
            System.out.printf("Villain: %s%n", searchedVillain);

            Map<String, Integer> allMinions = getAllMinions(connection, searchedVillainId);
            int index = 1;
            for (Map.Entry<String, Integer> minion : allMinions.entrySet()) {
                System.out.printf("%d. %s %d%n", index, minion.getKey(), minion.getValue());
                index++;
            }
        }

        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    private static String getVillainNameById(Connection connection, Integer villainId) {
        String villainName = null;
        try {
            PreparedStatement statement = connection.prepareStatement(GET_VILLAIN_NAME);
            statement.setInt(1, villainId);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                villainName = resultSet.getString(NAME_COLUMN);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return villainName;
    }


    private static Map<String, Integer> getAllMinions(Connection connection, Integer searchedVillainId) {
        Map<String, Integer> minions = new LinkedHashMap<>();
        try {
            PreparedStatement statement = connection.prepareStatement(GET_MINIONS);
            statement.setInt(1, searchedVillainId);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String minionName = resultSet.getString(NAME_COLUMN);
                int minionAge = resultSet.getInt(AGE_COLUMN);
                minions.put(minionName, minionAge);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return minions;
    }
}
