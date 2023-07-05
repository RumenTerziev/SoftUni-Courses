package tasks;

import entities.Employee;
import utils.EntityManagerCreator;
import utils.LoggerManager;
import utils.ReaderManager;
import utils.interfaces.Logger;
import utils.interfaces.Reader;

import javax.persistence.EntityManager;
import java.text.DecimalFormat;
import java.util.Comparator;
import java.util.List;

public class EmployeesByFirstName11 {

    private static final String MASSAGE = "Please enter a pattern to search by for employee's first name!";

    public static void solve() {

        Reader reader = ReaderManager.getReader();
        Logger logger = LoggerManager.getLogger();

        logger.log(MASSAGE);
        String pattern = reader.readLine();

        EntityManager entityManager = EntityManagerCreator.getEntityManager();

        entityManager.getTransaction().begin();

        List<Employee> employees = entityManager.createQuery(
                        "SELECT e FROM Employee e WHERE e.firstName LIKE CONCAT(:pattern, '%')", Employee.class)
                .setParameter("pattern", pattern)
                .getResultList();

        StringBuilder result = new StringBuilder();

        if (employees.size() < 1) {
            result.append("No employees with first name matching the given pattern were found!");
        } else {

            DecimalFormat df = new DecimalFormat("#.00");
            employees.stream()
                    .sorted(Comparator.comparing(Employee::getId))
                    .forEach(e -> result.append(String.format("%s %s - %s - (%s)%n",
                            e.getFirstName(),
                            e.getLastName(),
                            e.getJobTitle(),
                            df.format(e.getSalary()))));
        }

        entityManager.getTransaction().commit();

        logger.log(result.toString().trim());
    }
}
