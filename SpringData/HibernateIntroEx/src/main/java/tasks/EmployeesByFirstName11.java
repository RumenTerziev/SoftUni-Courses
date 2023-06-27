package tasks;

import entities.Employee;
import utils.EntityManagerCreator;

import javax.persistence.EntityManager;
import java.text.DecimalFormat;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class EmployeesByFirstName11 {

    public static String solve() {

        EntityManager entityManager = EntityManagerCreator.getEntityManager();

        entityManager.getTransaction().begin();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter a pattern to search by for employee's first name!");
        String pattern = scanner.nextLine();


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

        return result.toString().trim();
    }
}
