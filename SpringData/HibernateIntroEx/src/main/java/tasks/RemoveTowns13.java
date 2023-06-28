package tasks;

import entities.Address;
import entities.Town;
import utils.EntityManagerCreator;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.util.List;
import java.util.Scanner;

public class RemoveTowns13 {

    public static String solve() {


        EntityManager entityManager = EntityManagerCreator.getEntityManager();
        entityManager.getTransaction().begin();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter town name to remove from DB!");
        String searchedTown = scanner.nextLine();

        Town town;

        try {
            town = entityManager.createQuery("SELECT t FROM Town t WHERE t.name = :searchedTown", Town.class)
                    .setParameter("searchedTown", searchedTown)
                    .getSingleResult();

        } catch (NoResultException exception) {
            return "No town with given name was found!";
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

        return String.format("%d address in %s deleted", addresses.size(), searchedTown);
    }

}
