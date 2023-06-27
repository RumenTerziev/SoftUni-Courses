package tasks;

import entities.Employee;
import utils.EntityManagerCreator;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.util.Scanner;

public class ContainsEmployee03 {
    public static String solve() {
        Scanner scanner = new Scanner(System.in);

        EntityManager entityManager = EntityManagerCreator.getEntityManager();

        entityManager.getTransaction().begin();

        System.out.println("Please enter full name to search by!");
        String fullName = scanner.nextLine();

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

        return result;
    }
}
