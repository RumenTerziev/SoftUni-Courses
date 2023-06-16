package bg.rumen.tasks;

import bg.rumen.basicjdbc.ConnectionManager;
import bg.rumen.models.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TestTask {
    private static final String TEST_STATEMENT = "SELECT * FROM `employees` LIMIT 10;";
    private static final String DATABASE_NAME = "soft_uni";
    private static final String ID_COLUMN = "employee_id";
    private static final String FIRST_NAME_COLUMN = "first_name";
    private static final String LAST_NAME_COLUMN = "last_name";
    private static final String MIDDLE_NAME_COLUMN = "middle_name";
    private static final String JOB_TITLE_COLUMN = "job_title";
    private static final String DEPARTMENT_ID_COLUMN = "department_id";
    private static final String MANAGER_ID_COLUMN = "manager_id";
    private static final String HIRE_DATE_COLUMN = "hire_date";
    private static final String SALARY_COLUMN = "salary";
    private static final String ADDRESS_ID_COLUMN = "address_id";


    public static void main(String[] args) {
        ConnectionManager connectionManager = new ConnectionManager(DATABASE_NAME);
        Connection connection = connectionManager.getConnection();

        try {
            PreparedStatement testStatement = connection.prepareStatement(TEST_STATEMENT);
            ResultSet testSet = testStatement.executeQuery();

            List<Employee> employees = new ArrayList<>();

            while (testSet.next()) {
                Employee employee = new Employee();
                employee.setId(testSet.getInt(ID_COLUMN));
                employee.setFirstName(testSet.getString(FIRST_NAME_COLUMN));
                employee.setLastName(testSet.getString(LAST_NAME_COLUMN));
                employee.setMiddleName(testSet.getString(MIDDLE_NAME_COLUMN));
                employee.setJobTitle(testSet.getString(JOB_TITLE_COLUMN));
                employee.setDepartmentId(testSet.getInt(DEPARTMENT_ID_COLUMN));
                employee.setManagerId(testSet.getInt(MANAGER_ID_COLUMN));
                employee.setHireDate(testSet.getTimestamp(HIRE_DATE_COLUMN).toLocalDateTime());
                employee.setSalary(testSet.getDouble(SALARY_COLUMN));
                employee.setAddressId(testSet.getInt(ADDRESS_ID_COLUMN));
                employees.add(employee);
            }


            for (Employee employee : employees) {

                System.out.printf("%s -> %s%n", ID_COLUMN, employee.getId());
                System.out.printf("%s -> %s%n", FIRST_NAME_COLUMN, employee.getFirstName());
                System.out.printf("%s -> %s%n", LAST_NAME_COLUMN, employee.getLastName());
                System.out.printf("%s -> %s%n", MIDDLE_NAME_COLUMN, employee.getMiddleName());
                System.out.printf("%s -> %s%n", JOB_TITLE_COLUMN, employee.getJobTitle());
                System.out.printf("%s -> %d%n", DEPARTMENT_ID_COLUMN, employee.getDepartmentId());
                System.out.printf("%s -> %d%n", MANAGER_ID_COLUMN, employee.getManagerId());
                System.out.printf("%s -> %s%n", HIRE_DATE_COLUMN, employee.getHireDate());
                System.out.printf("%s -> %.4f%n", SALARY_COLUMN, employee.getSalary());
                System.out.printf("%s -> %d%n", ADDRESS_ID_COLUMN, employee.getAddressId());
                System.out.println();
                System.out.println("<<<---===NEXT EMPLOYEE!!!===--->>>");

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
