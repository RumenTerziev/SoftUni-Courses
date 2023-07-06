package tasks;

import entities.Address;
import entities.Town;
import utils.EntityManagerCreator;
import utils.io.log.LoggerManager;
import utils.io.read.ReaderManager;
import utils.io.log.Logger;
import utils.io.read.Reader;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.util.List;

public class RemoveTowns13 {


    private static final String MASSAGE = "Please enter town name to remove from DB!";

    public static void solve() {

        Reader reader = ReaderManager.getReader();
        Logger logger = LoggerManager.getLogger();

        logger.log(MASSAGE);
        String townToRemove = reader.readLine();

        EntityManager entityManager = EntityManagerCreator.getEntityManager();
        entityManager.getTransaction().begin();

        Town town;

        try {
            town = entityManager.createQuery("SELECT t FROM Town t WHERE t.name = :searchedTown", Town.class)
                    .setParameter("searchedTown", townToRemove)
                    .getSingleResult();

        } catch (NoResultException exception) {
            logger.log("No town with given name was found!");
            return;
        }

        List<Address> addresses = entityManager.createQuery(
                        "SELECT a FROM Address a WHERE a.town.id = :searchedId", Address.class)
                .setParameter("searchedId", town.getId())
                .getResultList();

        addresses.forEach(a -> a.getEmployees()
                .forEach(em -> em.setAddress(null)));

        addresses.forEach(entityManager::remove);
        entityManager.remove(town);

        entityManager.getTransaction().commit();

        logger.log(String.format("%d address in %s deleted", addresses.size(), townToRemove));
    }

}
