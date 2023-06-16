package bg.rumen.villains.tasks;

import bg.rumen.villains.jdbc.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class AddMinion {

    private static final String INSERT_MINION = "INSERT INTO `minions`(`name`,`age`,`town_id`) VALUES(?, ?, ?);";
    private static final String INSERT_VILLAIN = "INSERT INTO `villains`(`name`, `evilness_factor`) VALUES(?, ?);";
    private static final String INSERT_TOWN = "INSERT INTO `towns`(`name`) VALUES(?);";
    private static final String INSERT_MINIONS_VILLAINS =
            "INSERT INTO `minions_villains`(`minion_id`, `villain_id`) VALUES(?, ?);";

    private static final String GET_TOWN_ID = "SELECT `id` FROM `towns` WHERE `name` = ?;";
    private static final String GET_VILLAIN_ID = "SELECT `id` FROM `villains` WHERE `name` = ?;";
    private static final String GET_MINION_ID = "SELECT `id` FROM `minions` WHERE `name` = ?;";
    private static final String ID_COLUMN = "id";


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Connection connection = ConnectionManager.getConnection();

        String firstLine = scanner.nextLine();
        String villainInfo = scanner.nextLine();

        String[] minionsInfo = firstLine.split(":\s+")[1].split("\s+");
        String minionName = minionsInfo[0];
        int minionAge = Integer.parseInt(minionsInfo[1]);
        String townName = minionsInfo[2];
        String villainName = villainInfo.split(":\s+")[1];


        int townId = getEntityId(connection, townName, GET_TOWN_ID);
        int villainId = getEntityId(connection, villainName, GET_VILLAIN_ID);


        if (townId == -1) {
            addTown(connection, townName);
            System.out.printf("Town %s was added to the database.%n", townName);
        }

        if (villainId == -1) {
            addVillain(connection, villainName);
            System.out.printf("Villain %s was added to the database.%n", villainName);
        }

        townId = getEntityId(connection, townName, GET_TOWN_ID);
        villainId = getEntityId(connection, villainName, GET_VILLAIN_ID);

        addMinion(connection, minionName, minionAge, townId);
        int minionId = getEntityId(connection, minionName, GET_MINION_ID);

        setMinionToVillain(connection, minionId, villainId);
        System.out.printf("Successfully added %s to be minion of %s.%n", minionName, villainName);

    }


    private static Integer getEntityId(Connection connection, String name, String query) {

        int id = -1;
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                id = resultSet.getInt(ID_COLUMN);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return id;
    }


    private static void addMinion(Connection connection, String minionName, Integer minionAge, Integer townId) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_MINION);
            preparedStatement.setString(1, minionName);
            preparedStatement.setInt(2, minionAge);
            preparedStatement.setInt(3, townId);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    private static void addTown(Connection connection, String townName) {

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_TOWN);
            preparedStatement.setString(1, townName);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


    private static void addVillain(Connection connection, String villainName) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_VILLAIN);
            preparedStatement.setString(1, villainName);
            preparedStatement.setString(2, "evil");
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    private static void setMinionToVillain(Connection connection, Integer minionId, Integer villainId) {

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_MINIONS_VILLAINS);
            preparedStatement.setInt(1, minionId);
            preparedStatement.setInt(2, villainId);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

}
