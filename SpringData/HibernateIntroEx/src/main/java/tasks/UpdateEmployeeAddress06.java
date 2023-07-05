package tasks;

import entities.Address;
import entities.Employee;
import utils.EntityManagerCreator;
import utils.LoggerManager;
import utils.ReaderManager;
import utils.interfaces.Logger;
import utils.interfaces.Reader;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

public class UpdateEmployeeAddress06 {

    private static final String MASSAGE = "Please enter last name to update an employee address!";

    public static void solve() {

        Reader reader = ReaderManager.getReader();
        Logger logger = LoggerManager.getLogger();

        logger.log(MASSAGE);
        String searchedLastName = reader.readLine();

        EntityManager entityManager = EntityManagerCreator.getEntityManager();

        entityManager.getTransaction().begin();

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

        logger.log(result);
    }
}
