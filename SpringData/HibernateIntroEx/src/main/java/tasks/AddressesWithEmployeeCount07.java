package tasks;

import entities.Address;
import utils.EntityManagerCreator;

import javax.persistence.EntityManager;

public class AddressesWithEmployeeCount07 {

    public static String solve() {
        EntityManager entityManager = EntityManagerCreator.getEntityManager();

        StringBuilder stringBuilder = new StringBuilder();
         entityManager.createQuery(
                        "SELECT a FROM Address a ORDER BY a.employees.size DESC", Address.class)
                .setMaxResults(10)
                .getResultList()
                .forEach(a -> stringBuilder.append(String.format("%s %s - %d employees%n",
                        a.getText(),
                        a.getTown().getName(),
                        a.getEmployees().size())));

         return stringBuilder.toString().trim();
    }
}
