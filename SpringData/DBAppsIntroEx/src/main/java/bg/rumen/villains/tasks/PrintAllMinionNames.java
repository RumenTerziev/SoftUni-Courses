package bg.rumen.villains.tasks;

import bg.rumen.villains.jdbc.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PrintAllMinionNames {

    private static final String GET_MINIONS = "SELECT `name` FROM `minions`;";
    private static final String NAME_COLUMN = "name";

    public static void main(String[] args) {
        Connection connection = ConnectionManager.getConnection();


        try {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_MINIONS);
            ResultSet resultSet = preparedStatement.executeQuery();


            List<String> allMinions = new ArrayList<>();
            while (resultSet.next()) {
                allMinions.add(resultSet.getString(NAME_COLUMN));
            }


            for (int index = 0; index < allMinions.size() / 2; index++) {
                System.out.println(allMinions.get(index));
                System.out.println(allMinions.get(allMinions.size() - 1 - index));
            }

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
}
