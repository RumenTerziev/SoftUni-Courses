package tasks;

import entities.Employee;
import utils.EntityManagerCreator;
import utils.LoggerManager;
import utils.interfaces.Logger;

import javax.persistence.EntityManager;
import java.util.List;

public class EmployeesSalaries04 {
    public static void solve() {

        Logger logger = LoggerManager.getLogger();

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

        logger.log(sb.toString().trim());
    }
}
