package bg.rumen.villains.tasks;

import bg.rumen.villains.jdbc.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;

public class GetVillainsName {

    private static final String QUERY = "SELECT `v`.`name`, " +
            "COUNT(DISTINCT `mv`.`minion_id`) AS `count` " +
            "FROM `villains` AS `v` " +
            "JOIN `minions_villains` AS `mv` ON `mv`.`villain_id` = `v`.`id` " +
            "GROUP BY `v`.`id`" +
            "HAVING `count` > 15 " +
            "ORDER BY `count` DESC;";


    private static final String NAME_COLUMN = "name";
    private static final String COUNT_COLUMN = "count";

    public static void main(String[] args) {
        Connection connection = ConnectionManager.getConnection();

        try {

            PreparedStatement statement = connection.prepareStatement(QUERY);

            ResultSet resultSet = statement.executeQuery();

            Map<String, Integer> villains = new LinkedHashMap<>();
            while (resultSet.next()) {
                String name = resultSet.getString(NAME_COLUMN);
                int countMinions = resultSet.getInt(COUNT_COLUMN);
                villains.put(name, countMinions);
            }

            for (Map.Entry<String, Integer> currentVillain : villains.entrySet()) {
                System.out.printf("%s %d%n", currentVillain.getKey(), currentVillain.getValue());
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
