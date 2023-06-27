package tasks;

import entities.Employee;
import entities.Project;
import utils.EntityManagerCreator;

import javax.persistence.EntityManager;
import java.util.Comparator;
import java.util.Scanner;

public class EmployeesWithProject08 {
    public static String solve() {

        EntityManager entityManager = EntityManagerCreator.getEntityManager();

        entityManager.getTransaction().begin();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter id to search by!");
        int searchedId = Integer.parseInt(scanner.nextLine());

        Employee employee = entityManager.createQuery("SELECT e FROM Employee e WHERE e.id = :searchedId", Employee.class)
                .setParameter("searchedId", searchedId)
                .getSingleResult();

        StringBuilder sb = new StringBuilder();

        sb.append(String.format("%s %s - %s%n", employee.getFirstName(), employee.getLastName(), employee.getJobTitle()));
        employee.getProjects()
                .stream()
                .sorted(Comparator.comparing(Project::getName))
                .forEach(p -> sb.append(String.format(p.getName())).append(System.lineSeparator()));

        entityManager.getTransaction().commit();
        return sb.toString().trim();
    }
}
