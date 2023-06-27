package tasks;

import entities.Address;
import entities.Employee;
import utils.EntityManagerCreator;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdateEmployeeAddress06 {
    public static String solve() {

        Scanner scanner = new Scanner(System.in);

        EntityManager entityManager = EntityManagerCreator.getEntityManager();

        entityManager.getTransaction().begin();

        System.out.println("Please enter last name to update an employee address!");
        String searchedLastName = scanner.nextLine();
        String newAddressText = "Vitoshka 15";

        Address address = new Address();
        address.setText(newAddressText);

        entityManager.persist(address);

        String result;
        try {
            Employee employee = entityManager.createQuery("SELECT e FROM Employee e " +
                            "WHERE e.lastName = :searchedLastName", Employee.class)
                    .setParameter("searchedLastName", searchedLastName)
                    .getSingleResult();

            employee.setAddress(address);
            result = String.format("%s %s -> %s",
                    employee.getFirstName(),
                    employee.getLastName(),
                    employee.getAddress().getText());

        } catch (NoResultException exception) {
            result = "No employee with given last name was found in the database!";
        }

        entityManager.getTransaction().commit();

        return result;
    }
}
