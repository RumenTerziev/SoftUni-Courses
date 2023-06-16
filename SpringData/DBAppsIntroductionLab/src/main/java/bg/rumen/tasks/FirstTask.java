package bg.rumen.tasks;

import bg.rumen.basicjdbc.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class FirstTask {

    private static final String QUERY = "SELECT `first_name`, `last_name`, `salary` FROM `employees` WHERE `salary` > ?";
    private static final String DATABASE_NAME = "soft_uni";
    private static final String FIRST_NAME_COLUMN = "first_name";
    private static final String LAST_NAME_COLUMN = "last_name";

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double salaryToCompare = Double.parseDouble(scanner.nextLine());



        ConnectionManager connectionManager = new ConnectionManager(DATABASE_NAME);
        Connection connection = connectionManager.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY);

            preparedStatement.setDouble(1, salaryToCompare);

            ResultSet resultSet = preparedStatement.executeQuery();



            while (resultSet.next()) {
                System.out.println(resultSet.getString(FIRST_NAME_COLUMN) + " " + resultSet.getString(LAST_NAME_COLUMN));
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
