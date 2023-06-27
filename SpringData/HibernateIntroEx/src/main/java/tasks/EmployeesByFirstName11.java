package tasks;

import utils.EntityManagerCreator;

import javax.persistence.EntityManager;

public class EmployeesByFirstName11 {

    public void solve() {

        EntityManager entityManager = EntityManagerCreator.getEntityManager();

        entityManager.getTransaction().begin();





        entityManager.getTransaction().commit();
    }
}
