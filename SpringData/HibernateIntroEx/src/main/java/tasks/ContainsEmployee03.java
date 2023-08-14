package tasks;

import entities.Employee;
import utils.EntityManagerCreator;
import utils.io.log.LoggerManager;
import utils.io.read.ReaderManager;
import utils.io.log.Logger;
import utils.io.read.Reader;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

public class ContainsEmployee03 implements Task {

    private static final String MASSAGE = "Please enter full name to search by!";

    public void solve() {

        Reader reader = ReaderManager.getReader();
        Logger logger = LoggerManager.getLogger();

        logger.log(MASSAGE);
        String fullName = reader.readLine();

        EntityManager entityManager = EntityManagerCreator.getEntityManager();

        entityManager.getTransaction().begin();


        String result;
        try {

           entityManager.createQuery(
                            "SELECT e FROM Employee e WHERE " +
                                    "CONCAT(e.firstName, ' ', e.lastName) LIKE :fullName", Employee.class)
                    .setParameter("fullName", fullName)
                    .getSingleResult();

            result = "Yes";

        } catch (NoResultException exception) {
            result = "No";
        }

        entityManager.getTransaction().commit();

        logger.log(result);
    }
}
