package tasks;

import entities.Employee;
import entities.Project;
import utils.EntityManagerCreator;
import utils.io.log.LoggerManager;
import utils.io.read.ReaderManager;
import utils.io.log.Logger;
import utils.io.read.Reader;

import javax.persistence.EntityManager;
import java.util.Comparator;

public class EmployeesWithProject08 implements Task {

    private static final String MASSAGE = "Please enter id to search by!";

    public void solve() {

        Reader reader = ReaderManager.getReader();
        Logger logger = LoggerManager.getLogger();

        logger.log(MASSAGE);
        int searchedId = Integer.parseInt(reader.readLine());

        EntityManager entityManager = EntityManagerCreator.getEntityManager();

        entityManager.getTransaction().begin();

        Employee employee = entityManager.createQuery(
                "SELECT e FROM Employee e WHERE e.id = :searchedId", Employee.class)
                .setParameter("searchedId", searchedId)
                .getSingleResult();

        StringBuilder sb = new StringBuilder();

        sb.append(String.format("%s %s - %s%n", employee.getFirstName(), employee.getLastName(), employee.getJobTitle()));
        employee.getProjects()
                .stream()
                .sorted(Comparator.comparing(Project::getName))
                .forEach(p -> sb.append(String.format(p.getName())).append(System.lineSeparator()));

        entityManager.getTransaction().commit();
        logger.log(sb.toString().trim());
    }
}
