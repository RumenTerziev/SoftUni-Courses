package tasks;

import entities.Employee;
import utils.EntityManagerCreator;

import javax.persistence.EntityManager;
import java.util.List;

public class EmployeesSalaries04 {
    public static String solve() {

        EntityManager entityManager = EntityManagerCreator.getEntityManager();

        entityManager.getTransaction().begin();


            List<Employee> employees = entityManager.createQuery(
                            "SELECT e FROM Employee e WHERE e.salary > 50000", Employee.class)
                    .getResultList();

            StringBuilder sb = new StringBuilder();
        for (Employee employee : employees) {
            sb.append(employee.getFirstName())
                    .append(System.lineSeparator());
        }

        entityManager.getTransaction().commit();

        return sb.toString().trim();
    }
}
