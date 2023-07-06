package tasks;

import entities.Employee;
import utils.EntityManagerCreator;
import utils.io.log.LoggerManager;
import utils.io.log.Logger;

import javax.persistence.EntityManager;
import java.util.List;

public class EmployeesFromDepartment05 {

    public static void solve() {

        Logger logger = LoggerManager.getLogger();

        String searchedDepartment = "Research and Development";

        EntityManager entityManager = EntityManagerCreator.getEntityManager();

        entityManager.getTransaction().begin();

        List<Employee> employees = entityManager.createQuery(
                        "SELECT e FROM Employee e WHERE e.department.name = :searchedDepartment " +
                                "ORDER BY e.salary, e.id", Employee.class)
                .setParameter("searchedDepartment", searchedDepartment)
                .getResultList();


        StringBuilder sb = new StringBuilder();
        employees.forEach(e -> sb.append(String.format("%s %s from %s - %s%n", e.getFirstName(),
                e.getLastName(),
                e.getDepartment().getName(),
                e.getSalary())));

        entityManager.getTransaction().commit();
        logger.log(sb.toString().trim());
    }
}
